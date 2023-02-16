package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddComments")
public class AddComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddComments() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	     HttpSession session = request.getSession();
	     
	     String comment = request.getParameter("comment");
	     
	     boolean bool = false;
	     
	     Project project;
	     
	     PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
	     if(myInfo == null) {
	    	 response.sendRedirect("LogIn.jsp");
	     }else {
	     
	     PersonalInfo pInfo = (PersonalInfo)session.getAttribute("otherObject");
	
	     
	     if(myInfo.getUserType().equals("freelancer")) {
	    	 FreelancerDBHandler handler = new FreelancerDBHandler();
	    	 
	    	 project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));
	    	 
	    	 bool = handler.insertComment(myInfo.getUsername(), project.getClientName(), comment, Integer.parseInt(pInfo.getUsername()));
	    	 
	    	 
	     }else if(myInfo.getUserType().equals("client")) {
	    	 ClientDBHandler handler = new ClientDBHandler();
	    	 
	    	 project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));
	    	 
	    	 PersonalInfo info = handler.getTheProjectDeveloper(Integer.parseInt(pInfo.getUsername()));
	    	 
	    	 bool = handler.insertComment(myInfo.getUsername(), info.getUsername(), comment, Integer.parseInt(pInfo.getUsername()));
	    		    	 
	    	 
	     }
	     
	     PrintWriter pw = response.getWriter();
		 pw.print(pInfo.getUsername());
	     }
	     
	}

}
