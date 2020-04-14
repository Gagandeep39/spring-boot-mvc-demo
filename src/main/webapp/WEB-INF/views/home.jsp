<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

    <link href="/css/bootstrap.min.css" type="text/css"  rel="stylesheet">
</head>
<body class="container">
<h1 class="display-3">Welcome</h1>
<!-- http://localhost:8585/SpringMVC/loginCtrl/empform.obj -->
<h3>All Employees</h3>
	<table border="2" width="70%" cellpadding="2" class="table table-bordered table-hover">
	<tr><th>Id</th><th>Name</th><th>Gender</th><th>Skill</th><th colspan="2">Operation</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.firstName}  ${emp.lastName} </td>
    <td>${emp.gender}</td>
    <td>${emp.skillSet}</td>
    <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>  
    </tr>
    </c:forEach>
    </table>
    <br/>
<a href="${pageContext.request.contextPath}/empCtrl/empForm">Add Employee</a>
</body>
</html>