<%@ page
	import="com.project.Project,com.project.PersonalInfo,java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<% 

  Project project = (Project)request.getAttribute("currProject");
  PersonalInfo myInfo = (PersonalInfo)session.getAttribute("myObject");

%>
<title><%= project.getName() %></title>

<style>
	
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
  .sidenav a {font-size: 18px;}
}

input[type=text] {
 width: 300px;
 height: 40px;
 background-color: white;
 color: black;
 font size="90";
 text-decoration: bold;
 font-family: Verdana, Arial, Helvetica, sans-serif;
 border: 2px solid red;
   
}
</style>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<script>    
	$(document).ready(function() {
		
		var x = $("#rateYo").rateYo({
		    rating: 3.0
		  });			 
		
	    $("#ratebtn").click(function(){
	    	$.ajax({	    		
				url : 'Rate',
				method :'POST',
				data : {rating : x.rateYo("option", "rating")},
				success : function(result){
					$('#rateYo').style.display = 'none';
					$("#ratebtn").style.display = 'none'
					console.log(result);
					
					document.location.href='/MyPro/ParticularProjectServlet?pId=' + result;
				}					
				
			});				
		});		
		
		$('#commentbtn').on('click', function(event) {
		var result = confirm("Do you want to post the comment");
			
			if (result == true) {
				console.log($('#cmtbox').val());
				$.ajax({
					url : 'AddComments',
					method :'POST',
					data : {comment : $('#cmtbox').val()},
					success : function(result){
						console.log(result);
						
						document.location.href='/Techlance/ParticularProjectServlet?pId=' + result;
					}					
					
				});
			} else {
			    txt = "You pressed Cancel!";
			}	


		});
	});
</script>
<body class="w3-light-grey w3-content" style="max-width: 1600px">

<nav class="w3-sidebar w3-black w3-animate-right w3-xxlarge" style="display:none;padding-top:150px;right:0;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="closeNav()" class="w3-button w3-black w3-xxxlarge w3-display-topright" style="padding:0 12px;">
    <i class="fa fa-remove"></i>
  </a>
  <div class="w3-bar-block w3-center">
    <a href="#logout" class="w3-bar-item w3-button w3-text-grey w3-hover-black" onclick="logout()">Logout</a>
  </div>
</nav>

         <div>

            <table style="margin-left:1200px">
                <thead>

                </thead>
                <tbody>
                    <form method="GET" action="HomeController">
                    <tr>
        


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



	<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
		style="z-index:3;width:300px;" id="mySidebar"> <br>
	<div class="w3-container">
		<a href="#" onclick="w3_close()"
			class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey"
			title="close menu"> <i class="fa fa-remove"></i>
		</a><%
		if(project.getImagePath() != null){
			out.println("<img src=\""+ project.getImagePath()+"\" style=\"width: 75%;\"");
			out.println("class=\"w3-round\"><br> <br>");
		}		
		
		out.println("<h4>");
	    out.println("<b>"+project.getName() +"</b>");
		out.println("</h4>");
		
		out.println("<h5>");
	    out.println("<b>PROJECT</b>");
		out.println("</h5>");
		
		
		
		%> 

	</div>

	</nav>
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px">


		<div class="w3-container w3-padding-large" style="margin-bottom: 32px">
			<h2>
				<b><%=project.getProjectDescription() %></b>
			</h2>
		</div>
        <div class="w3-container w3-padding-large" style="margin-bottom: 32px">
			<h2>
				<b>Project Status : <%=project.getStatus() %></b>
			</h2>
		</div>

		<div class="w3-container w3-padding-large" style="margin-bottom: 32px">			

			<%
			PersonalInfo developer = (PersonalInfo) project.getDeveloper();
			String clientUrl = "<a href=\"WatchProfile?uId=" + project.getClientName() + "\">";
			String urlMap = "<a href=\"WatchProfile?uId=" + developer.getUsername() + "\">";
			
			out.println("<h4>");
			out.println("<b>Client Name : </b><b> " +clientUrl +  project.getClientName() + "</a></b>");
			out.println("</h4>");
        	out.println("<h4>");
			out.println("<b>Freelancer Name : </b><b>" + urlMap +  developer.getUserType() +"</a></b>");
			out.println("</h4>");
			
				if (project.getStatus().equals("Completed")) {
					out.println("<h4>Client Rating :</h4>");
					out.println("<div class=\"w3-grey\">");
					out.println("<div class=\"w3-container w3-center w3-padding w3-green\"");
					out.println("style=\"width:\">"+ project.getFreelancerRating()*20 + "%</div>");
					out.println("</div>");
					out.println("</div>");
					
				}else{
					
					out.println("</div>");
				}
			%>

			<% 
if(project.getStatus().equals("Running") && myInfo.getUserType().equals("freelancer")){
	out.println("The place for uploading");
	out.println("<form action=\"Upload?data=file\" method=\"POST\" enctype=\"multipart/form-data\">");
	out.println("Necessary files to upload : <input type=\"file\" name=\"file\"");
    out.println("size=\"50\"> <br /> <input type=\"submit\" value=\"Upload File\" />");
    out.println("</form>");	
    
    if(project.getClientFile() != null){
		out.println("<form action=\"DownloadFile?file_req=requirement\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"download\" value=\"Download The Requirement File\" />");
		out.println("</form>");
	}
	
}else if(project.getStatus().equals("Running") && myInfo.getUserType().equals("client")){
	out.println("The File is not submitted.");
	if(project.getFilePath() != null){
		out.println("<form action=\"DownloadFile?file_req=final\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"downloadfinal\" value=\"Download The  File\" />");
		out.println("</form>");
	}
	
}else if(project.getStatus().equals("Completed") && myInfo.getUserType().equals("client") ){
	if(project.getProjectDescription().equals("unpaid")){	
		out.println("<form action=\"Account.jsp\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"payment\" value=\"Pay\" />");
		out.println("</form>");
	}
	if(project.getFreelancerRating() == 0){
		out.println("<div id=\"rateYo\"></div>");
		out.println("<button id=\"ratebtn\" name=\"show\">Rate</button>");
	}
	if(project.getClientFile() != null){
		out.println("<form action=\"DownloadFile?file_req=requirement\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"download\" value=\"Download The Requirement File\" />");
		out.println("</form>");
	}
	if(project.getFilePath() != null){
		out.println("<form action=\"DownloadFile?file_req=final\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"downloadfinal\" value=\"Download The  File\" />");
		out.println("</form>");
	}
	
	
}else{
	
	if(project.getClientFile() != null){
		out.println("<form action=\"DownloadFile?file_req=requirement\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"download\" value=\"Download The Requirement File\" />");
		out.println("</form>");
	}
	if(project.getFilePath() != null){
		out.println("<form action=\"DownloadFile?file_req=final\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"downloadfinal\" value=\"Download The  File\" />");
		out.println("</form>");
	}
	
	if(project.getRating() == 0){
		out.println("<div id=\"rateYo\"></div>");
		out.println("<button id=\"ratebtn\" name=\"show\">Rate</button>");
	}
}


%>

			<input id="cmtbox" type="text" name="fullname" class="textInput">

			<button id="commentbtn" type="submit">Comment</button>

			<!-- Footer -->
			<footer class="w3-container w3-padding-32 w3-dark-grey">
			<div class="w3-row-padding">
				<div class="w3-third">
					<h3>FOOTER</h3>
					<p>Present tincidunt sed tellus ut rutrum. Sed vitae justo
						condimentum, porta lectus vitae, ultricies congue gravida diam non
						fringilla.</p>
					<p>
						Powered by <a href="https://www.w3schools.com/w3css/default.asp"
							target="_blank">w3.css</a>
					</p>
				</div>

				<div class="w3-third">
					<h3>BLOG POSTS</h3>
					<ul class="w3-ul w3-hoverable">
						<li class="w3-padding-16"><img src="/w3images/workshop.jpg"
							class="w3-left w3-margin-right" style="width: 50px"> <span
							class="w3-large">Lorem</span><br> <span>Sed mattis
								nunc</span></li>
						<li class="w3-padding-16"><img src="/w3images/gondol.jpg"
							class="w3-left w3-margin-right" style="width: 50px"> <span
							class="w3-large">Ipsum</span><br> <span>Praes tinci
								sed</span></li>
					</ul>
				</div>

				<div class="w3-third">
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
				Powered by <a href="https://www.google.com" title="Techlance"
					target="_blank" class="w3-hover-opacity">Techlance</a>
			</div>

			<!-- End page content -->
		</div>
</body>
</html>