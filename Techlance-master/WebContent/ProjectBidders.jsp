<%@ page import="com.project.Bidder,java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Bidding Section</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Amatic SC", sans-serif
}

body, html {
	height: 100%
}

.menu {
	display: none
}

.bgimg {
	background-repeat: no-repeat;
	background-size: cover;
	background-image: url("images/Bid.jpg");
	min-height: 90%;
}

.button {
	background-color: #f4511e;
	border: none;
	color: white;
	padding: 8px 60px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 26px;
	margin: 4px 4px;
	cursor: pointer;
}

.button {
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.button:hover {
	background-color: #4CAF50; /* Green */
	color: white;
}

input[type=text], select {
	width: 90%;
	padding: 1px 100px;
	margin: 0.1px 0;
	display: inline-block;
	font-size: 26px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-weight: bold;
}

input[type=email], select {
	width: 90%;
	padding: 1px 150px;
	margin: 0.1px 0;
	display: inline-block;
	font-size: 26px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-weight: bold;
}

input[type=password], select {
	width: 90%;
	padding: 8px 20px;
	margin: 0.1px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-weight: bold;
}

input[type=dropdownlist], select {
	width: 90%;
	padding: 1px 10px;
	margin: 0.1px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-weight: bold;
}
</style>







<body class="bgimg w3-light-grey w3-content" style="max-width: 1600px">


	<div class="w3-container " style="margin-bottom: 32px">
		<h4>
			<b>Bidder Details</b>
		</h4>

		<% 
		    
		ArrayList<Bidder> bidders = (ArrayList<Bidder>)request.getAttribute("Bidders");
		out.print("<div class=\"w3-row-padding\" style=\"margin: 0 -16px\">" );
		
		for(Bidder bidder:bidders){
		        
			
			String urlMap = "<a href=\"WatchProfile?uId=" + bidder.getUsername() + "\">";
			out.println( "<div id = \""+ bidder.getUsername() + "\" class=\"w3-third w3-margin-bottom\">");
			out.println( "<ul");
			out.println("class=\"w3-ul w3-border w3-white w3-center w3-opacity w3-hover-opacity-off\">");
			out.println("<li class=\"w3-black w3-xlarge w3-padding-32\">"  + urlMap + bidder.getFullname() + "</li>");
			out.println( "<h2>" + bidder.getRating() + "</h2>");
			out.println( "<h2> $ " + bidder.getAmt() + "</h2>");
			out.println( "</li>");
			out.println( "</ul>");
			out.println( "</div>");
		}
		
		out.print("</div>");
		out.print("</div>");
		%>



		<!-- Contact Section -->
		<div class="w3-container w3-padding-large w3-grey">
			<h4 id="contact">
				<b>Contact Us</b>
			</h4>
			<div class="w3-row-padding w3-center w3-padding-24"
				style="margin: 0 -16px">
				<div class="w3-third w3-dark-grey">
					<p>
						<i class="fa fa-envelope w3-xxlarge w3-text-light-grey"></i>
					</p>
					<p>mamuncse@email.com</p>
				</div>
				<div class="w3-third w3-teal">
					<p>
						<i class="fa fa-map-marker w3-xxlarge w3-text-light-grey"></i>
					</p>
					<p>Dhaka, Bangladesh</p>
				</div>
				<div class="w3-third w3-dark-grey">
					<p>
						<i class="fa fa-phone w3-xxlarge w3-text-light-grey"></i>
					</p>
					<p>512312311</p>
				</div>
			</div>
			<hr class="w3-opacity">
		</div>






		<footer class="w3-container w3-teal w3-center w3-margin-top">
			<p>Find us on social media.</p>
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
			<p>
				Powered by <a href="https://www.google.com" target="_blank">Techlance</a>
			</p>
		</footer>
</body>
</html>