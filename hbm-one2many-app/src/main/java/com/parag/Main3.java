package com.parag;





import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.parag.model.Category;
import com.parag.model.Product;



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
            Query q = s.createQuery("from Category");
            List<Category> lst = q.list();
            lst.forEach(ele->{System.out.println(ele);  Set<Product> st = ele.getProducts();
            st.forEach(el->System.out.println(el));
            });
	    t.commit();
	    s.clear();
	    sf.close();
	    System.out.println("done");

		
	}

}
