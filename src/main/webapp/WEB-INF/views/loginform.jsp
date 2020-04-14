<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
	<link href="/css/bootstrap.min.css" type="text/css"  rel="stylesheet">
</head>
<body class="container">
<h1 class="display-1">Login Page</h1>
<hr>
<form:form class="form-group" action="processForm" modelAttribute="user">
		<br>Username: <form:input class="form-control" path="username"/>
		<form:errors path="username"/>
		<br>Password: <form:input class="form-control" path="password"/>
		<form:errors path="password"/>
		<br><input type="submit" class="btn btn-primary" style="margin-top: 16px;" value="Submit">
	</form:form>
</body>
</html>