<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">

</head>

<body>

<div class="spacer"></div>
<div id="wrapper">

	<div class="header" style="display:''">
	
	</div>

	<div class="content">
<h2><c:out value="Welcome: ${name}" /></h2>
<h3><c:out value="Role: ${role}" /></h3>
<h3><c:out value="email: ${email}"></c:out></h3>

<table>				
<tr><td><a href="<c:url value="/" />">Home</a> </td></tr>
<tr><td><a href="<c:url value="/updateProfile" />">Update My Profile</a> </td></tr>
<tr><td><a href="<c:url value="/makeAppointment"/>"> Make an Appointment</a></td></tr>
</table>
  <form:form method = "post" action="processSelectionProfile" commandname="choice">
   <table>
   	<tr>
   		<td>
   			 <td><input type="hidden" name="name" value ="${name}"></td>
 			 <td><input type="hidden" name="email" value ="${email}"></td>
 			 <td><input type="submit" name="action" value ="updateProfile" >
 			 <td><input type="submit" name="action" value ="makeAppointment">
 			 <td><input type="submit" name="action" value ="Home">
 			 </td>
 			 </tr>
   </table>
   </form:form>
     <P>Hi!! This is your home page</P>    
 
	
</div>

</div>

</body>
</html>