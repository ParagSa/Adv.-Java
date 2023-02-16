package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WatchProfile")
public class WatchProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WatchProfile() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String personName = request.getParameter("uId");
		HttpSession session = request.getSession();

		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			DBHandler handler = new DBHandler();
			handler.connect();

			User user = handler.getTheUser(personName);
			PersonalInfo pInfo = new PersonalInfo(user.getEmail(),user.getType());
			
			session.setAttribute("otherObject", pInfo);
            if(user.getType().equals("freelancer")) {
            	ArrayList<String> experience = handler.getExperience(pInfo);
            	request.setAttribute("experience", experience);
            }    
              
			request.setAttribute("profile", user);
			request.getRequestDispatcher("Profile.jsp").forward(request, response); 


		}}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
