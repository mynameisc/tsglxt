package org.tsglxt.seversocket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.tsglxt.biz.LsdBiz;
import org.tsglxt.javebean.*;

public class receive {
//	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader; 

	    public static BlockingQueue<Lsd> bqmessage=new LinkedBlockingQueue<Lsd> ();
	    public static BlockingQueue<String> bqsos=new LinkedBlockingQueue<String> ();
	    public static ExecutorService cachedThreadPool;
	    public static ServerSocket  SocketServer;
	    public static  Thread thread1,thread2;
public static void init(){
	cachedThreadPool = Executors.newCachedThreadPool();  
	try {
		SocketServer=new ServerSocket (1080);
		System.out.println("开始监听1080端口");
		Socket socket;
		thread1=new Thread(new SaveThread());
		cachedThreadPool.execute(thread1);
		while((socket=SocketServer.accept())!=null){//阻塞等待设备连接
			System.out.println(socket.getRemoteSocketAddress()+"设备链接");
			cachedThreadPool.execute(new Thread(new ReceiveThread(socket)));
			//如果有设备连接开启一个新的线程去接受数据。
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			if(SocketServer!=null)
			SocketServer.close();
			if(cachedThreadPool!=null)
				cachedThreadPool.shutdown();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public static void shutdown(){
	if(cachedThreadPool!=null)
	{
		cachedThreadPool.shutdown();
	}
	if(SocketServer!=null)
	{
		try {
			SocketServer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

 static class ReceiveThread implements Runnable{
 public Socket mSocket;
 public InputStreamReader inputStreamReader;
 public OutputStreamWriter outputStreamWriter;
 public  ReceiveThread(Socket mSocket ){
	 
	 System.out.println("创建了新的接收线程");
	  if(mSocket==null)
		  return;
	  if(mSocket.isClosed())
		  return;
	  this.mSocket=mSocket;
	  try {
		inputStreamReader=new InputStreamReader(mSocket.getInputStream());
	    outputStreamWriter =new OutputStreamWriter(mSocket.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
  }
  
	@Override
	public void run() {
		  if(mSocket==null)
			  return;
		  if(mSocket.isClosed())
			  return;
		  
		  char[] b=new char[50];
		  
		  int t=0;
		
		  try {
			while((t=inputStreamReader.read(b))!=-1){
				
				String str=new String(b);
				str=str.trim();
				System.out.println(str);
				if(str.subSequence(0, 1).equals("*"))
				{
					if(str.subSequence(str.length()-1, str.length()).equals("#"))
					{
						str=str.substring(1, str.length()-1);
						String[] strs=str.split(",");
						Lsd lsd=new Lsd();
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
						Date date=new Date();
						String time= simpleDateFormat.format(date);
						lsd.setBooK_fromid(strs[0]);
						lsd.setBook_rfid(strs[1]);
						lsd.setBook_time(time);
						if(strs==null)
							continue;
						if(strs.length!=2)
							continue;
	
	                    bqmessage.put(lsd);//如果里面没有空间就调用此方法，发生阻塞然后将m放到队列里
					}
					
				}
				for(int k=0;k<50;k++)
				{
					b[k]='\0';
				}
				
			  }
			 
		  	} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
		  	System.out.println(e);
			e.printStackTrace();
		} 
	    finally {
		  try {
				if(inputStreamReader!=null)
				{
					System.out.println("inputclose");
					inputStreamReader.close();
				}
				if(outputStreamWriter!=null)
				{
					System.out.println("outputclose");
					outputStreamWriter.close();
				}
				if(mSocket!=null)
				{
					mSocket.close();
				}
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
} 


 static class SaveThread implements Runnable{

	@Override
	public void run() {
		Lsd lsd=null;
		
		try {
			while((lsd=bqmessage.take())!=null){
				LsdBiz lsdBiz=new LsdBiz();
				int i=lsdBiz.addLsdmessage(lsd);
				if(i!=0)
				{
					
					System.out.println("存入成功");
				}else {
					System.out.println("存入失败");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 
} 
 
 
 static class SaveSosThread implements Runnable{

	@Override
	public void run() {}
	 
	 
	 
 } 
public static void main(String arg[]){
   init();
	
	}
}
