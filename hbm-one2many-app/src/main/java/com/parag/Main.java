package com.parag;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.parag.model.Category;

import com.parag.model.Product;


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
           Category c = new Category(1, "electric");
           Product p1 = new Product(10, "fan");
           Product p2 = new Product(20, "cooler");
           c.getProducts().add(p1);
           c.getProducts().add(p2);
           s.save(c);
           s.save(p1);
           s.save(p2);
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	} 

}
