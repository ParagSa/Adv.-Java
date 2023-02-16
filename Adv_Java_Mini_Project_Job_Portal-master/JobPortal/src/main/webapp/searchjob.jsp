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
<link rel="stylesheet" href="css/style.css">
<title>Job Portal - Search Job</title>
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
	<!-- ==================== header ================== -->
	<div class="header_emp">
		<div class="navbar_emp container-fluid">
			<div class="navigation_bar_emp">
				<ul class="row ">
					<li style="font-size: 20px">Welcome <%= user.getFname().toUpperCase()%></li>
				</ul>
				<div class="nav_menu_emp">
					<a href="emphome.jsp" class="btn btn-success">Home</a> <a
						href="appliedjobs" class="btn btn-info">Applied Jobs</a> <a
						href="logoutUser" class="btn btn-danger">Log Out</a>
				</div>
			</div>
		</div>
	</div>

	<header id="header">
		<div class="container search_job_header">
			<div class="row">
				<div class="col job_search">
					<h6 class="lead">We have 850,000 great job offers you deserve!
					</h6>
					<h1 class="display1 mt-5">
						You can Search Job<br />of your choice Below
					</h1>
				</div>
			</div>
			<form action="searchjob" method="post">
				<div class="row">
					<div class="col-md-4">
						<label for="" class="form-label"></label> <input name="jobtitle"
							class="form-control" type="text" placeholder="Job Title" />
					</div>
					<div class="col-md-4">
						<label for="" class="form-label"></label> <input name="date"
							class="form-control" type="date" />
					</div>
					<div class="col-md-4">
						<label for="" class="form-label"></label> <input name="location"
							class="form-control" type="text" placeholder="location" />
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div id="searchjob" class="col-2 m-auto">
							<button type='submit' class='btn btn-success mt-5'>search</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</header>
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

