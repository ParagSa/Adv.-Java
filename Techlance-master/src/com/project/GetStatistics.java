package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetStatistics")
public class GetStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public GetStatistics() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

		if(myInfo != null) {
			DBHandler handler = new DBHandler();
			handler.connect();
			String json;
			String reqQuery = request.getParameter("query");
			
			if(reqQuery.equals("PL")) {
				json = handler.getLanguageStatistics();

				PrintWriter out = response.getWriter();
				out.println(json);
			}else if(reqQuery.equals("Freelancer")) {
				json = handler.getFreelancerStatistics();

				PrintWriter out = response.getWriter();
				out.println(json); 

			}else if(reqQuery.equals("Client")) {
				json = handler.getClientStatistics();

				PrintWriter out = response.getWriter();
				out.println(json); 


			}
		}
	}

}
