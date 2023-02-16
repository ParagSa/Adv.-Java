<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
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
    padding: 10px 40px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
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

input[type=text1] {
 width: 300px;
 height: 40px;
 background-color: white;
 color: black;
 font size="90";
 font-family: Verdana, Arial, Helvetica, sans-serif;
 border: 2px solid red;
   
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
	 <h1>Your Expertise field :</h1>  

<div class="container"  style="width: 1200px">

       
        <div id = "finalList">
            <ol id="list"></ol>  
        </div> 
        <h1>Enter Language Name : </h1>
		 <input type="text" style="font-size: 15pt" name="language" id="language" class="form-control" placeholder="Enter Language"></input>
			
		<div id = "reqList"></div>
		<button id = "add_btn" class="button" >Add</button>
		<button id = "rmv_btn" class="button" >Remove</button>	
		<button id = "submit_btn" class="button" >Submit</button>
</div>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<script>
$(document).ready(function(){
	var array = [];
	
	$('#language').keyup(function(){
		var query = $(this).val();
		if(query != ''){
			$.ajax({
				url : 'DynamicList',
				method :'POST',
				data : {query : query},
				success : function(result){
					$('#reqList').fadeIn();				
					$('#reqList').html(result);	
				}		
				
				
			});
			
		}
		
		
	});
	
	$(document).on('click','li',function(){
		$('#language').val($(this).text());
		$('#reqList').fadeOut();
		
	});
	
	$('#add_btn').click(function (){
		
		var string = $("#language").val();
		console.log(string);
		if(string != '' && array.indexOf(string) == -1 ){
			$("#list").append("<li>" + string + "</li>");
			array.push(string);
			
		}
		
	});
	
	$('#rmv_btn').click(function (){
		
		console.log(array);
		$("li:last").remove();
		if(array.length > 0){
			array.pop();
			
		}
		
	});
	
	$('#submit_btn').click(function (){
		var language = {"name":array};
		var json = JSON.stringify(language);
		$.ajax({
			url : 'ExperienceEntry',
			method :'POST',
			data : {query : json},
			success : function(result){
				document.location.href='/Techlance/Description.jsp';
			}		
			
			
		});
		
	});
	
});
</script>	






<form method = "POST" action = "Description">


 <table align="center">


     <tr>
          <th><h2>Few words about you : </h2></th>
     </tr>

     <tr>

          <td> <textarea input type="text1" style="font-size: 15pt" id="TITLE" name = "textarea" rows="6" cols="80"></textarea>
                      
      </tr>    

  </table>


         <table align="center">
              
        <td><input type="submit" id="sendbtn" name="submit_btn" class="button" value ="Submit" ></td>

        </table>

      </form>
	
</body>
</html>