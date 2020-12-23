

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>


.def{
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
Registration page....<br><br>
<div class="def">
	<form action ="/set-user" method ="post" style="background-color:#F4F4F2">
		<br><div>USER ID :&nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp
		<input type="number" name ="uId" placeholder="User ID"></div><br><br>
		<div>USERNAME : &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp
		<input type="text" name ="userName" placeholder="User Name"></div><br><br>
		<div>PASSWORD : &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp
		<input type="password" name ="password1" placeholder="Password"></div><br><br>
		<div>RE-TYPE PASSWORD : <input type="password" name ="password2" placeholder="Re-Type Password"></div><br><br>
		
		<div><input type="submit" value="Register" style="background-color:#9DDFD3"></div><br><br>

</form>
</div>
</body>
</html>