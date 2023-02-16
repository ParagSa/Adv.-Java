<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/new.css" />

<style>
.button {
    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 180px;
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


.button2 {
    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 105px;
    text-align: center;
    text-decoration: bold;
    display: inline-block;
    font-size: 26px;
    margin: 4px 4px;
    cursor: pointer;

}

.button2 {
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button2:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}

.button3 {
    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 130px;
    text-align: center;
    text-decoration: bold;
    display: inline-block;
    font-size: 26px;
    margin: 4px 4px;
    cursor: pointer;

}

.button3 {
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button3:hover {
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

        <table style="margin-left: 1200px">
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



         
              

       


    <table align="center">

    <tr>
	<td><canvas id="mycanvas" width="400" height="400"></canvas></td>
    </tr>
    <tr>
	<td><button class="button" id = "chart_btn"> Chart </button></td>
    </tr>
    <tr>
	<td><button class="button2" id = "freelancer_btn">Freelancer Statistics</button></td>
    </tr>
    <tr>
	<td><button class="button3" id = "client_btn">Client Statistics</button></td>
    </tr>

   </table>


		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
		<script>
$(document).ready(function(){

	$('#chart_btn').click(function(){
		$.ajax({
			url : 'GetStatistics',
			method : 'POST',
			data:{
				query:"PL"
				
			},
			success : function(result) {
				console.log(result);
				var data = JSON.parse(result);
				var ctx = document.getElementById("mycanvas").getContext('2d');
				var myChart = new Chart(ctx, {
				    type: 'bar',
				    data,
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				});
			}

		});
		
	
});
	
	$('#freelancer_btn').click(function(){
		$.ajax({
			url : 'GetStatistics',
			method : 'POST',
			data:{
				query:"Freelancer"
				
			},
			success : function(result) {
				console.log(result);
				var data = JSON.parse(result);
				var ctx = document.getElementById("mycanvas").getContext('2d');
				var myChart = new Chart(ctx, {
				    type: 'bar',
				    data,
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				});
			}

		});
		
	
});
	
	$('#client_btn').click(function(){
		$.ajax({
			url : 'GetStatistics',
			method : 'POST',
			data:{
				query:"Client"
				
			},
			success : function(result) {
				console.log(result);
				var data = JSON.parse(result);
				var ctx = document.getElementById("mycanvas").getContext('2d');
				var myChart = new Chart(ctx, {
				    type: 'bar',
				    data,
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				});
			}

		});
		
	
});
	
	
	
});

</script>
</body>
</html>