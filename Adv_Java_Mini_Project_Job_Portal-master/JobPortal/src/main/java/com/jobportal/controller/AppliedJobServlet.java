package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.jobportal.dao.AppliedJobsDao;
import com.jobportal.model.JobOpening;
import com.jobportal.model.User;


@WebServlet("/appliedjobs")
public class AppliedJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		AppliedJobsDao adao = new AppliedJobsDao();

		// get user id from session
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("currentUser");

		System.out.println("User details from session "+ user);
		
			int userid = user.getUserId();

			User updated_user = (User) adao.fetchById(User.class, userid);

			System.out.println("new user "+ updated_user);
		
			List<JobOpening> appliedJobs = updated_user.getJobOepnings();

			session.setAttribute("appliedJobs", appliedJobs);
			
			response.sendRedirect("appliedJobs.jsp");

			System.out.println("reached in servlet ");

		}
	}
	/*
	 * else { PrintWriter out = response.getWriter();
	 * out.println("<script type=\"text/javascript\">");
	 * out.println("alert('Invalid UserID or Password!');");
	 * out.println("location='login.html';"); out.println("</script>"); }
	 */

