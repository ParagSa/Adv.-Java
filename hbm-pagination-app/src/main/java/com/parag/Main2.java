package com.parag;



import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.parag.model.Employee;

public class Main2 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr =  ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
          Session s= sf.openSession();
            Transaction t = s.beginTransaction();
          Query q = s.createQuery("from Employee");
          q.setMaxResults(2);
          boolean flag = true;
          for(int i =0;flag;i+=2) {
        	  q.setFirstResult(i);
        	  
          List<Employee> lst = q.list();
          if(lst.isEmpty()) {
        	  flag = false;
        	  break;
          }
          lst.forEach(ele->{System.out.println(ele);});
          System.out.println("===========================================");
          }
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	}

}
