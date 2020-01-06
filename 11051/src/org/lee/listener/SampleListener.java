package org.lee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SampleListener implements ServletContextListener {

    public SampleListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { //이게 종료된다면
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    
    }

    public void contextInitialized(ServletContextEvent sce)  { //이게 실행되기 시작하면
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    
    }
	
}
