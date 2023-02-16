package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.ApplicationsReceivedDao;
import com.jobportal.dao.DeletePostedJobDao;
import com.jobportal.model.JobOpening;
import com.jobportal.model.User;

/**
 * Servlet implementation class ApplicationsReceievedServlet
 */
@WebServlet("/applicantsORdelete")
public class ApplicationsReceievedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ops = request.getParameter("Operation");

		int workId = Integer.parseInt(request.getParameter("WorkId"));
		ApplicationsReceivedDao arDao = new ApplicationsReceivedDao();

		JobOpening postedJob = (JobOpening) arDao.fetchById(JobOpening.class, workId);

		if (!ops.equals("DELETE")) {

			List<User> applications = postedJob.getUsers();

			for (User user : applications) {
				System.out.println(user);
			}

			HttpSession session = request.getSession();
			session.setAttribute("applications", applications);

			response.sendRedirect("Applications.jsp");
		} else {

			postedJob.setStatus("Deleted");
			DeletePostedJobDao deletDao = new DeletePostedJobDao();

			deletDao.postJobDetails(postedJob);

			response.sendRedirect("deletejobsuccess.jsp");

		}

	}
}
