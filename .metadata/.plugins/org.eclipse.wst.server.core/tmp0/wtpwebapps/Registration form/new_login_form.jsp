<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src="https://kit.fontawesome.com/yourcode.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
    $(() => {
      console.log("login script working fine....")
      $("#reg_submit").click(() => {

        console.log("click on register_submit...")

        if ($("#fname").val() != "" && $("#lname").val() != "" && $("#emailID").val() != "" && $("#password").val() && $("#Confirmed_Pass").val() != "") {

          let input = {
            password: $("#password").val(),
            Confirmed_Pass: $("#Confirmed_Pass").val()
          }
          console.log(input.password)
          console.log(input.Confirmed_Pass)
          console.log(input.password !== input.Confirmed_Pass)

          if (input.password !== input.Confirmed_Pass) {
            alert("Password doest not match with the confirmed password, Please enter correct one!")
          } 
        }
        else {
          alert("Please enter the correct details, input can not be blank!")
        }

      })

    })
  </script>
<title>DigiRozgar - You are one step away from getting a job for
	a day!</title>
</head>

<body style="background:url(Img/bg-2.jpg); background-size:cover;">
	<!-- ========== header ============ -->

	<header id="header">
		<div class="container search_job_header">
			<div class="row breakcrum_row">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item active">Login</li>
					</ol>
				</nav>
			</div>
			<div class="container" id="login-page">
				<div class="row">
					<div class="col-lg-4 col-md-6 offset-lg-4 offset-md-3">
						<div class="row">
							<div class="col-6">
								<h6 id="login-bar" class="lead">Login</h6>
							</div>
							<div class="col-6">
								<h6 id="reg-bar" class="lead">Register</h6>
							</div>
						</div>
						<div class="row flex-nowrap" id="login-page-toggle">
							<div class="col-12" id="old_user_login">

								<form action="login" method="post">

									<div class="row text-center">
										<label for="">Log In as</label>
									</div>

									<input class="form-check-input" type="radio" name="role"
										value="employer"> <label class="form-check-label">
										Employer </label> <input class="form-check-input" type="radio"
										name="role" value="employee"> <label
										class="form-check-label">Employee </label> <br> <label
										for="">user ID</label> <input type="text" name="userID"
										placeholder="User ID" class="form-control" required> <br>
									<label for="">Password</label> <input type="password"
										name="password" placeholder="secret key" class="form-control"
										required>
									<!-- <span id="forget-pass" disabled=""><a href="forgetPass.html">forgot password?</a></span> -->
									<span> <input type="checkbox" name="rememberMe"
										value="yes"> Remember Me 
									</span><br> <span id="update-pass"><a
										href="updatePass.html">Forgot Password?</a></span> <br>
									<div class="row">
										<div class="col-3 offset-5">
											<input type="submit" value="login"> <br>
								</form>

							</div>
						</div>
					</div>
					<div class="col-12" id="reg_new_user">
						<form action="user-registration" method="post">
							<div id="register_from">
								<label for="">First Name</label> <input type="text" name="fname"
									id="fname" placeholder="Please enter your First Name"
									class="form-control" required> <label for="">Last
									Name</label> <input type="text" name="lname" id="lname"
									placeholder="Please enter your last Name" class="form-control"
									required> <label for="">Email ID</label> <input
									type="email" name="emailID" id="emailID" placeholder="email id"
									class="form-control" required> <label for="">Choose
									Your Role</label>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="employer"> <label class="form-check-label">
										Employer </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="employee"> <label class="form-check-label">
										Employee </label>
								</div>

								<label for="">Create Password</label> <input type="password"
									name="password" id="password" placeholder="password"
									class="form-control" required>
								<!-- <span id="forget-pass">your password must have at least 8 characters</span> -->
								<label for="">Confirm Password</label> <input type="password"
									id="Confirmed_Pass" name="Confirmed_Pass"
									placeholder="Confirm password" class="form-control" required>
								<br>
								<div class="row">
									<div class="col-3 offset-5">
										<input type="submit" id="reg_submit" value="signUp"> <br>
										<br>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- ================ main ============= -->
	<!-- ============== nav_menu ============ -->
	<div class="nav_menu navigation" id="nav-menu">
		<div class="row">
			<div class="col-md-3 justify-content-space-between">
				<div class="row title-bar">
					<div class="col-9">
						<h2>
							<a class="title" href="index.html">DigiRozgar</a>
						</h2>
					</div>
					<div class="col-3 d-sm-none" id="menu-icon">
						<i class="fa fa-list" id="menu_toggle"></i>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<nav class="row">
					<div class="col-sm-7">
						<ul class="nav_bar">
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">About</a></li>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="contact.html">Contact</a></li>
							<li><a href="login.html">Login</a></li>
						</ul>
					</div>
					<div class="col-sm-5">
						<a href="postjob.html" class="btn bg-primary text-light">Post
							a Job</a> <a href="index.html" class="btn bg-success text-light">Search
							a Job</a> <a href="adminlogin.jsp" class="btn bg-success text-light">Admin
							Login</a>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- ==================== Footer ================== -->

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
<script src="js/main.js">
</script>
</html>