package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ParticularMessageSevlet")
public class ParticularMessageSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ParticularMessageSevlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		String username = ((PersonalInfo)session.getAttribute("myObject")).getUsername();

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			String anotherPerson = request.getParameter("uId");
			
			if(session.getAttribute("otherObject") != null && request.getParameter("uId") == null) {
			    anotherPerson = ((PersonalInfo)session.getAttribute("otherObject")).getUsername();
			    	
			}
			
			
		 
			DBHandler handler = new DBHandler();
			handler.connect();

			ArrayList<Message> messages = handler.getMessage(username, anotherPerson);

			PersonalInfo personMsgTo = handler.rtnPerson(anotherPerson);

			session.setAttribute("otherObject", personMsgTo);

			request.setAttribute("messages", messages);
			request.getRequestDispatcher("ShowPartMessages.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}