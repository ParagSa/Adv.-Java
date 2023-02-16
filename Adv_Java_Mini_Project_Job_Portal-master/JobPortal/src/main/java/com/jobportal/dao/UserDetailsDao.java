package com.jobportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jobportal.model.User;



public class UserDetailsDao {

	// fetch all by some other column_Name
	public User fetchByEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select u from User u where u.email = : em");// here ? also allowed
		q.setParameter("em", email);

		User emp = (User) q.getSingleResult();

		emf.close();

		return emp;
	}

	
}
