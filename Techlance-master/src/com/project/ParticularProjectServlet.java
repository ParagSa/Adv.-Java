package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ParticularProjectServlet")
public class ParticularProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParticularProjectServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		String str = request.getParameter("pId");
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			if(str != null) {
				int projectId = Integer.parseInt(str);
				ArrayList<Bidder>bidderList;

				PersonalInfo developer = null;


				DBHandler handler = new DBHandler();
				handler.connect();

				Project project = handler.getTheProject(projectId);

				PersonalInfo myProject = new PersonalInfo(Integer.toString(projectId),"project");

				session.setAttribute("otherObject", myProject);

				if(project.getStatus().equals("Bidding")) {

					bidderList = handler.getTheBidders(projectId);

					project.setBidders(bidderList);						

					request.setAttribute("currProject",project);

					request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

				}else {
					developer = handler.getTheProjectDeveloper(projectId);				
					project.setDeveloper(developer);

					String paymentStatus = handler.getPaymentStatus(myProject);

					project.setProjectDescription(paymentStatus);

					request.setAttribute("currProject",project);
					if(developer.getUsername().equals(myInfo.getUsername()) || project.getClientName().equals(myInfo.getUsername())) {

						request.getRequestDispatcher("ShowMyProject.jsp").forward(request, response);

					}		
					else {

						request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

					}


				}			

			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
