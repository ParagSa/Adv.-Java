package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NewMsg")
public class NewMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewMsg() {
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

			if(request.getParameter("msgdperson") != null) {
				username = request.getParameter("msgdperson");			

			}
			
			System.out.println(request.getParameter("msgdperson"));
            username = request.getParameter("msgdperson");
			message = request.getParameter("msgarea");
			handler.insertMessage(myInfo.getUsername(), username, message);
			ArrayList<MessagedEntity> unameList = handler.getMessagedPersonList(myInfo.getUsername());
			
			request.setAttribute("list", unameList);
			request.getRequestDispatcher("ShowMessages.jsp").forward(request, response);
		}
	}

}
