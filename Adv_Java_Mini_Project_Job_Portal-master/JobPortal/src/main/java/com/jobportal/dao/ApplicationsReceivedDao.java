package com.jobportal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ApplicationsReceivedDao {

	public Object fetchById(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tcx = em.getTransaction();

			Object obj = em.find(clazz, pk);

			return obj;

		} finally {
			emf.close();
		}
	}	
}
