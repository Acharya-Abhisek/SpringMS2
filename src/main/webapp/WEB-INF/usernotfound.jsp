<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>


.pqr{
display: block;
text-align: center;
width : 400px;
height: 100px;
background-color:#F4F4F2;
position: absolute;
top:35%;
left:40%;

}
</style>
</head>
<body>
<div class="pqr">
<p style="color:red"><b><br>
User ID and Password does not match. </p><br><br><p style="color:black">Kindly 
<input type="button" value="Sign in" style="background-color:#9DDFD3"  onclick="goToLogin()">
again or
<input type="button" value="Sign up" style="background-color:#9DDFD3"  onclick="goToRegister()">
 if you are a new user.</b></p>
</div>


<script type="text/javascript">
function goToRegister(){
	window.location.href="/register";
}
</script>


<script type="text/javascript">
function goToLogin(){
	window.location.href="/";
}
</script>

</body>
</html>