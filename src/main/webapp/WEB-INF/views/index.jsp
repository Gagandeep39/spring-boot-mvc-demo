<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="/css/bootstrap.min.css" type="text/css"  rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome to Spring MVC
	<% response.sendRedirect("loginCtrl/LoginForm"); %>

<!-- 	 
	<form action="loginCtrl/ValidateLogin.obj">
		Name<input type="text" name="txtName"> 
		Password<input type="password" name="txtPassword"> 
		<input type="submit" value="Login">
	</form>

 -->
</body>
</html>