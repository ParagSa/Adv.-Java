<%@ page import="com.project.User,com.project.PersonalInfo,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My Profile</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

button {
	background-color: #f4511e;
	color: white;
	padding: 14px 20px;
	border: none;
	cursor: pointer;
	width: 90%;
	font-size: 20px;
}

button:hover {
	 background-color: #4CAF50; /* Green */
	opacity: 0.8;
}

.button1 {

    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 50px;
    text-align: center;
    text-decoration: bold;
    display: inline-block;
    font-size: 16px;
    margin: 2px 2px;
    cursor: pointer;
}

.button1 {
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button1:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}

.avatar {
	width: 200px;
	height: 200px;
	border-radius: 50%;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
}

.modal-content {
	background-color: #fefe;
	margin: 40% auto 15% auto;
	border: 1px solid #888;
	width: 40%;
	padding-bottom: 0px;
}

.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

.animate {
	animation: zoom 0.6s;
}

@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}
input[type=text] {
	width: 90%;
	padding: 1px 20px;
	margin: 8px 20px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 12px;
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
	font-family: Amatic SC color : #818181;
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
	font-family: Amatic SC margin-left : 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

input[type=text] {
	width: 300px;
	height: 40px;
	background-color: white;
	color: black; font size="90";
	font-family: Verdana, Arial, Helvetica, sans-serif;
	border: 2px solid red;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
   $(document).ready(function(){
	   $('#sendbtn').click(function(){
		   //var username = $('#username').val();
		   var msg = $('#msg').val();
		   //if(username != ''){
				$.ajax({
					url : 'ComposeMessage',
					method :'POST',
					data : {
						    "msg" : msg  
					       },
					success : function(){
						console.log("successful");
					}
					
					
					
				});
				
			//}
		   
	   });	   
	   
	   
	   
   });
   
   function closeDiv(){
	   document.getElementById('modal-wrapper').style.display='none';
	   
   }
   
   function openDiv(){
	   document.getElementById('modal-wrapper').style.display='block';
	   //document.getElementById('username').value = "";
	   document.getElementById('msg').value = "";
	   
   }

</script>

</head>
<body class="w3-light-grey w3-content" style="max-width: 1600px">




	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="#setting" onclick="closeNav()">Setting</a> <a href="#logout"
			onclick="closeNav()">Logout</a>


	</div>

	<div>

		<table style="margin-left: 1200px">
			<thead>

			</thead>
			<tbody>
				<form method="GET" action="HomeController">
					<tr>




						<td><span style="font-size: 30px; cursor: pointer"
							onclick="openNav()">&#9776;</span> <script>
									function openNav() {
									    document.getElementById("mySidenav").style.width = "250px";
									}

									function closeNav() {
									    document.getElementById("mySidenav").style.width = "0";
									}
					   </script></td>

					</tr>



				</form>
			</tbody>
		</table>

	</div>


	<% 	
				
				    User user = (User)request.getAttribute("profile");
				
					PersonalInfo otherInfo = (PersonalInfo)session.getAttribute("otherObject");
					
				%>



	<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		<div class="w3-container">
			<a href="#" onclick="w3_close()"
				class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey"
				title="close menu"> <i class="fa fa-remove"></i>
			</a>	
			<%
			if(user.getImagePath() != null){
			out.println("<img src=\"" + user.getImagePath() + "\"style=\" width: 75%;\" class=\"w3-round\"><br>"); 
			}else{
				out.println("<img src=\"images/mamun.jpg\" style=\" width: 75%;\" class=\"w3-round\"><br>");
				
			}
			%>
			<br>
			<h4>
				<b><%=user.getName() %></b>
			</h4>
			<p class="w3-text-grey">
				<%
			   out.println(user.getType());
			   
			%>
			</p>
			<%
			PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");
			
			if(user.getEmail().equals(myInfo.getUsername())){
				out.println("<form action = \"Upload?data=image\" method = \"POST\" enctype = \"multipart/form-data\">");
				out.println("<input type=\"file\" name=\"file\"	size=\"50\">");
				out.println("<button");
				out.println("class=\"w3-button w3-dark-grey w3-padding-large w3-margin-top w3-margin-bottom\">");
				out.println("<i class=\"fa fa-download w3-margin-right\"></i>Upload Picture");
			    out.println("</button>");
			    out.println("</form>");
				
				
			}
			if(!user.getEmail().equals(myInfo.getUsername())){
				out.println("<button onclick=\"openDiv()\"");
				out.println("class=\"w3-button w3-dark-grey w3-padding-large w3-margin-top w3-margin-bottom\">");
				out.println("<i class=\"fa fa-download w3-margin-right\"></i>Message");
			    out.println("</button>");
			    
			    out.println("<form method = \"GET\" action = \"MyProjects\">");
			    out.println("<button");
				out.println("class=\"w3-button w3-dark-grey w3-padding-large w3-margin-top w3-margin-bottom\">");
				out.println("<i class=\"fa fa-download w3-margin-right\"></i>Projects");
			    out.println("</button>");			    
			    out.println("</form>");
			    out.println("<div id=\"modal-wrapper\" class=\"modal\">");
			    out.println("<div>");
			    out.println("<span onclick=\"closeDiv()\" class=\"close\" title=\"close popup\">&times;</span>");
			    out.println("</div>");

			    out.println("<div class=\"container\">");
			   // out.println("<input id=\"username\" type=\"text\" placeholder=\"Enter Username\"");
			    //out.println("name=\"uname\"> ");
			    out.println("<input id=\"msg\" type=\"text\"");
			    out.println("placeholder=\"Type Something\" name=\"msg\">");
			    out.println("<button id=\"sendbtn\" type=\"submit\">Send</button>");
			    out.println("</div>");
			    out.println("</div>");
			}
			
			%>

		</div>
		<div class="w3-bar-block">
		
			<a href="#about" onclick="w3_close()"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-user fa-fw w3-margin-right"></i>ABOUT</a> <a
				href="#charges" onclick="w3_close()"
				class="w3-bar-item w3-button w3-padding w3-text-teal"><i
				class="fa fa-th-large fa-fw w3-margin-right"></i>CHARGES</a> <a
				href="#contact" onclick="w3_close()"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-envelope fa-fw w3-margin-right"></i>CONTACT</a>


		</div>
		<div class="w3-panel w3-large">
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
	</nav>


	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<div class="w3-main" style="margin-left: 300px">


		<div class="w3-row-padding w3-padding-16" id="about">
			<div class="w3-col m6"></div>
			<div class="w3-col m6"></div>
		</div>
		
		
				<div class="w3-container">
			<h5>Skill In Average</h5>

			<div class="w3-grey">
				<div class="w3-container w3-center w3-padding w3-green"
					style="width: <%=user.getRating()%>%"><%=user.getRating()%>%</div>
			</div>


		</div>

		<div class="w3-container w3-padding-large" style="margin-bottom: 32px">
			<h4>
				<b>About Me</b>
			</h4>
			<p>
				<% out.println(user.getDescription()); %>
			</p>
			<hr>
			<%
			if(user.getType().equals("freelancer")){
			      	
				ArrayList<String> experience = (ArrayList<String>)request.getAttribute("experience");
				
				out.println("<ul");
				out.println("class=\"w3-ul w3-border w3-white w3-center w3-opacity w3-hover-opacity-off\">");
				out.println("<li class=\"w3-teal w3-xlarge w3-padding-32\">Experience</li>");						

				
				for(int i = 0; i < experience.size();i++){
					out.println("<li class=\"w3-padding-16\">" + experience.get(i) + "</li>");				
					
				}
				out.println("</ul>");
				
			}			
			
			%>

		</div>







		<!-- Footer -->
		<footer class="w3-container w3-padding-32 w3-dark-grey">
			<div class="w3-row-padding">


<div class="w3-half ">
		<h3>BLOG POSTS</h3>
		<ul class="w3-ul w3-hoverable w3-hover-grey">
        
        
<li class="w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i><class="w3-left w3-margin-right" style="width: 50px"> <span class="w3-large"><a href="https://www.freelancer.com/community/articles/from-2-to-2-000-a-month-on-freelancer-com-in-2-years" title="TechLance" target="_blank" class="w3-hover-opacity">Earn</span><br> <span>$2 To $2,000 A Month</span></li></a>
        
<li class="w3-padding-16"><i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i><class="w3-left w3-margin-right" style="width: 50px"> <span class="w3-large"><a href="https://skillcrush.com/2014/06/12/blogs-freelancers-should-follow/" title="TechLance" target="_blank" class="w3-hover-opacity">12 Best</span><br> <span>Freelancing Blogs</span></li></a>        
        
 </ul>
        
</div>

				<div class="w3-half">
					<h3>POPULAR TAGS</h3>
					<p>
						<span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span
							class="w3-tag w3-grey w3-small w3-margin-bottom">New York</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">London</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">IKEA</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">NORWAY</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">DIY</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Ideas</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Baby</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Family</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">News</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Clothing</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Shopping</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Sports</span>
						<span class="w3-tag w3-grey w3-small w3-margin-bottom">Games</span>
					</p>
				</div>

			</div>
		</footer>

		<div class="w3-black w3-center w3-padding-24">
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				title="TechLance" target="_blank" class="w3-hover-opacity">w3.css</a>
		</div>
	</div>

	<!-- End page content -->

</body>
</html>