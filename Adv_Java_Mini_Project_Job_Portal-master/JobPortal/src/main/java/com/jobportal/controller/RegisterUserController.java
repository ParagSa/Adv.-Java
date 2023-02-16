package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.RegisterUserDao;
import com.jobportal.model.User;

@WebServlet("/user-registration")
public class RegisterUserController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("emailID");
		String password = request.getParameter("password");
		String confPassword = request.getParameter("Confirmed_Pass");
		LocalDate dateOfJoining = LocalDate.now();
		String role = request.getParameter("role");
		
		//Check Confirmed Password
		if (!password.equals(confPassword)) {
			response.sendRedirect("login.html");
			return;
		}

		// encoding password

		String encodedPass = Base64.getEncoder().encodeToString(password.getBytes("UTF-8")); // throws
																								// UnsupportedEncodingException
// Base64.getEncoder() - returns basic encoder
// encodeToString(text.getBytes("UTF-8")) --> converts the string into
// encodedString with UTF-8 charset

		System.out.println(encodedPass); // V2VsY29tZSB0byBBZHMgSmF2YQ==

		User user = new User();

		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setDateOfJoining(dateOfJoining);
		user.setPassword(encodedPass);
		user.setRole(role);
		RegisterUserDao reg = new RegisterUserDao();

		boolean regSuccess = reg.Register(user);

		PrintWriter out = response.getWriter();

		if (!regSuccess) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email ID is already registered with us!');");
			out.println("location='login.html';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Sucessfull! You can login with your credentails');");
			out.println("location='login.html';");
			out.println("</script>");
			;
		}
	}
}
