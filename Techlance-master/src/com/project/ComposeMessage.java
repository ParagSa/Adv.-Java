package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ComposeMessage")
public class ComposeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ComposeMessage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = "";
		String message = ""; 
		HttpSession session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			DBHandler handler = new DBHandler();
			handler.connect();

			if(request.getParameter("uId") != null) {
				username = request.getParameter("uId");			

			}else {
				username = ((PersonalInfo)session.getAttribute("otherObject")).getUsername();			

			}

			message = request.getParameter("msg");
			handler.insertMessage(myInfo.getUsername(), username, message);		
		}

	}

}
