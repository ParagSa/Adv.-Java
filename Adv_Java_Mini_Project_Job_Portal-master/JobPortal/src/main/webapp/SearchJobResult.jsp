<%@page import="com.jobportal.model.User"%>
<%@page import="com.jobportal.model.JobOpening"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/main.css" />
<title>Available Jobs</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background: url("img/banner1.jpg") no-repeat 0 0;
	background-size: cover;
	min-height: 100vh;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}
</style>
</head>
<body>
	<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");;

	response.setHeader("Pragma", "no-cache");
	
	System.out.println("Inside this emphome");
	if(session.getAttribute("currentUser") == null){
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


					<li style="font-size: 20px">Welcome <%= user.getFname().toUpperCase()%></li>
				</ul>
				<div class="nav_menu_emp">
					<a href="emphome.jsp" class="btn btn-success">Home</a> <a
						href="searchjob.jsp" class="btn btn-success">Search job</a> <a
						href="" class="btn btn-info">Applied Jobs</a> <a href="logoutUser"
						class="btn btn-danger">Log Out</a>
				</div>
			</div>
		</div>
	</div>

	<!-- =========== Searched Result  ================== -->

	<h3 class="Searchheading">Available Jobs in Searched Skills</h3>
	<%
	List<JobOpening> jobOpenings = (List<JobOpening>) session.getAttribute("jobOpenings");

	for (JobOpening jobOpening : jobOpenings) {
	%>
	<form action="applyForJob">
		<div class="container jobdata">
			<div class="row ">
				<div class="col jobtitle">
					<h2>
						<%=jobOpening.getSkillsReq()%>
					</h2>
				</div>
			</div>
			<div class="row jobdata">
				<div class="col-md-3 jobdetails">
					<h4>
						Job City is
						<%=jobOpening.getJobCity()%>
					</h4>
				</div>
				<div class="col-md-3 jobdetails">
					<h4>
						Work date is
						<%=jobOpening.getWorkDate()%>
					</h4>
				</div>
				<div class="col-md-3 jobdetails">
					<h4>
						Recruiter's Contact Number
						<%=jobOpening.getMobileNumber()%>
					</h4>
				</div>
				<input type="hidden" name="WorkId"
					value="<%= jobOpening.getWorkId() %>">
				<div class="col-md-3 jobdetails">
					<input type="submit" class="btn btn-success" value="Apply" />
				</div>
			</div>
		</div>
	</form>
	<%
	}
	%>

</body>
</html>