<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Employee Detials</title>
<!-- Include CSS File Here -->
<!--<link rel="stylesheet" href="D:/shrgupta/bootstrap-4.1.1-dist/css/bootstrap.min.css" type="text/css" />-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--<link rel-"text/javascript" src="D:/Users/shrgupta/Desktop/employee _registration/validation.js"/>-->
<link rel="stylesheet" href="/css/style.css"/>  

<script type="text/javascript" src="/js/postrequest.js"></script>


<script>
    function myFunction() {
      document.getElementById("empform").reset();
    }
    </script>
<script type="text/javascript">
function validation(){
	
	var name=document.getElementById("fname").value;
	var lname=document.getElementById("lname").value;
	var email=document.getElementById("email").value;
	var phoneNumber=document.getElementById("pno").value;
	var emailFormat=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var phoneFormat=/^\d{10}$/;
	alert(phoneNumber);
	if(name==null || name==""){
		alert("Name cannot be null");
	}else if(lname==null || lname==""){
		alert("Last Name cannot be null");
	}
	if(email.match(emailFormat)){
		return true;
	}else{
		alert("Email is wrong !!")
	}
	if(phoneNumber.match(phoneFormat)){
		return true;
	}else{
		alert("Phone number should be 10 digit !!")
	}
}
</script>
<script type="text/javascript">
function emailValidation(inputType){
	var emailFormat=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(inputType.value.match(emailFormat)){
		return true;
	}else{
		alert("Email is wrong !!")
	}
}
</script>
</head>
<body>
 <!--<body background="D:/Users/shrgupta/Desktop/employee _registration/download.jpg" class="img-rounded" alt="Cinque Terre">-->
<div class="container">
<div class="invisible">
    <h1>Steria Bank | Building faith.................since 1885</h1>
  </div>
  <div id="top-image">
	<img src="/images/soprasteria.png"  align="left" height="50" width="250"></img>
	</div>
  <div id="topMostBar">
    
    <div id="topMostInner3"> Bulding faith<span style="font-weight:normal;">.................</span>since 1885.
	 </div>
  </div>
  
	
<div class ="header">
<div class="jumbotron">

 <center> <h2>Employee Details</h2> </center>

 </div>
 </div>


<div class="main" >
<form id="empform" class="form" method="post" action="#" name="form"> 
 <center> 

  <table cellspacing="10%" cellpadding="10%">
  <div id= "wrap1">
    <tr class="spaceUnder">
    <div class="form-group" >
      <td><label for="fname">First Name:</label>&nbsp;</td>
      <td><input type="text" class="form-control" id="fname"name="fname"></td>
    </div>
	</tr>
	
	<tr class="spaceUnder">
	<div class="form-group">
		<td><label for="lname">Last Name:</label>&nbsp;</td>
    <td> <input type="text" class="form-control" id="lname" name="lname"></td>
    </div>
	</tr>
   
	<tr class="spaceUnder">
	<div class="form-group">
      <td><label for="email">Email:</label>&nbsp;</td>
      <td><input type="text" class="form-control" id="email" name="email"></td>
    </div>
    </tr>
    
	
	<tr class="spaceUnder">
	<div class="form-group">
      <td><label for="datepicker">DOB:</label>&nbsp;</td>
      <td><input type="date" class="form-control" id="dob" placeholder="dd/mm/yyyy" name="datepicker"></td>
     </div>
    </tr>
    

	<tr class="spaceUnder">
	<div class="form-group">
	  <td><label for="gender">Gender:</label>&nbsp;</td>
	  <div class="radio">
	  <td><label><input id="male" type="radio" name="optradio" value="male">Male</label>
    &nbsp;&nbsp; <label><input id="female" type="radio" name="optradio" value="female">Female</label></td>
	</div>
      </div>
    </tr>
    
    <tr class="spaceUnder">
	<div class="form-group">
      <td><label for="pno">Phone Number:</label>&nbsp;</td>
      <!--<td><input type="number" class="form-control" id="pno"></td>-->
  <td><input type="text" class="form-control" id="pno" size="28" min='10' max='10' required="" name="pno"></td>
	</div>
    </tr>
    
    <tr class="spaceUnder">
	<div class="form-group">
      <td><label for="address">Address:</label>&nbsp;</td>
      <td><textarea class="form-control" rows="5" id="address" name="address"></textarea></td>
    </div>
    </tr>
    
	</div>
</table>
&nbsp;&nbsp;
<div id="btn">
  <button type="button" class="btn btn-primary" id="register" onclick="validation()">Register</button>&nbsp;
  <button type="button" class="btn btn-primary" onclick="myFunction()">Clear</button>&nbsp;
  <button type="button" class="btn btn-primary">Search</button>&nbsp;

</div>
</form>
</center>
<div  id ="line" >
	<hr>
</div>


<div  id ="table-demo" class= "details"> 

<table class="table table-striped">
  <thead>
    <tr>
	  <th scope="col">Employee ID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
	   <th scope="col">DOB</th>
	    <th scope="col">Phone Number</th>
		 <th scope="col">Gender</th>
		  <th scope="col">Address</th>
    </tr>
  </thead>
    <tbody id="myTable">
   
    <%-- <c:forEach items="${employeeRecords}" var="emp">
            <tr>	
         <td> <c:out value="${emp.emdId}"></c:out></td>
          <td> <c:out value="${emp.firstName}"></c:out></td>
           <td> <c:out value="${emp.lastName}"></c:out></td>
            <td> <c:out value="${emp.emailId}"></c:out></td>
             <td> <c:out value="${emp.dateOfBirth}"></c:out></td>
              <td> <c:out value="${emp.phoneNumber}"></c:out></td>
               <td> <c:out value="${emp.gender}"></c:out></td>
              <td> <c:out value="${emp.address}"></c:out></td>   
          </c:forEach>     --%>      
         <!--  </tr> -->
		</tbody>
  </table>

</div>
<div id= "delete">
<button type="button" class="btn btn-primary">Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
&nbsp;&nbsp;
</div>&nbsp;&nbsp;
<div id="footer"> &copy; 2006-2007 Steria Bank Corporation Pvt. Ltd., All rights reserved;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</div>&nbsp;
</div>
</body>
</html>