package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.PostJobDao;
import com.jobportal.model.JobOpening;
import com.jobportal.model.User;

//import static com.jobportal.controller.UserLogin.*;

@WebServlet("/postnewjob")
public class jobPostServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside the postnewjob servlet");
		
		PostJobDao postjob=new PostJobDao();
		
		JobOpening post = new JobOpening();
		
		post.setSkillsReq(request.getParameter("jobtitle"));
		post.setWorkDate(LocalDate.parse(request.getParameter("workdate")));
		post.setPostDate(LocalDate.now());
		post.setMobileNumber(Long.parseLong(request.getParameter("mobNumber")));
		post.setJobCity(request.getParameter("jobCity"));
		post.setStatus("Active");
		
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("currentUser");
		
		System.out.println(user);
		
		post.setEmployerId(user.getUserId());
		
//	post.setUserId(userid);
		
		 boolean res = postjob.postJobDetails(post);
		 
		 if(res) {
			 response.sendRedirect("postjobsucess.jsp");
		 }else {

		 }

	}

}
