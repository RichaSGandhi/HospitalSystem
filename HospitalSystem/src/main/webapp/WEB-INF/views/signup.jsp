<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital System Signup</title>
</head>
<body>
	<div>
		<h2>Welcome to Group 7 Hospital System Signup</h2>
	</div>
	<div><div class="spacer"></div>
	<div id="wrapper">
	<div class="header" style="display:''">
	</div>
	<div class="content">      
    	<div class="content-area">
			<h3>Please fill all the fields</h3>
			<form:form id ="newUserForm" name="newUserForm"  action="submit">
			<fieldset>
			<legend>Sign Up</legend>
			<div class="table">
			<table>
			<tr><td>Name </td><td><input type="String" id="name" name="name" placeholder = "Name" required></td></tr>
			<tr><td>E-mail: </td><td><input type="email" id="email" name="email" placeholder = "Email Id" required></td></tr>
			<tr><td>Password: </td><td><input  type="password" id="password" name="password" placeholder = "Password" required></td></tr>
			<tr><td>Role: </td><td><select id="role" name="role" placeholder = "Role" required style="width:146px">
 									 <option value="Doctor">Doctor</option>
								     <option value="Nurse">Nurse</option>
 									 <option value="Patient">Patient</option>
  									 </select></td></tr>
			</table>
			</div>
			</fieldset>
			<div class="row">
				<span class="fieldCell"><input class="PrimaryButton" type="submit" id="submitButton" value="Submit" />
				</span>  
			</div>
			</form:form>
		</div>
	</div>	
	</div>
</body>
</html>