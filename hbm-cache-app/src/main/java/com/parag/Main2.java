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
//         ession s= sf.openSession();

  		Session s = sf.openSession();
  		System.out.println("first session started");
  		Transaction t = s.beginTransaction();
  		System.out.println("get calling");
  		Employee emp = (Employee)s.get(Employee.class, 1);
  		System.out.println(emp); 
  		System.out.println("get calling");
  		Employee emp1 = (Employee)s.get(Employee.class, 1);
  		System.out.println(emp1);
  		t.commit();
  		s.close();
  		System.out.println("first session closed");
  		
  		Session s1 = sf.openSession();
  		System.out.println("second session started");
  		Transaction t1 = s1.beginTransaction();
  		System.out.println("get calling");
  		Employee emp2 = (Employee)s1.get(Employee.class, 1);
  		System.out.println(emp2); 
  		System.out.println("get calling");
  		Employee emp3 = (Employee)s1.get(Employee.class, 1);
  		System.out.println(emp3);
  		t1.commit();
  		s1.close();
  		System.out.println("second session closed");
  		sf.close();
  		System.out.println("done");
  		

		
	}

}
