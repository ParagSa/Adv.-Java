package com.jobportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.RegisterUserDao;
import com.jobportal.model.User;

@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("currentUser");

		System.out.println("Ye kaun hai " + user);

		try {
			LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));

			user.setDateOfBirth(dateOfBirth);
			user.setMobileNo(Long.parseLong(request.getParameter("mobileNumber")));
			;
			user.setCity(request.getParameter("userCity"));
			user.setDistrict(request.getParameter("userDistrict"));
			user.setState(request.getParameter("userState"));

			LocalDate today = LocalDate.now();
			System.out.println(today);

			Period P = Period.between(dateOfBirth, today);
			System.out.println(P);// P25Y9M14D

			user.setAge(P.getYears());

			System.out.println(P.getYears());

			RegisterUserDao updateDao = new RegisterUserDao();

			updateDao.RegisterAndUpdateUser(user);

		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Details!');");
			out.println("location='updateProfile.jsp';");
			out.println("</script>");
		}
		response.setContentType("text/html");

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Details Updated Sucessfully!');");
		out.println("location='emphome.jsp';");
		out.println("</script>");
	}

}
