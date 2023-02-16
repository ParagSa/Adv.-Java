package com.jobportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.PostJobDao;
import com.jobportal.model.JobOpening;
import com.jobportal.model.User;

@WebServlet("/applyForJob")
public class ApplyJobServlet extends HttpServlet {

	static List<User> users = new ArrayList<User>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int workid = Integer.parseInt(request.getParameter("WorkId"));

		System.out.println(request.getParameter("WorkId"));//

		HttpSession session = request.getSession();

		List<JobOpening> jobOpenings = (List<JobOpening>) session.getAttribute("jobOpenings");

		JobOpening appliedJob = null;

		for (JobOpening jobOpening : jobOpenings) {
			System.out.println(
					"Work ID from foreach list is " + jobOpening.getWorkId() + " and work is from apply " + workid);//
			if (jobOpening.getWorkId() == workid) {
				appliedJob = jobOpening;
				System.out.println("Aplied job is " + appliedJob);
				break;
			}
		}

		User user = (User) session.getAttribute("currentUser");
		System.out.println("User aplying for job is " + user);

		for (User user1 : users) {
			System.out.println("Old users " + user1);
		}

		// to remove earlier users form the list
		users.removeAll(users);

		users.add(user);

		for (User user1 : users) {
			System.out.println(" new user " + user1);
		}

		// get the existing users who applied to this job
		List<User> appliedUsers = appliedJob.getUsers();

		for (User user2 : appliedUsers) {
			System.out.println(" Exisitng users " + user2);
		}

		appliedUsers.add(user);

		for (User user2 : appliedUsers) {
			System.out.println(" New user with the Exisitng users " + user2);
		}

		appliedJob.setUsers(appliedUsers);

		// update applied users in appliedJob
		PostJobDao pdao = new PostJobDao();

		boolean res = pdao.postJobDetails(appliedJob);
		
		 if(res) {
				response.sendRedirect("applysuccess.jsp");
		 }else {
			 response.sendRedirect("applyfailure.jsp");
		 }


	}

}
