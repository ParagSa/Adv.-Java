package com.parag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.parag.dao.MyBean;
import com.parag.service.MyService;

public class Main {
	public static void main(String[]args) {
		// TODO Auto-generated method stub;
		ApplicationContext appCntx = new ClassPathXmlApplicationContext("cfg.xml");
       MyService ms = (MyService)appCntx.getBean("serv");
        ms.add();
       
        
	}

}
