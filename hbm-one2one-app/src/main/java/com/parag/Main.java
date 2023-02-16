package com.parag;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.parag.model.Manager;
import com.parag.model.dept;

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
            dept dp = new dept(10, "cs");
            Manager m = new Manager(101, "parag");
            m.setDept(dp);
            s.save(dp);
            s.save(m);
       
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	} 

}