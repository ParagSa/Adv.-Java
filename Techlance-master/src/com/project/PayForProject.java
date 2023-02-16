package com.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PayForProject")
public class PayForProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PayForProject() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PersonalInfo pInfo = (PersonalInfo)session.getAttribute("otherObject");
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		
		if(myInfo == null && !(myInfo.getUserType().equals("client"))) {
			response.sendRedirect("LogIn.jsp");
		}else {

			String clientAccount = request.getParameter("clientAc");
			String freelancerAccount = request.getParameter("freelancerAc");
			float amount = Float.parseFloat(request.getParameter("amount"));

			ClientDBHandler handler = new ClientDBHandler();
			handler.insertPayment(pInfo, clientAccount, freelancerAccount, amount);
			response.sendRedirect("ClientHome.jsp");
		}
	}

}
