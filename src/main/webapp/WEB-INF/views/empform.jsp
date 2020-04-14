<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/css/bootstrap.min.css" type="text/css"  rel="stylesheet">
<h1>Add New Employee</h1>
<hr>
<div>
<!-- Action is simpy processEmp as we have to replace current path with this without any complexities -->
	<form:form action="processEmp" modelAttribute="employee">
	<form:hidden path="id"/>
	<br>First Name<form:input path="firstName"/>
	<form:errors path="firstName" />
	<br>Last Name<form:input path="lastName"/>
	<form:errors path="lastName" />
	<br>Gender
	<form:radiobutton path="gender" value="M"/>Male
	<form:radiobutton path="gender" value="F"/>Female
	<form:errors path="gender" />
	<br>Skill
	<form:select path="skillSet">
		<form:option value="Java" label="Java" />
		<form:option value="C++" label="C++" />
		<form:option value="Python" label="Python" />
		<form:option value="Angular" label="Angular" />
	</form:select>
	<form:errors path="skillSet" />
	<br><input type="submit" value="Submit">
	</form:form>
</div>

<!-- 
       	 * 1. Login Page (default: admin, admin)
	 * 2. Redirect to Employee Management System (Perform CRUD Operations using JPA)
	 * 3. Employee Bean
	 * 	-> ID
	 *  -> FirstName
	 *  -> Last Name
	 *  -> Gender (radio)
	 *  -> Skillset (Dropdown) 
	 
	  -->
