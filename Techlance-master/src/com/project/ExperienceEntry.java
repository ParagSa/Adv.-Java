package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/ExperienceEntry")
public class ExperienceEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ExperienceEntry() {
		super();

	}	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			if(myInfo.getUserType().equals("freelancer")) {

				boolean experienceEntry,descriptionEntry;
				String[] languages = request.getParameterValues("favouriteLanguage");
				String json = request.getParameter("query");
				String description = request.getParameter("desc");
				
				Gson gson = new Gson();
				Languages language = gson.fromJson(json, Languages.class);
				

				FreelancerDBHandler handler = new FreelancerDBHandler();
				experienceEntry = handler.addExperience(language.name, myInfo.getUsername());
				descriptionEntry = handler.addDescription(myInfo.getUsername(), description, "freelancer");

				handler.close();
				//response.sendRedirect("Description.jsp");
				PrintWriter writer = response.getWriter();
				writer.println("successful");

			}
			
		}
	}

}
