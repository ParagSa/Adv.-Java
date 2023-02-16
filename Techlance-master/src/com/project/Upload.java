package com.project;

import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import com.project.DBHandler;
import com.project.PersonalInfo;


public class Upload extends HttpServlet {
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file ;
	HttpSession session;

	boolean uniquenessOfFile = false;
	boolean isImage;

	public String getProjectLocation(String fileType,PersonalInfo pInfo) {
		String location = null;

		if(fileType.equals("image")) {
			location = "/home/mamun/Downloads/Techlance/WebContent/images/project";
			uniquenessOfFile = true;
		}else {
			location = "/home/mamun/project/project" + pInfo.getUsername() + "/";
			uniquenessOfFile = false;
		}
		System.out.println("Location is " + location);

		return location;

	}

	public String getFileLocation(String fileType,PersonalInfo pInfo) {

		String location = null;

		if(fileType.equals("image")) {
            System.out.println("image uploaded");
			location = "/home/mamun/Downloads/Techlance/WebContent/images/";			
			uniquenessOfFile = true;
		}

		return location;		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {


		DBHandler handler = new DBHandler();
		handler.connect();
		System.out.println("In Upload Method");
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

		if( !isMultipart ) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");  
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>"); 
			out.println("</body>");
			out.println("</html>");
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("/home/antu"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax( maxFileSize );

		try { 
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			/*out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");  
			out.println("</head>");
			out.println("<body>");*/
			session = request.getSession();

			while ( i.hasNext () ) {
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () ) {
					// Get the uploaded file parameters
					//String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					//String contentType = fi.getContentType();
					//boolean isInMemory = fi.isInMemory();
					//long sizeInBytes = fi.getSize();
					PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

					PersonalInfo pInfo = (PersonalInfo)session.getAttribute("otherObject");

					String str = request.getParameter("data");

					System.out.println(str);

					if(pInfo.getUserType().equals("project")) {

						filePath = getProjectLocation(str,pInfo);

					}else {

						filePath = getFileLocation(str,pInfo);

					}				


					String originalFName,string;
					String dbStr;
					string = pInfo.getUsername();
					string = string.replace('.', '_');
					// Write the file
					/*if( fileName.lastIndexOf("/") >= 0 ) {
						//file = new File( filePath + fileName.substring( fileName.lastIndexOf("/"))) ;
						if(uniquenessOfFile && !pInfo.getUserType().equals("project")) {												
							originalFName = filePath + string + fileName.substring(fileName.lastIndexOf("."));
							handler.addImage(pInfo.getUsername(), originalFName, pInfo.getUserType());
						}else if (uniquenessOfFile && pInfo.getUserType().equals("project")) {
							originalFName = "";

						}
						else{
							originalFName = filePath + fileName.substring( fileName.lastIndexOf("/"));

						}
						file = new File(originalFName) ;
					} else {*/
					//file = new File( filePath + fileName.substring(fileName.lastIndexOf("/")+1)) ;
					if(uniquenessOfFile && !pInfo.getUserType().equals("project")) {
						System.out.println("Profile picture of the client or freelancer");
						originalFName = filePath + string + fileName.substring(fileName.lastIndexOf("."));
						dbStr = originalFName.substring(originalFName.indexOf("images/"));
						
						handler.addImage(pInfo.getUsername(), dbStr, pInfo.getUserType());
						file = new File(originalFName) ;
						fi.write(file) ;
						User user = handler.getTheUser(myInfo.getUsername());
						//ArrayList<Comment> comments = handler.getComments(myInfo.getUsername());


						request.setAttribute("profile", user);

						//request.setAttribute("comments", comments);
						request.getRequestDispatcher("Profile.jsp").forward(request, response);


					}else if(uniquenessOfFile && pInfo.getUserType().equals("project")){
						System.out.println("Profile picture of the project");
						originalFName = filePath + string + fileName.substring(fileName.lastIndexOf("."));
						dbStr = originalFName.substring(originalFName.indexOf("images/"));
						handler.addImageToProject(pInfo, dbStr);
						file = new File(originalFName) ;
						fi.write(file) ;
						Project project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));
						ArrayList<Bidder> bidderList = new ArrayList<>();
						PersonalInfo developer = null;

						if(project.getStatus().equals("Bidding")) {

							bidderList = handler.getTheBidders(project.getProjectId());

							project.setBidders(bidderList);

							request.setAttribute("currProject",project);
							request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

						}else {
							developer = handler.getTheProjectDeveloper(project.getProjectId());				

							project.setDeveloper(developer);

							String paymentStatus = handler.getPaymentStatus(pInfo);

							project.setProjectDescription(paymentStatus);

							request.setAttribute("currProject",project);
							if(developer.getUsername().equals(myInfo.getUsername()) || project.getClientName().equals(myInfo.getUsername())) {

								request.getRequestDispatcher("ShowMyProject.jsp").forward(request, response);

							}		
							else {

								request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

							}

						}

					}else {
						System.out.println("File of the project");
						 
						Project project = handler.getTheProject(Integer.parseInt(pInfo.getUsername()));

						if(myInfo.getUserType().equals("freelancer")) {
							originalFName = filePath + fileName.substring(fileName.lastIndexOf("/")+1);
							handler.addFileToProject("Final", pInfo, originalFName);
							file = new File(originalFName) ;
							fi.write(file) ;

						}else {
							originalFName = filePath + fileName.substring(fileName.lastIndexOf("/")+1);
							handler.addFileToProject("NotFinal", pInfo, originalFName);
							file = new File(originalFName) ;
							fi.write(file) ;
						}
						ArrayList<Bidder> bidderList = new ArrayList<>();
						PersonalInfo developer = null;

						if(project.getStatus().equals("Bidding")) {

							bidderList = handler.getTheBidders(project.getProjectId());

							project.setBidders(bidderList);

							request.setAttribute("currProject",project);
							request.getRequestDispatcher("ShowParticularProject.jsp").forward(request, response);

						}else {
							developer = handler.getTheProjectDeveloper(project.getProjectId());				

							project.setDeveloper(developer);

							String paymentStatus = handler.getPaymentStatus(pInfo);

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
			/*out.println("</body>");
			out.println("</html>");*/
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with " +
				getClass( ).getName( )+": POST method required.");
	}
}