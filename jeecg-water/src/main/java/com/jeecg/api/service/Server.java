package com.jeecg.api.service;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jeecg.api.service.socket.DataUtils;
import com.jeecg.api.service.socket.SocketTcpServerManager;

public class Server {
	/**
	 * 要处理客户端发来的对象，并返回一个对象，可实现该接口。
	 */
	public interface ObjectAction {
		Object doAction(Object rev);
	}

	public static final class DefaultObjectAction implements ObjectAction {
		public Object doAction(Object rev) {
			System.out.println("处理并返回：" + rev);
			return rev;
		}
	}

	public static void main(String[] args) {
		int port = 5000;
		Server server = new Server(port);
		server.start();
	}

	private int port;
	private volatile boolean running = false;
	private long receiveTimeDelay = 300000;
	private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class, ObjectAction>();
	private Thread connWatchDog;

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		if (running)
			return;
		running = true;
		connWatchDog = new Thread(new ConnWatchDog());
		connWatchDog.start();
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		if (running)
			running = false;
		if (connWatchDog != null)
			connWatchDog.stop();
	}

	public void addActionMap(Class<Object> cls, ObjectAction action) {
		actionMapping.put(cls, action);
	}

	class ConnWatchDog implements Runnable {
		public void run() {
			try {
				ServerSocket ss = new ServerSocket(port, 5000);
				while (running) {
					Socket s = ss.accept();
					ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
					cachedThreadPool.execute(new SocketAction(s));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
				Server.this.stop();
			}

		}
	}

	class SocketAction implements Runnable {
		Socket socket;
		boolean run = true;
		long lastReceiveTime = System.currentTimeMillis();

		public SocketAction(Socket s) {
			this.socket = s;
		}

		public void run() {
			while (running && run) {
				if (System.currentTimeMillis() - lastReceiveTime > receiveTimeDelay) {
					overThis();
				} else {
					try {
							
						 BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
	                     DataInputStream dis = new DataInputStream(bis);
	                     byte[] bytes = new byte[1]; // 一次读取一个byte
	                     String ret = "";  
	                     SocketTcpServerManager socketTcpserver = new SocketTcpServerManager();
	                     while (dis.read(bytes) != -1) {
	                        ret += DataUtils.bytesToHexString(bytes);
	                      
	                        if (dis.available() == 0) { //一个请求
	                        	socketTcpserver.handleReceiveData(ret, socket);
	                            ret = "";
	                        }
	                     }
						
						}catch (Exception e) {
						e.printStackTrace();
						overThis();
					}
				}
			}
		}

		private void overThis() {
			if (run)
				run = false;
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("关闭：" + socket.getRemoteSocketAddress());
		}

	}
}
