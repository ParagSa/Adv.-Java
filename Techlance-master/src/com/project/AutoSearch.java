package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AutoSearch")
public class AutoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AutoSearch() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			String name = request.getParameter("query");

			DBHandler handler = new DBHandler();
			handler.connect();
			ArrayList<String> nameList = handler.autoSearch(name);

			PrintWriter writer = response.getWriter();

			writer.println("<ul class = \"list-unstyled\"");

			for(int i = 0;i < nameList.size();i++) {

				writer.println("<li>" + nameList.get(i) + "</li>");
			}


			writer.println("</ul>");

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
