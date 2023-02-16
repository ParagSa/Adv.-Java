<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SuccessFul</title>

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

.button1 {
    background-color: #4CAF50;
    border: none;
    color: red;
    padding: 10px 100px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 26px;
    margin: 4px 4px;
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

input[type=text], select {
    width: 50%;
    padding: 5px 20px;
    margin: 8px 0;
    display: inline-block;
    font-size: 26px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    border: 1px solid red;
    border-radius: 4px;
    box-sizing: border-box;

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


</style>

</head>
<body>


	 <table align="center">


     <tr>
          <th><h1>Successfully File Uploaded </h1></th>
     </tr>
  

  </table>




          <form method="POST" action="ParticularProject">

         <table align="center">
              
        <td><input type="submit" id="sendbtn" name="send_btn" class="button" value ="Okay" ></td>

        </table>

      </form>

</body>
</html>