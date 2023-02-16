package com.project;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
   
    public HomeController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String home_btn = request.getParameter("home_btn");
		
		FreelancerDBHandler handler = new FreelancerDBHandler();
		session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo) session.getAttribute("myObject");
		session.setAttribute("otherObject", myInfo);
		
		
		if(home_btn.equals("My Workspace")) {
			
			
			ArrayList<Project> projects = handler.getMyProject(myInfo.getUsername());
			
			request.setAttribute("projects",projects);
			
			request.getRequestDispatcher("ShowProjects.jsp").forward(request,response);
			
		}
		
		else if(home_btn.equals("Profile")) {
			
			//User user = handler.getTheUser(myInfo.getUsername(),myInfo.getUserType());
			
			
			User user = handler.getTheUser(myInfo.getUsername());
			System.out.println("imagepath" + user.getImagePath());
			ArrayList<Comment> comments = handler.getComments(myInfo.getUsername());
			
			
			request.setAttribute("profile", user);
			
			request.setAttribute("comments", comments);
			
			if(user.getType().equals("freelancer")) {
            	ArrayList<String> experience = handler.getExperience(myInfo);
            	request.setAttribute("experience", experience);
            } 
			request.getRequestDispatcher("Profile.jsp").forward(request, response);
			
		}
		else if(home_btn.equals("Notification")) {
			
			ArrayList<String> notifications = handler.getNotification(myInfo.getUsername(),myInfo.getUserType());
			
			request.setAttribute("notifications", notifications);
			request.getRequestDispatcher("ShowNotification.jsp").forward(request, response);
			
		}
		
		else if(home_btn.equals("Message")) {
			
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
		
		else if(home_btn.equals("Suggested Projects")) {
			
			ArrayList<Project> suggestions = handler.searchSuggestedProjects(myInfo.getUsername());
			
			request.setAttribute("suggestions", suggestions);
			request.getRequestDispatcher("ShowSuggestedProjects.jsp").forward(request,response);
			
		}
		
		else if(home_btn.equals("Statistics")) {
			response.sendRedirect("Statistics.jsp");
			
			
		}
		
		else {
			response.sendRedirect("Error.jsp");		
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
