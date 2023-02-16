package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Rate")
public class Rate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Rate() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Project project;

		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

		PersonalInfo pInfo = (PersonalInfo)session.getAttribute("otherObject");

		String rating = request.getParameter("rating");

		float rate = Float.parseFloat(rating);

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			if(myInfo.getUserType().equals("freelancer")) {
				FreelancerDBHandler handler = new FreelancerDBHandler();

				project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));

				handler.rateTheClient(myInfo.getUsername(), project.getClientName(), project.getProjectId(), rate);
                
				response.sendRedirect("Home.jsp");

			}else if(myInfo.getUserType().equals("client")) {
				ClientDBHandler handler = new ClientDBHandler();			

				PersonalInfo projectInfo = handler.getTheProjectDeveloper(Integer.parseInt(pInfo.getUsername()));

				handler.rateTheFreelancer(myInfo.getUsername(),projectInfo.getUsername(),Integer.parseInt(pInfo.getUsername()),rate);
				
				response.sendRedirect("ClientHome.jsp");
			}

		}


	}

}
