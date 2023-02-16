package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Description")
public class Description extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Description() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();


		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		String description = request.getParameter("textarea");

		boolean descriptionEntry;
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {

			if(myInfo.getUserType().equals("freelancer")) {

				FreelancerDBHandler handler = new FreelancerDBHandler();
				descriptionEntry = handler.addDescription(myInfo.getUsername(),description,myInfo.getUserType());

				if(descriptionEntry) {

					session.removeAttribute("myObject");
					response.sendRedirect("LogIn.jsp");


				}else {
					response.sendRedirect("Error.jsp");

				}

				handler.close();

			}

			else if(myInfo.getUserType().equals("client")) {
				FreelancerDBHandler handler = new FreelancerDBHandler();
				descriptionEntry = handler.addDescription(myInfo.getUsername(),description,myInfo.getUserType());

				if(descriptionEntry) {

					session.removeAttribute("myObject");
					response.sendRedirect("LogIn.jsp");


				}else {
					response.sendRedirect("Error.jsp");

				}

				handler.close();


			}

		}
	}

}
