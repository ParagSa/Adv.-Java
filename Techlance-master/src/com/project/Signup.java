package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName,email,password,confirmedPassword,address,designation,passcode;
		boolean insertionBool;

		HttpSession session = request.getSession();

		fullName = request.getParameter("fullname");
		email = request.getParameter("email");
		password = request.getParameter("password");
		confirmedPassword = request.getParameter("password2");
		address = request.getParameter("address");





		if(password.equals(confirmedPassword)) {

			FreelancerDBHandler handler = new FreelancerDBHandler();

			passcode = Encryption.generatePass(password);
			insertionBool = handler.insert(fullName,email,passcode,address,"freelancer");
			if(insertionBool) {
				PersonalInfo myInfo = new PersonalInfo(email,"freelancer");
				session.setAttribute("myObject",myInfo);


				ArrayList<String> subjects = handler.getSubjectList();

				for(String str:subjects){
					System.out.println(str); 
				}

				request.setAttribute("subjects", subjects);
				request.getRequestDispatcher("DescExperience.jsp").forward(request, response);


			}
			else {
				response.sendRedirect("Error.jsp");				
			}
			handler.close();

		}



	}

}
