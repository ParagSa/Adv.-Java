package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ClientHomeController")
public class ClientHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String home_btn = request.getParameter("home_btn");
		HttpSession session;
		System.out.println(home_btn);


		ClientDBHandler handler = new ClientDBHandler();
		session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo) session.getAttribute("myObject");
		session.setAttribute("otherObject", myInfo);

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			if(home_btn.equals("My Workspace")) {


				ArrayList<Project> projects = handler.getMyProject(myInfo.getUsername());

				request.setAttribute("projects",projects);
				request.getRequestDispatcher("ShowProjects.jsp").forward(request,response);

			}

			else if(home_btn.equals("Profile")) {

				User user = handler.getTheUser(myInfo.getUsername());

				System.out.println(user.getAddress() + user.getDescription() + user.getEmail() + user.getName() + user.imagePath + user.getType());

				ArrayList<Comment> comments = handler.getComments(myInfo.getUsername());

				request.setAttribute("profile", user);

				request.setAttribute("comments", comments);
				request.getRequestDispatcher("Profile.jsp").forward(request, response);

			}
			else if(home_btn.equals("Notification")) {

				ArrayList<String> notifications = handler.getNotification(myInfo.getUsername(),myInfo.getUserType());


				request.setAttribute("notifications", notifications);
				request.getRequestDispatcher("ShowNotification.jsp").forward(request, response);

			}

			else if(home_btn.equals("Msgs")) {

				ArrayList<MessagedEntity> unameList = handler.getMessagedPersonList(myInfo.getUsername());
			
				request.setAttribute("list", unameList);
				request.getRequestDispatcher("ShowMessages.jsp").forward(request, response);

			}

			else if(home_btn.equals("Search")) {
				String searchedStr = request.getParameter("searchTopic");
				
				String formattedString = Util.formatString(searchedStr);
				
				ArrayList<User> list = handler.searchFromDB(formattedString);
				request.setAttribute("searchResult", list);
				request.getRequestDispatcher("ShowSearchResult.jsp").forward(request,response);
				
			
			}

			else if(home_btn.equals("Create A Project")) {

				response.sendRedirect("ProjectCreation.jsp");

			}
		   else if(home_btn.equals("Statistics")) {
		  	response.sendRedirect("Statistics.jsp");
			
			
		   }

			else {
				response.sendRedirect("Error.jsp");		

			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
