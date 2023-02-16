package com.jobportal.dao;

import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserLoginDao {

	public boolean AuthenticateUser(String emailID, String pass, String role) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobportal");

		try {
			EntityManager em = emf.createEntityManager();

//to avoid duplicate entry based on the email ID

			Query q = em.createQuery("select u.password from User u where u.email = : email and u.role=: role ");// HQL//JPQL
			q.setParameter("email", emailID);
			q.setParameter("role", role);
			
			String passString = (String) q.getSingleResult();

			System.out.println(" passString " + passString);

			byte[] decodedTextArray = Base64.getDecoder().decode(passString);
			// decode(encodedText) -- convertes the encoded string into the byte[]

			String decodedPass = new String(decodedTextArray, "UTF-8");

			System.out.println("decodedPass " + decodedPass);

			if (pass.equals(decodedPass))
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
		}
		return false;
	}

}
