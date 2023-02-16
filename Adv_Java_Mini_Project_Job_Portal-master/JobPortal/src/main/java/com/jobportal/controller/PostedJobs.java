package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.PostedJobsDao;
import com.jobportal.model.JobOpening;
import com.jobportal.model.User;

@WebServlet("/postedjobs")
public class PostedJobs extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PostedJobsDao pjdao= new PostedJobsDao();
		
		HttpSession session = request.getSession();
		
		User currentUser =(User)session.getAttribute("currentUser");

		System.out.println("Employer is " + currentUser);
		
		List<JobOpening> postedJobs = pjdao.postedJobs(currentUser.getUserId());
		
		for (JobOpening postedJob : postedJobs) {
			System.out.println(postedJob);
		}
		
		session.setAttribute("postedJobs", postedJobs);
		
		response.sendRedirect("postdedJobsempr.jsp");
		
	}

	

}
