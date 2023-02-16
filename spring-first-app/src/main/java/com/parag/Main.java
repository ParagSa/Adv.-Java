package com.parag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.parag.comp.MyBean;

public class Main {
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		ApplicationContext appCntx = new ClassPathXmlApplicationContext("cfg.xml");
         MyBean mb =   (MyBean)appCntx.getBean("my");
         System.out.println(mb.getMsg());
	}

}
