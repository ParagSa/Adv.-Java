<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a Project</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/new.css" />

<style>

.button {
    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 100px;
    text-align: center;
    text-decoration: bold;
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




input[type=email], select {
    width: 90%;
    padding: 1px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=password], select {
    width: 90%;
    padding: 1px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=text] {
    width: 90%;
    padding: 1px 20px;
    margin: 8px 20px;
    text-decoration: bold;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-size: 12px;
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
<body>




<nav class="w3-sidebar w3-black w3-animate-right w3-xxlarge" style="display:none;padding-top:150px;right:0;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="closeNav()" class="w3-button w3-black w3-xxxlarge w3-display-topright" style="padding:0 12px;">
    <i class="fa fa-remove"></i>
  </a>
  <div class="w3-bar-block w3-center">
    <a href="#logout" class="w3-bar-item w3-button w3-text-grey w3-hover-black" onclick="logout()">Logout</a>
  </div>
</nav>



	<div>

		<table style="margin-left: 550px">
			<thead>

			</thead>
			<tbody>
				<form method="GET" action="HomeController">
					<tr>


                    <td><input type="text" style="font-size: 13pt" placeholder="Freelancer,Client,Project"
                            name="searched_topic"><i class="fa fa-search"></i></td>
                        <td><input type="submit" name="home_btn" class="button1"
                            font-family: "Amatic+SC" value="Search"></td>


                        <td><input type="submit" name="home_btn" class="button1"
                            value="Home"></td>

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

<form action="CreateProject" method="POST">

	<table>
		
			<tr>
				<td><h3 class=" w3-text-black" >Project Name :</h3></td>

				<td><input type="text" style="font-size: 13pt" name="name" class="textInput"></td>
			</tr>
			<tr>
				<td><h3 class=" w3-text-black">Project Submission Date :</h3></td>
				<td><input id="date" name="duration" type="text" style="font-size: 13pt"></td>
			</tr>
		<tr>
			<td><h3 class=" w3-text-black" >Project Description :</h3></td>

			 <td> <textarea input type="text" style="font-size: 15pt" id="msgbox" name="msgarea" rows="6" cols="80"></textarea></td>

		</tr>

</table>

<table class="container" align="margin-left">
    <thead>
        <tr>
            <th><h1>Choose your Language of Interest :</h1></th>
           
       </tr>
    </thead>

		<tr>


			<td><input type="checkbox" name="favouriteLanguage" value="PHP" />PHP</td>

		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage" value="PERL" />PERL</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage" value="JAVA" />JAVA</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage" value="C#" />C#</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage"
				value="HTML,CSS" />HTML,CSS</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage"
				value="LARAVEL" />LARAVEL</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage"
				value="WORDPRESS" />WORDPRESS</td>
		</tr>
		<tr>

			<td><input type="checkbox" name="favouriteLanguage"
				value="JOOMLA" />JOOMLA</td>
		</tr>

    </table>

     <table align="center">
			
			<td><input type="submit" value="Submit" class="button"/></td>

    </table>
		</form>



	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$('#date').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
	</script>




</body>
</html>