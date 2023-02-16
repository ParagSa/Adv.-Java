package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MyProjects")
public class MyProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public MyProjects() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String username = request.getParameter("uId");

		PersonalInfo otherInfo = (PersonalInfo)session.getAttribute("otherObject");

		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			DBHandler handler;

			if(otherInfo.getUserType().equals("freelancer")) {
				handler = new FreelancerDBHandler();


			}else {
				handler = new ClientDBHandler();

			}

			//System.out.println("Project is " + username);
			ArrayList<Project> projects = handler.getMyProject(otherInfo.getUsername());
			request.setAttribute("projects",projects);
			request.getRequestDispatcher("ShowProjects.jsp").forward(request,response);



		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
