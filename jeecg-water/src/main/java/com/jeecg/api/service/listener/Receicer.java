package com.jeecg.api.service.listener;

import java.net.ServerSocket;

import org.apache.log4j.Logger;

import com.jeecg.api.service.Server;

public class Receicer{
    
    private static final Logger logger = Logger.getLogger(Receicer.class);
    
    
    /**
     * 端口
     * */
    private int port = 5000;
    
    public Receicer(ServerSocket serverSocket) {   	   	      
         if (serverSocket == null){
             try {
            	 Server server = new Server(port);
            	 server.start();
            	 logger.info("start server .... port:" + port);
             }catch(Exception e) {
                 e.printStackTrace();
             }
         }
    	
    }  
    
        
    
 }
