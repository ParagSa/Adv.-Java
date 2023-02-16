package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		String username = request.getParameter("email");
		String passcode = request.getParameter("password");

        String password = Encryption.generatePass(passcode);
        
        System.out.println(password);
        
		FreelancerDBHandler handler = new FreelancerDBHandler();
		
		int[] msgNtfCount;

		PersonalInfo myInfo = (PersonalInfo) handler.logInCheck(username,password);	


		if(myInfo != null) {

			msgNtfCount = handler.getMsgNtfnCount(myInfo.getUsername());
			myInfo.setCountArray(msgNtfCount);

			session = request.getSession();			
			session.setAttribute("myObject", myInfo);

			if(myInfo.getUserType().equals("freelancer")) {

				response.sendRedirect("Home.jsp");
			}
			else if(myInfo.getUserType().equals("client")) {
                 
				response.sendRedirect("ClientHome.jsp");

			}

		}




	}


}
