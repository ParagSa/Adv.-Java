package com.parag;



import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.parag.model.Employee;

public class Main {
	private static SessionFactory sf;

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr =  ssrb.build();
	     sf = cfg.buildSessionFactory(ssr);
//	     selectAll();
//	     selectOrder();
	     whereDept("cs");
//	     whereDeptor();
//	     selectOnePro();
//	     selectMorethn();
       
	    sf.close();
	    System.out.println("done");

		
	}
	private static void selectAll() {
		   Session s= sf.openSession();
           Transaction t = s.beginTransaction();
           Criteria q = s.createCriteria(Employee.class);
           List<Employee> lst = q.list();
          lst.forEach(ele->System.out.println(ele));
          
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}
	private static void selectOrder() {
		   Session s= sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria q = s.createCriteria(Employee.class);
        q.addOrder(Order.desc("salary"));
        List<Employee> lst = q.list();
       lst.forEach(ele->System.out.println(ele));
       
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}
	private static void whereDept(String dname) {
		   Session s= sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria q = s.createCriteria(Employee.class);
        q.add(Restrictions.eq("dept", dname));
        List<Employee> lst = q.list();
       lst.forEach(ele->System.out.println(ele));
       
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}
	private static void whereDeptor() {
		   Session s= sf.openSession();
     Transaction t = s.beginTransaction();
     Query q = s.createQuery("from Employee where dept = :dpt or dept = :dpt2");
     q.setString("dpt", "cs");
     q.setString("dpt2", "mech");
     List<Employee> lst = q.list();
    lst.forEach(ele->System.out.println(ele));
    
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}
	private static void selectOnePro() {
		   Session s= sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select name from Employee");
        List<String> lst = q.list();
       lst.forEach(ele->System.out.println(ele));
       
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}
	private static void selectMorethn() {
		   Session s= sf.openSession();
     Transaction t = s.beginTransaction();
     Query q = s.createQuery("select name, id from Employee");
     List<Object[]> lst = q.list();
    lst.forEach(ele->System.out.println(ele[0]+" "+ele[1]));
    
//	    s.save(emp);
	    t.commit();
	    s.clear();
		
	}

}
