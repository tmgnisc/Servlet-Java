<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>This is Login Page.</h1>
<hr>
<p style="color:red">${error}	</p>
<form action="login" method="post">
Username<input type='text' name='username'><br><br>
Password<input type='password' name='password'><br><br>
<input type='submit' value='Login'>

</form>

</body>
</html>