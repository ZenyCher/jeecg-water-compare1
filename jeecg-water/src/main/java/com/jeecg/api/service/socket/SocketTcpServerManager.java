package com.jeecg.api.service.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.util.TextUtils;
import org.apache.log4j.Logger;

import com.jeecg.api.util.SpringContextUtils;
import com.jeecg.waterdispenser.entity.WRechargeEntity;
import com.jeecg.waterdispenser.entity.WWaterMeterEntity;
import com.jeecg.waterdispenser.entity.WWaterOpenEntity;
import com.jeecg.waterdispenser.entity.WWriterRecordEntity;
import com.jeecg.waterdispenser.service.WRechargeServiceI;
import com.jeecg.waterdispenser.service.WWaterMeterServiceI;
import com.jeecg.waterdispenser.service.WWaterOpenServiceI;
import com.jeecg.waterdispenser.service.WWriterRecordServiceI;
import com.jeecg.waterdispenser.util.SecurityUtil;

/**
 * Created by foreveross_tangyouhua on 2017/6/1.
 * 描述：
 */

public class SocketTcpServerManager{
	
	private static final Logger logger = Logger.getLogger(SocketTcpServerManager.class);
	
    private static final String TAG = SocketTcpServerManager.class.getSimpleName();

    /**
     * 新socket连接通知广播
     */
    public static final String SCOKET_CONNECT_BROADCAST = "scoket_connect_broadcast";
    /**
     * socketserver创建成功
     */

    private static SocketTcpServerManager instance;

    private ServerSocket server = null;

    public static HashMap<String, Socket> socketMap = new HashMap<String, Socket>();

    private ExecutorService clientCachedThreadPool;

    private ArrayList<ReceivedDataListener> receiveDataListeners = new ArrayList<ReceivedDataListener>();

    public void addReceiveDataListener(ReceivedDataListener receiveDataListener) {
        if (receiveDataListener != null)
            this.receiveDataListeners.add(receiveDataListener);
    }

    public SocketTcpServerManager() {
        clientCachedThreadPool = Executors.newCachedThreadPool();
    }

    public static SocketTcpServerManager getInstance() {
        if (instance == null) {
            synchronized (SocketTcpServerManager.class) {
                if (instance == null) {
                    instance = new SocketTcpServerManager();
                }
            }
        }
        return instance;
    }

    /**
     * 根据表编号查询对应的socket连接
     *
     * @param meterNo
     */
    public Socket getSocket(String meterNo) {
       /* if (TextUtils.isEmpty(meterNo)) {
            return null;
        }
        if (socketMap != null && socketMap.size() > 0) {
            Socket socket = socketMap.get(meterNo);
            if (socket != null && socket.isConnected()) {
                return socket;
            } else {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                socketMap.remove(meterNo);
            }

        }*/
    	Socket socket = SecurityUtil.getSocketValue(meterNo);
    	logger.info("获取存储的socket:" + socket);
    	 if (socket != null && socket.isConnected()) {
             return socket;
         } else {
             if (socket != null) {
                 try {
                     socket.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }

        return null;
    }

    public void closeServer() {
//        handler.sendEmptyMessage(SOCKET_SERVER_CLOSE);
        if (socketMap != null && socketMap.size() > 0) {
            Set<String> keySet = socketMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Socket socket = socketMap.get(key);
                if (socket != null) {
                    try {
                        socket.shutdownInput();
                        socket.shutdownOutput();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            socketMap.clear();
        }

        if (server != null) {
            try {
                server.close();
            } catch (Exception e) {
                logger.debug(TAG + ":" + e.toString());
            }
        }
        server = null;
    }

    class Receicer implements Runnable {
        private Socket socket;


        public Receicer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            if (socket != null && socket.isConnected()) {

                try {
                    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                    DataInputStream dis = new DataInputStream(bis);
                    byte[] bytes = new byte[1]; // 一次读取一个byte
                    String ret = "";
//                    Message msg = handler.obtainMessage();
//                    msg.what = READ;
//                    msg.obj = socket;
//                    handler.sendMessage(msg);
                    while (dis.read(bytes) != -1) {
                        ret += DataUtils.bytesToHexString(bytes);
                        if (dis.available() == 0) { //一个请求
                            handleReceiveData(ret, socket);
                            ret = "";
                        }
                    }
                } catch (Exception e) {
                    logger.debug(TAG + ":" + e.toString());
                } finally {
                    closeSocket(socket);
                }
            } else {
                closeSocket(socket);
            }
        }
    }

    /**
     * 关闭客户端socket
     *
     * @param socket
     */
    private void closeSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取当前连接的所有表名
     */
    public ArrayList<String> getMeterNos() {
        ArrayList<String> list = null;
        if (socketMap != null && socketMap.size() > 0) {
            list = new ArrayList<String>();
            Set<String> keySet = socketMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                list.add(key);
            }
        }
        return list;
    }


    /**
     * 发送指令
     *
     * @param meterNo
     */
    public void sendCommand(String meterNo, SocketSendData sendData) {

        if (TextUtils.isEmpty(meterNo)) {
            return;
        }
        Socket socket = getSocket(meterNo);
        sendCommand(sendData, socket);
    }


    /**
     * @param sendData
     * @param socket
     */
    public void sendCommand(SocketSendData sendData, Socket socket) {
        if (socket != null && socket.isConnected()) {
            clientCachedThreadPool.execute(new Send(socket, sendData));
        }
    }


    class Send implements Runnable {
        private Socket socket;
        private SocketSendData sendData;

        public Send(Socket socket, SocketSendData sendData) {
            this.socket = socket;
            this.sendData = sendData;
        }

        @Override
        public void run() {
            if (socket != null && socket.isConnected()) {
            	try {
					socket.setKeepAlive(true);
				} catch (SocketException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                try {
                    byte[] sendDataBytes = null;
                    if ((sendData != null) && ((sendDataBytes = sendData.getContent()) != null)) {
                    	
                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                        DataOutputStream dos = new DataOutputStream(bos);
                        logger.debug("发送数据:" + DataUtils.bytesToHexString(sendDataBytes) + "socket:" + socket );
                        if (sendDataBytes != null) {
                            dos.write(sendDataBytes);
                        }
                        dos.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
               
            }
        }
    }


    public void handleReceiveData(String ret, Socket socket) {
    	logger.info("接收到的消息:" + ret + "socket:" + socket);
        SocketReceiveData receiveData = getReceiveData(ret, socket);
        if (receiveData == null) {
            return;
        }
        String meterNo = receiveData.getMeterNo();
        sendBizDeal(meterNo);
        if(ret.length() == 32 && ret.startsWith("fefefe5353535342")){
        	//成功写水
        	handleSuccessWriteWater(ret.substring(16, 24));
        }
        /*if (handleHeart(receiveData)) {
        	//处理心跳包逻辑
        	SecurityUtil.setHeartBeep(meterNo);
        	System.out.println("水表编号：" + DataUtils.reverseStr(meterNo));
        	sendBizDeal(meterNo);
        	//解析心跳包指令
        	
        	
//        	SocketSendBiz.sendWriteWater(meterNo, "20");
        	//处理写表逻辑
//        	handleWriteWater(meterNo);
        	//检查是否有开关阀操作
//        	checkOpenOrClose(meterNo);
//        	SocketSendBiz.sendClose(receiveData.getMeterNo(), false);
//        	SocketSendBiz.sendOpen(receiveData.getMeterNo(), false);
//        	SocketSendBiz.sendReadMeter(receiveData.getMeterNo(), false);
//        	SocketSendBiz.sendSettingMeter(receiveData.getMeterNo(), SocketSendComand.SettingFunctionCommand.SETTING_READ, DataUtils.hexStringToBytes("0020"), false);
        	
        }*/
        if(handleWarn(receiveData)) {
        	//处理告警逻辑
        	logger.info("处理告警逻辑");
        	String warnCommand = receiveData.getCommand().substring(10, receiveData.getCommand().length());
        	if("00".equalsIgnoreCase(warnCommand)) {
        		return ;
        	}else {
        		//记录告警状态
            	WWaterMeterServiceI  waterMeterService = SpringContextUtils.getWwaterMeterService();
            	WWaterMeterEntity entity = waterMeterService.findUniqueByProperty(WWaterMeterEntity.class, "waterId", DataUtils.reverseStr(meterNo));
            	if(null != entity) {
            		//记录告警信息
            		entity.setWaterValue(1);
            	}
            	try {
					waterMeterService.save(entity);
				} catch (Exception e) {
					logger.info("保存水表的告警记录失败");
					e.printStackTrace();
				}
        		//发送关闭告警指令
        		SocketSendBiz.sendWarnReply(receiveData.getMeterNo());
        	}
        	
        }
        if(receiveData.getCommand().equalsIgnoreCase(SocketSendComand.READ)){
        	logger.info("处理读表逻辑");
        	SocketReceiveBiz biz = new SocketReceiveBiz();
        	biz.handleReadMeterData(receiveData);
        }
        if (receiveDataListeners != null) {
            for (ReceivedDataListener receiveDataListener : receiveDataListeners) {
                if (receiveDataListener != null) {
                    receiveDataListener.onReceived(receiveData);
                }
            }
        }

    }


    public interface ReceivedDataListener {
        public void onReceived(SocketReceiveData receiveData);
    }


    /**
     * 收到的消息进行封装，封装对象前校验是否正确
     *
     * @return 正确校验返回SocketReceiveData对象，否则返回空
     */
    private SocketReceiveData getReceiveData(String ret, Socket socket) {
        SocketReceiveData receiveData = null;
        if (TextUtils.isEmpty(ret)) {
            return null;
        }
        try {
            String header = DataUtils.bytesToHexString(SocketReceiveData.HEADER_DATA.getBytes("utf-8"));
            if (ret.indexOf(header) != -1 && (ret.indexOf(header) + header.length() < ret.length() - 6)) {
                String content = ret.substring(ret.indexOf(header) + header.length(), ret.length() - 6);
                String crcStr = ret.substring(ret.length() - 6, ret.length() - 2);
                if (DataUtils.bytesToHexString(SocketDataCRC.getCRCData(DataUtils.hexStringToBytes(content))).equalsIgnoreCase(crcStr)) {
                    receiveData = new SocketReceiveData();
                    receiveData.setCrcData(crcStr);
                    receiveData.setValidData(content);
                    receiveData.setMeterNo(content.substring(0, 8));
                    receiveData.setCommand(content.length() > 8 ? content.substring(8, 10) : "");
                    savaClientSocket(socket, receiveData.getMeterNo());
                    return receiveData;
                }
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return receiveData;
    }


    /**
     * 处理心跳包
     *
     * @param receiveData
     * @return
     */
    private boolean handleHeart(SocketReceiveData receiveData) {
        return (receiveData != null) && (!TextUtils.isEmpty(receiveData.getValidData())) && (receiveData.getValidData().length() == 8);
    }
    
    private boolean handleWarn(SocketReceiveData receiveData) {
    	return (receiveData != null) && (!TextUtils.isEmpty(receiveData.getValidData())) && (receiveData.getValidData().length() == 12);
    }
    
    /**
     * 处理写表逻辑
     * @param meterNo 
     */
    private static void handleWriteWater(String meterNo) {
    	logger.info("处理写表逻辑.........." + meterNo);
    	WRechargeServiceI wRechargeService = SpringContextUtils.getWRechargeService();
//    	WWriterRecordServiceI wWriterRecordService = SpringContextUtils.getWWriterRecordServiceI();
    	WRechargeEntity rechargeEntity =  wRechargeService.getWriteWaterInfoById(DataUtils.reverseStr(meterNo));
    	if(null != rechargeEntity) {
    		//获取写水水量
    		Integer water = rechargeEntity.getRechargeWater();
    		SocketSendBiz.sendWriteWater(meterNo, Integer.toString(water));
    		rechargeEntity.setIsWater(2);//0 未写 1 已写 2写水中
    		wRechargeService.updateEntitie(rechargeEntity);
    		
    	}
    }
    
    /**
     * 处理开阀或者关阀
     * @param meterNo
     */
    private void checkOpenOrClose(String meterNo) {
    	WWaterOpenServiceI  waterOpenService = SpringContextUtils.getWaterOpenService();
    	WWaterOpenEntity entity = waterOpenService.findUniqueByProperty(WWaterOpenEntity.class, "waterId", DataUtils.reverseStr(meterNo));
    	if(null == entity) {
    		logger.info("无开关阀操作....,水表编号：" + DataUtils.reverseStr(meterNo));
    		return ;
    	}else {
    		if(entity.getWaterOpenType() == 0) {
    			//开阀
    			SocketSendBiz.sendOpen(meterNo, false);
    			logger.info("开阀,水表编号:" + DataUtils.reverseStr(meterNo));
    		}else {
    			//关阀
    			SocketSendBiz.sendClose(meterNo, false);
    			logger.info("关阀,水表编号:" + DataUtils.reverseStr(meterNo));
    			WWaterMeterServiceI  waterMeterService = SpringContextUtils.getWwaterMeterService();
            	WWaterMeterEntity waterMeterEntity = waterMeterService.findUniqueByProperty(WWaterMeterEntity.class, "waterId", DataUtils.reverseStr(meterNo));
            	if(null != waterMeterEntity) {
            		//关阀之后将本次告警记录取消
            		waterMeterEntity.setWaterValue(0);
            	}
            	try {
					waterMeterService.saveOrUpdate(waterMeterEntity);
				} catch (Exception e) {
					logger.info("关阀之后，清除告警记录失败:" +e.getMessage());
					e.printStackTrace();
				}
    		}
			try {
				waterOpenService.delete(entity);
			} catch (Exception e) {
				logger.info("删除水表操作记录失败:" + e.getMessage());
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * 写水成功之后，更新是否写水
     * @param meterNo
     */
    private void handleSuccessWriteWater(String meterNo){
    	WRechargeServiceI wRechargeService = SpringContextUtils.getWRechargeService();
    	WWriterRecordServiceI wWriterRecordService = SpringContextUtils.getWWriterRecordServiceI();
    	WRechargeEntity rechargeEntity =  wRechargeService.getWriteWaterInfoById(DataUtils.reverseStr(meterNo));
    	if(null != rechargeEntity){
    		//写水之后更新是否写水字段
    		rechargeEntity.setIsWater(1);//0 未写 1 已写 2写水中
    		wRechargeService.updateEntitie(rechargeEntity);
    		//记录写水
    		WWriterRecordEntity entity = new WWriterRecordEntity();
    		entity.setWaterId(DataUtils.reverseStr(meterNo));
    		entity.setMemberPhone(rechargeEntity.getMemberPhone());
    		Integer water = rechargeEntity.getRechargeWater();
    		entity.setWaterNum(water + "");
    		try {
    			wWriterRecordService.save(entity);
    		} catch (Exception e) {
    			logger.error("保存写水记录失败：" + e.getMessage());
    			e.printStackTrace();
    		}
    		logger.info("写水操作，写入水量：" + water);
    	}

    }
    /**
     * 处理发送指令操作
     * @param meterNo
     * @return
     */
    private void sendBizDeal(String meterNo){
    	
    	int operate = SecurityUtil.getOperateValue(meterNo);
    	Socket socket = SecurityUtil.getSocketValue(meterNo);
    	
    	if(null == socket){
    		return ;
    	}
//    	SocketSendBiz.sendReadMeter(meterNo, false);
    	/*checkOpenOrClose(meterNo);
    	logger.info("operate :" + operate);
   	 	SocketSendBiz.sendReadMeter(meterNo, false);
    	
		logger.info("发送读表指令,水表编号" + DataUtils.reverseStr(meterNo));*/
	/*	logger.info("检查是否需要开关阀逻辑.....");
		checkOpenOrClose(meterNo);
		
		logger.info("检查是否需要写表逻辑.....");
		handleWriteWater(meterNo);*/
		
    	logger.info("operate:" + operate);
//    	if(operate == 0){
//    		//发送读表指令
//    		SocketSendBiz.sendReadMeter(meterNo, false);
//    		
//    		logger.info("发送读表指令,水表编号" + DataUtils.reverseStr(meterNo));
//    		return ;
//    	}
//    	if(operate == 1){
//    		//检查是否需要开关阀
//    		checkOpenOrClose(meterNo);
//    		return ;
//    	}
//    	if(operate == 1){
//    		//检查是否需要写表
//    		logger.info("检查是否需要写表逻辑.....");
//    		handleWriteWater(meterNo);
//    		return ;
//    	}
    	//读表
//    	SocketSendBiz.sendReadMeter(meterNo, false);
    	//间隔2毫秒之后检查写水，并且写水
    	checkOpenOrClose(meterNo);
    	
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			logger.error("线程休息异常");
			e.printStackTrace();
		}
    	handleWriteWater(meterNo);
    	
    }

    /**
     * 保存socket连接
     *
     * @param socket
     * @param meterNo
     * @throws IOException
     */
    private void savaClientSocket(Socket socket, String meterNo) throws IOException {
        
    	if(socket == null){
            return;
        }
    	
    	SecurityUtil.setSocketValue(meterNo, socket);
        /*if (socketMap != null) {
            Socket socket1 = socketMap.get(meterNo);
            if (socket1 != null && socket1.isConnected()) {
                if (socket != socket1) {
                    socket1.close();
                    socketMap.put(meterNo, socket);
                }
            } else {
                if (socket1 != null) {
                    socket1.close();
                }
                socketMap.put(meterNo, socket);
            }
        }*/
    }
    
    public static void main(String[] args) {
//    	SocketSendBiz.sendReadMeter("01000000", false);
//    	SocketSendBiz.sendSettingMeter("01000000",SocketSendComand.SettingFunctionCommand.SETTING_PRICE,DataUtils.hexStringToBytes("0020"),false);
//    	handleWriteWater("00000001");
//    	String str = "fefefe53535353421202604053679445";
//    	String meterNo = str.substring(16, 24);
//    	System.out.println(meterNo);
    	System.out.println(DataUtils.reverseStr("12026040"));
	}
}
