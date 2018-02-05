package com.jeecg.api.service.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TestReceicer {
	
	
	public static void main(String[] args) {
		System.out.println("=============");
		createSocket("172.31.32.160" ,5000);
	}
	
	public static void createSocket(String host ,int port){
		Socket socket = null;
		BufferedWriter out = null;
		BufferedReader br = null;
		
		while (true) {	
		try {
			 Thread.sleep(1000);
			 socket = new Socket(host, port);
			 //接收键盘输入 
			 System.out.println("请你输入要查询的水表 : ");
			 br = new BufferedReader(new InputStreamReader(System.in));
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write(socket+br.readLine()+"\r\n");
			out.flush(); // 缓冲流必须刷新才可以发送出去
			
			new ClientReader(socket).start();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
					
		  }		  
		}
	}
	
	

	class ClientReader extends Thread{
		private Socket socket;
		public ClientReader(Socket socket){
			this.socket = socket;
		}		
		@Override
		public void run() {
			 try {
					// 读取当前客户端发送的数据  
					InputStream is = socket.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
					System.out.println(socket.getRemoteSocketAddress()+br.readLine());
			 }catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
	

}
