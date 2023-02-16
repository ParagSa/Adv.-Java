package com.jobportal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jobportal.model.JobOpening;

public class DeletePostedJobDao {

	public boolean postJobDetails(JobOpening postjob) {
		boolean result = false;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("jobportal");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.merge(postjob);

			tx.commit();
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			emf.close();
			return result;
		}
	}

}
