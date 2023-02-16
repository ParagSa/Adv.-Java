<%@ page
	import="com.project.Project,com.project.PersonalInfo,com.project.Bidder,java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Project</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<style>
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
<script>
	$(document)
			.ready(
					function() {
						$('#persons button')
								.on('click',
										function(event) {
											console.log($(this).closest(
													".w3-ul").find(
													"li.w3-black").text());

											var result = confirm("Do you want to confirm "
													+ $(this)
															.closest(".w3-ul")
															.find("li.w3-black")
															.text());

											if (result == true) {
												console.log($(this).closest(
														".w3-ul").find(
														"li.w3-padding-16")
														.text());
												$
														.ajax({
															url : 'SelectBidder',
															method : 'POST',
															data : {
																query : $(this)
																		.closest(
																				".w3-ul")
																		.find(
																				"li.w3-padding-16")
																		.text()
															},
															success : function(
																	result) {
																console
																		.log(result);

																document.location.href = '/Techlance/MyProjects?uId='
																		+ result;
															}

														});
											} else {
												txt = "You pressed Cancel!";
											}

										});
					});
</script>

</head>
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


	<%
		Project project = (Project) request.getAttribute("currProject");

		PersonalInfo myInfo = (PersonalInfo) session.getAttribute("myObject");
	%>

	<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
		style="z-index:3;width:300px;" id="mySidebar"> <br>
	<div class="w3-container">
		<a href="#" onclick="w3_close()"
			class="w3-hide-large w3-right w3-jumbo w3-padding w3-hover-grey"
			title="close menu"> <i class="fa fa-remove"></i>
		</a>
		<% 
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
		
		if(project.getClientName().equals(myInfo.getUsername()) && project.getStatus().equals("Bidding")){
			out.println("<p>");
			out.println("<form action = \"Upload?data=image\" method = \"POST\" enctype = \"multipart/form-data\">");
			out.println("<input type=\"file\" name=\"file\"	size=\"50\">");
			out.println("<button");
			out.println("class=\"w3-button w3-dark-grey w3-padding-small w3-margin-top w3-margin-bottom\">");
			out.println("<i class=\"fa fa-download w3-margin-right\"></i>Upload picture");
			out.println("</button>");
			out.println("</form>");
			out.println("</p>");
		}
		%>
	</div>

	</nav>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px">


		<div class="w3-container w3-padding-large" style="margin-bottom: 32px">
			<h2>
				<b><%=project.getName()%></b>
			</h2>
		</div>


		<div class="w3-container w3-padding-large" style="margin-bottom: 32px">
		    <h4>
				<b>Project Status : </b><b> <%=project.getStatus() %></b>
			</h4> 
			<h4>
				<b>Client Name : </b><b> <%=project.getClientName()%></b>
			</h4>


			<%
				if (project.getStatus().equals("Completed")) {
					out.println("<h4>Client Rating :</h4>");
					out.println("<div class=\"w3-grey\">");
					out.println("<div class=\"w3-container w3-center w3-padding w3-green\"");
					out.println("style=\"width:\">"+ project.getRating()*20 + "%</div>");
					out.println("</div>");
					out.println("</div>");
				}else{
					
					out.println("</div>");
				}
			
				ArrayList<Bidder> bidderList = null;
				session.setAttribute("project", project);
				session.setAttribute("otherObject",new PersonalInfo(Integer.toString(project.getProjectId()),"project"));

					if (project.getStatus().equals("Bidding")) {

						if (project.getBidders().size() > 0) {
							bidderList = (ArrayList<Bidder>) project.getBidders();
							out.println("<br>The Bidders</br>");

							out.println("<div id=\"persons\" class=\"w3-row-padding\" style=\"margin: 0 -16px\">");
							int counter = 1;
							String id;
							String urlMap;

							for (Bidder tmp : project.getBidders()) {

								id = "person" + counter;
								counter++;

								urlMap = "<a href=\"WatchProfile?uId=" + tmp.getUsername() + "\">";
								out.println("<div class=\"w3-third w3-margin-bottom\">");
								out.println(
										"<ul class=\"w3-ul w3-border w3-white w3-center w3-opacity w3-hover-opacity-off\">");
								out.println("<li class=\"w3-black w3-xlarge w3-padding-32\">" + urlMap + tmp.getFullname()
										+ "</a></li>");
								out.println("<li class=\"w3-padding-16\">" + tmp.getUsername() + "</li>");
								out.println("<h2> " + tmp.getRating() + "</h2>");
								out.println("<h2>$ " + tmp.getAmt() + "</h2>");
								if (myInfo.getUserType().equals("client")) {
									out.println("<li class=\"w3-light-grey w3-padding-24\">" + "<button type=\"submit\" id=\""
											+ id + "\"" + "class=\"w3-button w3-large w3-teal w3-padding2\" name=\"select_btn\""
											+ "class=\"button\" value=\"1\">Confirm</button>");
								}

								out.println("</li>");
								out.println("</ul>");
								out.println("</div>");

							}
							out.println("</div>");

						}

						boolean flag = false;

						if (myInfo.getUserType().equals("freelancer")) {
							if (project.getBidders().size() > 0) {
								for (int i = 0; i < bidderList.size(); i++) {
									if (bidderList.get(i).getUsername().equals(myInfo.getUsername())) {
										flag = true;
										break;
									}

								}
							}
							if (!flag) {
								out.println("<form method = \"POST\" action =\"BiddingProject\">");

								out.println("<input type=\"text\" name=\"amount\">");

								out.println("<input type=\"submit\" name=\"bid_btn\" value = \"Bid\">");

								out.println("</form>");
							} else {
								out.println("<form method = \"POST\" action =\"BiddingProject\">");

								out.println("<input type=\"text\" name=\"amount\">");

								out.println("<input type=\"submit\" name=\"bid_btn\" value = \"Change\">");

								out.println("</form>");

							}
						}

					} else{
						
						PersonalInfo developer = (PersonalInfo) project.getDeveloper();
						String urlMap = "<a href=\"WatchProfile?uId=" + developer.getUsername() + "\">";
						
						out.println("<div class=\"w3-container w3-padding-large\"");
						out.println("style=\"margin-bottom: 32px\">");
						out.println("<h4>");
						out.println("<b>Freelancer Name : " + urlMap + developer.getUserType()+ "</a></b><b></b>");
						out.println("</h4>");
                        if(project.getStatus().equals("Completed")){
							out.println("<h4>Freelancer Technical Skills:</h4>");
							out.println("<div class=\"w3-grey\">");
							out.println("<div class=\"w3-container w3-center w3-padding w3-green\"");
							out.println("style=\"width:\">"+ project.getFreelancerRating()*20 + "%</div>");
					        out.println("</div>");
                        }
				

						out.println("<hr>");
						out.println("<h4>Charged For The Project</h4>");					
						out.println("<div class=\"w3-row-padding\" style=\"margin: 0 -16px\">");
						out.println("<div class=\"w3-third w3-margin-bottom\">");
						out.println("<ul class=\"w3-ul w3-border w3-white w3-center\">");
						out.println("<li class=\"w3-padding-16\">");
						out.println("<h2>$ "+"</h2>");
						out.println("</ul>");
						out.println("</div>");
					    out.println("</div>");
					    
					}    
					
				%>







			<!-- Footer -->
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
		

		<script>
				// Script to open and close sidebar
				function w3_open() {
					document.getElementById("mySidebar").style.display = "block";
					document.getElementById("myOverlay").style.display = "block";
				}

				function w3_close() {
					document.getElementById("mySidebar").style.display = "none";
					document.getElementById("myOverlay").style.display = "none";
				}
			</script>
</body>
</html>

</body>
</html>