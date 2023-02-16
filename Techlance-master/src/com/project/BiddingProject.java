package com.project;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BiddingProject")
public class BiddingProject extends HttpServlet {

	public BiddingProject() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		FreelancerDBHandler handler = new FreelancerDBHandler();
		float x;

		PersonalInfo myInfo = (PersonalInfo) session.getAttribute("myObject");
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {

			Project otherInfo = (Project) session.getAttribute("project");

			String valueOfBtn = request.getParameter("bid_btn");


			System.out.println(request.getParameter("amount"));

			if(valueOfBtn.equals("Bid")) {

				x = Float.parseFloat(request.getParameter("amount"));		

				handler.insertBidding(myInfo.getUsername(),otherInfo.getClientName(),otherInfo.getProjectId(), x);

			}
			else {
				x = Float.parseFloat(request.getParameter("amount"));
				handler.updateBidding(myInfo.getUsername(), otherInfo.getProjectId(), x);

			}

			ArrayList<Bidder> bidderList = handler.getTheBidders(otherInfo.getProjectId());

			otherInfo.setBidders(bidderList);

			request.setAttribute("currProject",otherInfo);
			request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

			handler.close();

		}
	}

}
