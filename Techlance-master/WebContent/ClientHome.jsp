<%@ page import="com.project.PersonalInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Welcome to TechLance</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<style>
body, html {
	height: 100%
}

body, h1, h2, h3, h4, h5, h6 {
	font-family: "Amatic SC", sans-serif
}

.menu {
	display: none
}

.bgimg {
	background-repeat: no-repeat;
	background-size: cover;
	background-image: url("images/backgroundimage.jpg");
	min-height: 90%;
}

input[type=text] {
	width: 300px;
	height: 40px;
	background-color: white;
	color: black; font size="90";
	font-family: Verdana, Arial, Helvetica, sans-serif;
	border: 2px solid red;
}

.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 4;
    top: 500;
    left: 500;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 50px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    font-family:Amatic SC
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 25px;
    font-family: Amatic SC
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 30px;}
}

input[type=text] {
 width: 300px;
 height: 40px;
 background-color: white;
 color: black;
 font size="90";
 font-family: Verdana, Arial, Helvetica, sans-serif;
 border: 2px solid red;
   
}

#nameList {
	position: absolute;
	background-color: black;
	z-index: 1000;
}




</style>
<body>


<nav class="w3-sidebar w3-black w3-animate-right w3-xxlarge" style="display:none;padding-top:150px;right:0;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="closeNav()" class="w3-button w3-black w3-xxxlarge w3-display-topright" style="padding:0 12px;">
    <i class="fa fa-remove"></i>
  </a>
  <div class="w3-bar-block w3-center">
    <a href="#logout" class="w3-bar-item w3-button w3-text-grey w3-hover-black" onclick="logout()">Logout</a>
  </div>
</nav>

	
	<%
		PersonalInfo myInfo = (PersonalInfo) session.getAttribute("myObject");
	%>
	<div class="w3-top w3-hide-small">
		<div class="w3-bar w3-xlarge w3-black " id="myNavbar">

			<table class="container">
				<thead>

				</thead>
				<tbody>
					<form method="GET" action="ClientHomeController">
					<tr>
						<td><input type="submit"
							class="w3-button w3-xxlarge w3-black w3-padding2" name="home_btn"
							class="button" value="My Workspace"></td>
						<td><input type="submit"
							class="w3-button w3-xxlarge w3-black w3-padding2" name="home_btn"
							class="button" value="Profile"></td>

						<td><input type="submit"
							class="w3-button w3-xxlarge w3-black w3-padding2" name="home_btn"
							class="button" value="Msgs"></td>	
							
						<td><input type="submit"
							class="w3-button w3-xxlarge w3-black w3-padding2" name="home_btn"
							class="button" value="Notification"></td>
							
						<td><input type="submit"
							class="w3-button w3-xxlarge w3-black w3-padding2" name="home_btn"
							class="button" value="Create A Project"></td>
													<td><input type="text" name="searchTopic" id="searchedText"
								class="form-control" placeholder="Freelancer,Client,Project"></input>
								<div id="nameList"></div>
							</td>
							<td><input type="submit"
								class="w3-button w3-xxlarge w3-black w3-padding2"
								name="home_btn" class="button" value="Search"></td>
						
							<td><input type="submit"
								class="w3-button w3-xxlarge w3-black w3-padding2"
								name="home_btn" class="button" value="Statistics">
							</td>
				

											
						
							<td><span style="font-size:40px;cursor:pointer" onclick="openNav()">&#9776;</span></td>



                        	<td>
						<script>

							
								function openNav() {
								    document.getElementById("mySidebar").style.width = "20%";
								    document.getElementById("mySidebar").style.display = "block";
								}

								function closeNav() {
								    document.getElementById("mySidebar").style.display = "none";
								}


								function logout() {
									    document.getElementById("mySidebar").style.display = "none";
									    document.location.href='/Techlance/LogOut';
									}
					   </script>


					</td>		  

					</tr>
					</form>
				</tbody>
			</table>

		</div>
	</div>



	<div
		class="bgimg w3-display-container w3-animate-opacity w3-text-white">
		<div class="w3-display-topleft w3-padding-large w3-xlarge"></div>
		<div class="w3-display-middle">
			<h1 class="w3-jumbo w3-animate-top">TECHLANCE</h1>
			<hr class="w3-border-grey" style="margin: auto; width: 40%">
			<p class="w3-large w3-right">Build your online team</p>
		</div>

		<div class="w3-display-bottomleft w3-padding-large ">
			<p>An Online Platform For Freelancers</p>
			Powered by <a href="https://www.google.com" target="_blank">Techlance</a>
		</div>
	</div>



</body>
</html>