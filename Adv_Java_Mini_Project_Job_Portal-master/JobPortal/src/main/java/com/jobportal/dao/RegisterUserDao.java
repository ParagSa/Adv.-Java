package com.jobportal.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jobportal.model.User;

public class RegisterUserDao {

	public boolean Register(User user) {
		boolean status = true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tcx = em.getTransaction();

//to avoid duplicate entry based on the email ID

			Query q = em.createQuery("select u.email from User u where u.role=:role");// HQL//JPQL
			q.setParameter("role", user.getRole());

			List<String> emailId = q.getResultList();

			Iterator<String> list = emailId.iterator();

			while (list.hasNext()) {

				if (list.next().equals(user.getEmail())) {
					status = false;
					return status;
				}
			}

			tcx.begin();

			// merge is 2-in-1 method //insert plus update
			em.merge(user);

			tcx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
		}
		return status;
	}

	public void RegisterAndUpdateUser(User user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tcx = em.getTransaction();

			tcx.begin();

			// merge is 2-in-1 method //insert plus update
			em.merge(user);

			tcx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
		}
	}

}
