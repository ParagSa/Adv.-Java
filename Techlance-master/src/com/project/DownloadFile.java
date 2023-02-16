package com.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String directory = "/home/mamun/project/";
	PersonalInfo pInfo;


	public DownloadFile() {
		super();

	}

	public String getRequirementFilePath(HttpSession session) {
		DBHandler handler = new DBHandler();
		handler.connect();
		String filePath = "";


		pInfo = (PersonalInfo)session.getAttribute("otherObject");

		if(pInfo.getUserType().equals("project")) {

			Project project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));

			if(project.clientFile != null) {

				filePath =  project.clientFile;
			}	
		}

		return filePath;

	}

	public String getFinalFilePath(HttpSession session) {

		DBHandler handler = new DBHandler();
		handler.connect();
		String filePath = "";

		pInfo = (PersonalInfo)session.getAttribute("otherObject");

		if(pInfo.getUserType().equals("project")) {

			Project project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));

			if(project.getStatus().equals("Completed") && project.filePath != null) {

				filePath = project.filePath;

			}
		}


		return filePath;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

		if(myInfo == null) {
			response.sendRedirect("LogIn.jsp");
		}else {
			String data = request.getParameter("file_req");

			System.out.println(data);


			response.setContentType("text/html;charset=UTF-8");

			try {


				String filePath;
				if(data.equals("final")) {
					filePath = getFinalFilePath(session);
				}else {

					filePath = getRequirementFilePath(session);
				}

				if(!filePath.equals("")) {
					String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);

					System.out.println(filePath);

					FileInputStream in = new FileInputStream(filePath);


					ServletOutputStream out = response.getOutputStream();
					//response.setContentType("application/zip");
					response.setHeader("Content-Disposition", "attachment;filename = " + fileName);

					response.setContentLength(in.available());				

					int c;
					while((c = in.read()) != -1) {

						out.write(c);


					}
					out.flush();
					out.close();
					in.close();
				}

			}catch(Exception e) {


			}
		}




	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request,response);
	}

}
