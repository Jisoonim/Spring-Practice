package org.lee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SampleListener implements ServletContextListener {

    public SampleListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { //�̰� ����ȴٸ�
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    	System.out.println("downed.................");
    
    }

    public void contextInitialized(ServletContextEvent sce)  { //�̰� ����Ǳ� �����ϸ�
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    	System.out.println("Started.............");
    
    }
	
}
