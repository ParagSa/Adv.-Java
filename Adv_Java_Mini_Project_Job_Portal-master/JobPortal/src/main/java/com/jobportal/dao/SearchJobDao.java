package com.jobportal.dao;

import java.time.LocalDate;
import java.util.List;

import com.jobportal.model.JobOpening;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SearchJobDao {

	public List<JobOpening>  fetchJob(String Jobtitle, LocalDate Date, String Location ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("from JobOpening where status='Active' and skillsReq=:skillsReq1 and workDate=:Date1 and jobCity=:Location1 ");

		q.setParameter("skillsReq1", Jobtitle);
		q.setParameter("Date1",Date);
		q.setParameter("Location1", Location);
		
		List<JobOpening> jobList = q.getResultList();
		if(jobList != null && jobList.size()>0) {
			return jobList;
		}
		return null;
	}
	
}
