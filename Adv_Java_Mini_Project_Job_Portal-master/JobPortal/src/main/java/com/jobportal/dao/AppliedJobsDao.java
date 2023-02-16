package com.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jobportal.model.JobOpening;

public class AppliedJobsDao {

	// select based on primary key
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

	/*
	 * public List<JobOpening> fetchAppliedJob(int employeeID) {
	 * 
	 * 
	 * 
	 * 
	 * return null; }
	 */

	/*
	 * public ResultSet fetchAppliedJob(int employeeID) throws SQLException,
	 * ClassNotFoundException {
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * System.out.println("reached here in JDBC 1");
	 * 
	 * Connection conn =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/newjobportalll",
	 * "root", "cdac");
	 * 
	 * PreparedStatement pst = conn.prepareStatement(
	 * "select ju.workId,ud.user_id,ud.email,rq.workDate,rq.skillsreq,rq.mobileNumber,rq.jobCity from jobs_users ju,user_Details ud,requirements1 rq where rq.workId = ju.workId and ud.user_id = ju.user_id and ud.user_id = ?"
	 * ); pst.setInt(1, employeeID);
	 * 
	 * System.out.println("reached here in JDBC 2");
	 * 
	 * ResultSet rs = pst.executeQuery();
	 * 
	 * // List<JobOpening> jobsApplied = new ArrayList<JobOpening>();
	 * 
	 * 
	 * while (results.next()) { ints.add(Integer.valueOf(results.getInt(1)));
	 * 
	 * //JobOpening jobOpening = new JobOpening();
	 * 
	 * while (rs.next()) { System.out.println(rs.getInt(1) + "  " + rs.getInt(2) +
	 * "  " + rs.getString(3) + "  " + rs.getString(4)); }
	 * 
	 * System.out.println("reached here in JDBC 3");
	 * 
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("jobportal"); EntityManager em =
	 * emf.createEntityManager();
	 * 
	 * Query q = em.
	 * createQuery("select rq.workId, rq.jobCity, rq.mobileNumber, rq.skillsReq, rq.workDate from jobs_users ju,User ud,JobOpening rq where rq.workId = ju.workId and ud.user_id = ju.user_id and ud.user_id = : uid"
	 * );
	 * 
	 * q.setParameter("uid", employeeID);
	 * 
	 * List<JobOpening> appliedJobList = q.getResultList();
	 * 
	 * if(appliedJobList != null && appliedJobList.size()>0) { return
	 * appliedJobList; }
	 * 
	 * return rs; }
	 */

}
