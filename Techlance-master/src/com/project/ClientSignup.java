package com.project;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ClientSignup")
public class ClientSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientSignup() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

			ClientDBHandler handler = new ClientDBHandler();
			
			passcode = Encryption.generatePass(password);
			
			insertionBool = handler.insert(fullName,email,passcode,address,"client");
			if(insertionBool) {
				PersonalInfo myInfo = new PersonalInfo(email,"client");
				session.setAttribute("myObject",myInfo);

				PersonalInfo info = (PersonalInfo)session.getAttribute("myObject");
				System.out.println(info.username + "        " + info.userType);


				request.getRequestDispatcher("Description.jsp").forward(request, response);


			}
			
			handler.close();

		}
		else {
			response.sendRedirect("Error.jsp");				
		}

	}

}
