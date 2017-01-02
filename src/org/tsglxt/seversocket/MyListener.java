package org.tsglxt.seversocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.tsglxt.seversocket.*;
@WebListener
public class MyListener  implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		new Thread(new EndThread()).start();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		new Thread(new StartThread()).start();
		
	}
	 static class StartThread implements Runnable{

			@Override
			public void run() {
				receive.init();
			}
			 
		 } 
	 static class EndThread implements Runnable{

			@Override
			public void run() {
				receive.shutdown();
			}
		 } 

}
