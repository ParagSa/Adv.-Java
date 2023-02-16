package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.jobportal.dao.PostJobDao;
import com.jobportal.dao.SearchJobDao;
import com.jobportal.model.JobOpening;

@WebServlet("/searchjob")
public class searchJobServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("inside the searchjob URI");

		String Jobtitle = request.getParameter("jobtitle");
		LocalDate Date = LocalDate.parse(request.getParameter("date"));
		String Location = request.getParameter("location");

		System.out.println(Jobtitle + Date + Location);

		SearchJobDao searchDao = new SearchJobDao();

//		PostJobDao searchDao = new PostJobDao();		

		List<JobOpening> searchResult = searchDao.fetchJob(Jobtitle, Date, Location);


		/*
		 * for (JobOpening jobOpening : searchResult) {
		 * System.out.println(jobOpening.getSkillsReq());
		 * System.out.println(jobOpening.getJobCity());
		 * System.out.println(jobOpening.getMobileNumber());
		 * System.out.println(jobOpening.getWorkDate()); }
		 */
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();

		if (searchResult != null) {

			session.setAttribute("jobOpenings", searchResult);

			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchJobResult.jsp");
			dispatcher.forward(request, response);

			/*
			 * out.write("<h1> Search Result Obtained</h1>"); out.write("jugaddddd");
			 * System.out.println(searchResult);
			 */
			
		} else {
			response.sendRedirect("jobsearchfailure.jsp");
		}
	}

}
