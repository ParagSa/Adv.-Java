package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SelectBidder")
public class SelectBidder extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SelectBidder() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("query");
		Project project = (Project)session.getAttribute("project");
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		if(myInfo == null && !(myInfo.getUserType().equals("client"))) {
			response.sendRedirect("LogIn.jsp");
		}else {

			ClientDBHandler handler = new ClientDBHandler();

			handler.selectFreelancer(username, project.getProjectId());


			PrintWriter pw = response.getWriter();
			pw.print(myInfo.getUsername());

			//response.sendRedirect("LogIn.jsp");
		}
	}

}
