<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
</head>
<body>
<div class="container"style="position: absolute; top: 35%;left: 50%; transform: translate(-50%, -50%);">
<div class="row">
<div class="col m6 offset-m3">
<div class = "card">
<div class = "card-content center-align">

<h3 style="margin-top: 10px">Login Here!!!!</h3>

<form  action="reg.jsp" method="post">

<input type="text" name="User_Name" placeholder="enter user name" />
<input type="password" name="User_pass" placeholder="enter password" />
<div style="text-align: left;"><a href="User_reg_form.jsp">New User?</a></div>
<button type="submit" class="btn #03a9f4 light-blue">Login</button>


</form>



</div>
</div>
</div>
</div>
</div>
<script
  src="https://code.jquery.com/jquery-3.6.3.min.js"
  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
  crossorigin="anonymous"></script>
  <script>
$(document).ready(function() {
	console.log("page is ready");
})
  </script>


</body>
</html>