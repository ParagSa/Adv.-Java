<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
</head>

<body style="background:url(Img/bg.jpeg); background-size:cover; background-attachment: fixed; ">
<div class="container"  style="position: absolute; top: 35%;left: 50%; transform: translate(-50%, -50%);">
<div class="row">
<div class="col m6 offset-m3">
<div class = "card">
<div class = "card-content center-align">

<h3 style="margin-top: 10px">Register Here!!!!</h3>

<form  action="reg.jsp" method="post">

<input type="text" name="User_Name" placeholder="enter user name" />
<input type="email" name="User_Email" placeholder="enter user email" />
<input type="password" name="User_pass" placeholder="enter password" />

<button type="submit" class="btn #03a9f4 light-blue">Register</button>


</form>

<div class="loader" style="margin-top: 10px;display: none;">
 
  <div class="preloader-wrapper big active">
      <div class="spinner-layer spinner-blue">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-red">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-yellow">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-green">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
    </div>
    <h5>Please wait.....</h5>


</div>

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