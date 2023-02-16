package com.parag;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class Main3 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr =  ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
          Session s= sf.openSession();
            Transaction t = s.beginTransaction();
//            Employee emp = new Employee(104);
//	    s.save(emp);
//            s.update(emp);
//            s.delete(emp);
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	}

}
