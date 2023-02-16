package com.project;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File file;

	public CreateProject() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonalInfo myInfo,otherInfo,object;
		String pName,pDuration,pDescription;
		int duration;
		int pId;
		String[] pRequirements;
		HttpSession session;
		ClientDBHandler handler = new ClientDBHandler();
		session = request.getSession();
		myInfo = (PersonalInfo)session.getAttribute("myObject");

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			pName = request.getParameter("name");
			pDuration = request.getParameter("duration");
			//duration = Integer.parseInt(pDuration);
			pDescription = request.getParameter("textarea");
			pRequirements = request.getParameterValues("favouriteLanguage");

			System.out.println(pName + pDuration );
			for(String str:pRequirements) {
				System.out.println(str);

			}





			pId = handler.insertProject(pName, pDescription, myInfo.getUsername(), pDuration,pRequirements);

			String fileDirectory = "/home/mamun/project/project" + pId;

			object = new PersonalInfo(Integer.toString(pId),"project");

			session.setAttribute("otherObject",object);

			file = new File(fileDirectory);

			boolean successful = file.mkdir();

			if(successful) {

				System.out.println("Directory Created");
			}
			else {
				System.out.println("Error in creating directory");

			}

			response.sendRedirect("NewFile.jsp");


		}
	}

}
