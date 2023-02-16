<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About You</title>


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
    width: 90%;
    padding: 5px 20px;
    margin: 8px 0;
    display: inline-block;
    font-size: 26px;
    border: 1px solid #ccc;
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





<form method = "POST" action = "Description">


 <table align="center">


     <tr>
          <th><h1>Few words about you : </h1></th>
     </tr>

     <tr>

          <td> <textarea input type="text" style="font-size: 15pt" id="TITLE" name = "textarea" rows="6" cols="80"></textarea>
                      
      </tr>    

  </table>


         <table align="center">
              
        <td><input type="submit" id="sendbtn" name="submit_btn" class="button" value ="Submit" ></td>

        </table>

      </form>







</body>
</html>