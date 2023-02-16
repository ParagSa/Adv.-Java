package com.jobportal.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jobportal.model.JobOpening;
import com.jobportal.model.User;

public class PostedJobsDao {

	public List<JobOpening> postedJobs(int employerID) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");

		List<JobOpening> postedJobs = null;

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction tcx = em.getTransaction();

			Query q = em.createQuery("select rq from JobOpening rq where status='Active' and rq.employerId =: eid");// HQL//JPQL
			q.setParameter("eid", employerID);

			postedJobs = q.getResultList();

		} finally {
			emf.close();
		}

		return postedJobs;

	}

}
