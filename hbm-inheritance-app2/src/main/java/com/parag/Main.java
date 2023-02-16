package com.parag;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.parag.model.Clerk;
import com.parag.model.Employee;
import com.parag.model.Manager;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr =  ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
          Session s= sf.openSession();
            Transaction t = s.beginTransaction();
//            Employee emp = new Employee(102,"ritesh",10000.0f);
            Manager m = new Manager(103, "rohan", 9090.9f, 786.8f, 897.8f);
            Clerk c  = new Clerk(104, "rushabh", 9876.8f, 768.8f);
	    s.save(m);
	    s.save(c);
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	} 

}
