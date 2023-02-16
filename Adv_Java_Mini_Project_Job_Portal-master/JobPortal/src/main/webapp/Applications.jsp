<%@page import="com.jobportal.model.JobOpening"%>
<%@page import="java.util.List"%>
<%@page import="com.jobportal.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Job-Portal</title>
</head>

<body style="background: rgb(40, 40, 40)">
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	;

	response.setHeader("Pragma", "no-cache");

	System.out.println("Inside this emphome");
	if (session.getAttribute("currentUser") == null) {
		System.out.println("Inside if condition");
		response.sendRedirect("login.html");
		return;
	}
	User user = (User) session.getAttribute("currentUser");
	System.out.println(user);
	%>
	<div class="header_emp">
		<div class="navbar_emp container-fluid">
			<div class="navigation_bar_emp">
				<ul class="row ">
					<li style="font-size: 20px">Welcome <%=user.getFname().toUpperCase()%></li>
				</ul>
				<div class="nav_menu_emp">
					<a href="emprhome.jsp" class="btn btn-success">Home</a> <a
						href="postjobempr.jsp" class="btn btn-info">Post another Jobs</a>
					<a href="postedjobs" class="btn btn-info">Posted Jobs</a> <a
						href="logoutUser" class="btn btn-danger">Log Out</a>
				</div>
			</div>
		</div>
	</div>

	<h3 class="Searchheading">Below are the applications received for
		the job </h3>
	<%
	List<User> applications = (List<User>) session.getAttribute("applications");

	for (User applicant : applications) {
	%>
	<form action="applyForJob">
		<div class="container jobdata">
			<div class="row ">
				<div class="col jobtitle">
					<h2>
						Applicant Name :
						<%=applicant.getFname() + " " + applicant.getLname()%>
					</h2>
				</div>
			</div>
			<div class="row jobdata">
				<div class="col-md-3 jobdetails">
					<h4>
						Address :
						<%=applicant.getCity() + " " + applicant.getState() %>
					</h4>
				</div>
				<div class="col-md-3 jobdetails">
					<h4>
						Mobile Number
						<%=applicant.getMobileNo()%>
					</h4>
				</div>

				<div class="col-md-3 jobdetails">
					<h4>
						Email ID
						<%=applicant.getEmail()%>
					</h4>
				</div>
				<div class="col-md-3 jobdetails">
					<a href="" class="btn btn-success">Offer</a> <a href=""
						class="btn btn-danger">Reject</a>
				</div>
			</div>
		</div>
	</form>
	<%
	}
	%>


</body>
</html>