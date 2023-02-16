<%@page import="com.jobportal.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

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
<title>Job Portal - Profile Details</title>
<style>
body {
	background: rgb(40, 40, 40)
}
.updated_profile {
	min-height: 100vh;
	margin-top: 120px;
}

.col-md-5 {
	border: 1px solid black;
	margin: auto;
	background: #fff;
	border-radius: 20px;
}

input {
	display: inline-block;
	margin-bottom: 10px
}

</style>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css" />
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
	<div class="header">
		<div class="navbar_emp container-fluid">
			<nav class="navigation_bar_emp">
				<ul class="row ">
					<li style="font-size: 20px">Welcome <%=user.getFname().toUpperCase()%></li>
				</ul>
				<div class="nav_menu_emp">
					<a href="emphome.jsp" class="btn btn-success">Home</a> 
					<a
						href="updateProfileempr.jsp" class="btn btn-primary">Update Profile</a>
						<a
						href="postjob.jsp" class="btn btn-success">Post a Job</a> <a
						href="postedjobs" class="btn btn-info">Posted Job</a> <a
						href="logoutUser" class="btn btn-danger">Log Out</a>
				</div>
			</nav>
		</div>
	</div>

	<div class="container updated_profile">
		<div class="row">
			<div class="col-md-5 offset-md-3">
				<h3> Name : <%= user.getFname() + " "+user.getLname()  %> </h3>
				<h3> DateOfBirth : <%= user.getDateOfBirth() %> </h3>
				<h3> Email ID: <%= user.getEmail()%> </h3>
				<h3> Mobile Number : <%= user.getMobileNo() %> </h3>
				<h3> Address </h3>
				<h3> City  : <%= user.getCity() %> </h3>
				<h3> District : <%= user.getDistrict() %> </h3>
				<h3> State : <%= user.getState() %> </h3>																									
			</div>
		</div>
	</div>

	<footer id="footer">
		<div class="container footer">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<h3>About</h3>
					<p>We aim to provide job for a day for every individual who is
						looking out for an Job!</p>
					<ul>
						<li><a href="#facebook">facebook</a></li>
						<li><a href="#Twitter">Twitter</a></li>
						<li><a href="#Instagram">Instagram</a></li>
						<li><a href="#Yotube">YouTube</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-6">
					<h5>Employers</h5>
					<ul>
						<li><a href="">Register</a></li>
						<li><a href="">Post a Job</a></li>
						<li><a href="">Advance Skill Search</a></li>
						<li><a href="">Recruiting Service</a></li>
						<li><a href="">Blog</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-6">
					<h5>Workers</h5>
					<ul>
						<li><a href="">Register</a></li>
						<li><a href="">Post Your Skills</a></li>
						<li><a href="">Job Search</a></li>
						<li><a href="">Emploer Search</a></li>
					</ul>
				</div>
				<div class="col-md-3 col-sm-6">
					<h5>Have a question?</h5>
					<ul>
						<li><a href=""> 203, Ramsan Road, BKC Complex, Mumbai,
								India</a></li>
						<li><a href="">+91 02292 3929 210</a></li>
						<li><a href="">info@jobportal.com</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>


</body>
</html>