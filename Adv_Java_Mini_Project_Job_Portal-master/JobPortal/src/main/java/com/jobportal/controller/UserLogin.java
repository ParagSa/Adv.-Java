package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.jobportal.dao.UserDetailsDao;
import com.jobportal.dao.UserLoginDao;
import com.jobportal.model.User;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

/**
 * Servlet implementation class UserLogin
 */

@Transactional
@WebServlet("/login")
public class UserLogin extends HttpServlet {

	//public static String userid = "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("userID");

	//	userid = username;
		
		String password = request.getParameter("password");

		String role = request.getParameter("role");
		
		System.out.println(username + "  " + password);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserLoginDao login = new UserLoginDao();

		boolean res = login.AuthenticateUser(username, password,role);
		
		if (res) {

			// STORES COOKIES IF CHECKBOX SELECTED
			String rememberMe = request.getParameter("rememberMe");
			System.out.println(rememberMe);// prints the value of the checkbox assigned to it by using the attribute
											// called value
											// in html
			
			//got the user details on login from database
			UserDetailsDao userDao = new UserDetailsDao();
			
			System.out.println(" ERRORRRR ");
			
			User user = userDao.fetchByEmail(username);
			
			//verified user
			System.out.println(user);
			
			//added user in session
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			
			
			if (rememberMe != null && rememberMe.equals("yes")) {

				Cookie C1 = new Cookie("uname", username);
				C1.setMaxAge(1000);//5 mins
				response.addCookie(C1);

				Cookie C2 = new Cookie("upass", password);
				C2.setMaxAge(1000);// 5 mins

				response.addCookie(C2);
			}
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Logged In Sucessfully!');");
			if(role.equals("employer")) {
				response.sendRedirect("emprhome.jsp");
			}
			else{
				out.println("location='emphome.jsp';");
			}
			out.println("</script>");

		} else
			
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid UserID or Password!');");
		out.println("location='login.html';");
		out.println("</script>");

	}

}
