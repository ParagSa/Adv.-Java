package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/DynamicList")
public class DynamicList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	Statement statement;
	ResultSet rs;   
  
    public DynamicList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			DBHandler handler = new DBHandler();
			handler.connect();
			String data = request.getParameter("query");
			
			
			ArrayList<String> str = handler.getSubjectList(data);
					
			
			PrintWriter writer = response.getWriter();
			
			writer.println("<ul class = \"list-unstyled\"");
			
			for(int i = 0; i < str.size();i++) {
				    System.out.println(str.get(i));
					writer.println("<li>" + str.get(i) + "</li>");
					
			}			
			
			writer.println("</ul>");
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}

}
