<%@ page import="com.project.Message,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>

<title>Inbox</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />

 <style>


.button {
    background-color: #f4511e;
    border: none;
    color: white;
    padding: 10px 100px;
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
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  font-size: 12px;
}

.button1 {
    background-color: #4CAF50;
    border: none;
    color: red;
    padding: 10px 50px;
    text-align: center;
    text-decoration: none;
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
    background-color: #E6E6FA; /* Green */
    color: red;
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
 font-family: Verdana, Arial, Helvetica, sans-serif;
 border: 2px solid red;
   
}

</style>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function(){
		   $('#sendbtn').click(function(){
			   //var username = $('#username').val();
			   var msg = $('#msgbox').val();
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

</script>
<body>








       
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#setting" onclick="closeNav()" >Setting</a>
  <a href="#logout" onclick="closeNav()" >Logout</a>


</div>

         <div>

      <table style="margin-left:1200px">
        <thead>

        </thead>
        <tbody>
          <form method="GET" action="HomeController">
          <tr>
    

            <td><input type="text" style="font-size: 13pt"  name="searched_topic"><i class="fa fa-search"></i></td>
             <td><input type="submit"  name="home_btn" 
              class="button1"  font-family: "Amatic+SC" value="Search"></td>


                          <td><input type="submit"
               name="home_btn" class="button1" value="Home"></td>


          <td>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>


            <script>
                  function openNav() {
                      document.getElementById("mySidenav").style.width = "250px";
                  }

                  function closeNav() {
                      document.getElementById("mySidenav").style.width = "0";
                  }
             </script>


          </td>
                       
          </tr>



          </form>
        </tbody>
      </table>

</div>


	<h1> <span class="yellow">My Inbox</pan></h1>

	<div id="result"></div>


<table class="container">
	<thead>

		<tr>
			<th><h1>Sender</h1></th>
			<th><h1>Receiver</h1></th>
			<th><h1>Message</h1></th>
			<th><h1>Date</h1></th>
		</tr>

	</thead>

   <% 


	ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("messages");
	
	for(Message msg:messages){
		
		//out.println("<tr>");	 
		//out.println("<td>" + msg.getSender() + "</td>");
		//out.println("<td>" + msg.getReceiver() + "</td>");
		//out.println("<td>" + msg.getMessage() + "</td>");
		//out.println("<td>" + msg.getDate() + "</td>");
		//out.println("</tr>");	
	%>
         <tr>
         	 <td><%=msg.getSender()%></td>
         	 <td><%=msg.getReceiver()%></td>
         	 <td><%=msg.getMessage()%></td>
         	 <td><%=msg.getDate()%></td>


	    </tr>
   <%  

	     }
	

	%>

       <form method="POST" action="ParticularMessageSevlet">
 <table align="center">


     <tr>
          <th><h1>Enter your message here </h1></th>
     </tr>

     <tr>

          <td> <textarea input type="text" style="font-size: 15pt" id="msgbox" name="msgarea" rows="6" cols="80"></textarea>
                      
      </tr>    

  </table>


   

         <table align="center">
              
        <td><input type="submit" id="sendbtn" name="send_btn" class="button" value ="Send" ></td>

        </table>

      </form>
		
	

</body>
</html>