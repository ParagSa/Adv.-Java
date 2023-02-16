/*
 * package com.jobportal.dao;
 * 
 * import java.util.Iterator; import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory; import
 * javax.persistence.EntityTransaction; import javax.persistence.Persistence;
 * import javax.persistence.Query;
 * 
 * 
 * 
 * public class EmployeeWorkDao {
 * 
 * 
 * // select based on primary key and class input public Object fetchById(Class
 * clazz, Object pk) { EntityManagerFactory emf =
 * Persistence.createEntityManagerFactory("leaning-hibernate");
 * 
 * try { EntityManager em = emf.createEntityManager(); EntityTransaction tcx =
 * em.getTransaction();
 * 
 * Object obj = em.find(clazz, pk);
 * 
 * return obj;
 * 
 * } finally { emf.close(); } }
 * 
 * public boolean MapUserwithWork(int workid, int emplyeeid) {
 * 
 * EntityManagerFactory emf=null;
 * 
 * try { emf = Persistence.createEntityManagerFactory("jobportal");
 * EntityManager em = emf.createEntityManager(); EntityTransaction tcx =
 * em.getTransaction();
 * 
 * //to avoid duplicate entry based on the email ID
 * 
 * 
 * 
 * Query q = em.
 * createQuery("select count(u) from jobs_users u where u.user_id =:uid and u.workId =: wid"
 * );// HQL//JPQL q.setParameter("uid", emplyeeid); q.setParameter("wid",
 * workid);
 * 
 * Long count = (Long) q.getSingleResult();
 * 
 * System.out.println(count);
 * 
 * if(count==0) { return false; }
 * 
 * tcx.begin();
 * 
 * String select ="insert into jobs_users values(?,?)"; // merge is 2-in-1
 * method //insert plus update em.persist(select);
 * 
 * tcx.commit();
 * 
 * } catch (Exception e) { e.printStackTrace(); } finally { emf.close(); }
 * return true;
 * 
 * return true; }
 * 
 * }
 */