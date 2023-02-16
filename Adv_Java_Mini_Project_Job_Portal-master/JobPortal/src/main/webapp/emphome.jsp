<%@page import="com.jobportal.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css" />
<title>Job-Portal Home</title>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1

	response.setHeader("Pragma", "no-cache");//http 1.0

	response.setHeader("Expires", "0");//proxies 

	System.out.println("Inside this emphome");
	if (session.getAttribute("currentUser") == null) {
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
					<a href="searchjob.jsp" class="btn btn-success">Search job</a> <a
						href="updateProfile.jsp" class="btn btn-secondary">Update
						Profile</a> <a href="appliedjobs" class="btn btn-info">Applied
						Jobs</a> <a href="logoutUser" class="btn btn-danger">Log Out</a>
				</div>
			</nav>
		</div>
	</div>
	<main>
		<section id="main_emp_home">
			<div class="container">
				<div class="row emphome"></div>
			</div>

		</section>
	</main>
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