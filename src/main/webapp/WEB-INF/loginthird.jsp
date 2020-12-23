<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>


.abc{
display: block;
text-align: center;
width : 350px;
height: 200px;
position: absolute;
top:30%;
left:40%;

}
</style>
</head>
<body>
Login MS<br><br><br>
<div class="abc">
	<form action ="/login" method ="post" style="background-color:#F4F4F2">
		<br><br>
		<div>USER ID :&nbsp &nbsp &nbsp &nbsp &nbsp  
		<input type="number" name ="userId" placeholder="User ID"></div><br>
		
	    <div>USERNAME :&nbsp  <input type="text" name ="userName" placeholder="User Name"></div><br>
		
		<c:if test="${not empty error }">
		<div><b>${error}</b></div><br>
		<br>
		</c:if>
		
		<c:if test="${not empty registrationsuccess }">
		<div><b>${registrationsuccess}</b></div><br>
		<br>
		</c:if>
		
		<c:if test="${not empty passworderror }">
		<div><b>${passworderror}</b></div><br>
		<br>
		</c:if>
		
		<c:if test="${not empty userIderror }">
		<div><b>${userIderror}</b></div><br>
		<br>
		</c:if>
		
		<c:if test="${not empty someerror }">
		<div><b>${someerror}</b></div><br>
		<br>
		</c:if>
		
		<div>PASSWORD :&nbsp &nbsp <input type="password" name ="password" placeholder="Password"></div><br><br><br>
		<div><input type="submit" value="Sign in" align="center" style="background-color:#9DDFD3">
		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		
		
		<input type="button" value="Sign up" style="background-color:#9DDFD3"  onclick="goToRegister()"></div><br>

</form>
</div>

<script type="text/javascript">
function goToRegister(){
	window.location.href="/register";
}

</script>


</body>
</html>