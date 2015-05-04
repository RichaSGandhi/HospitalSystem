<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function returnBack() {
	alert("Your Appointment has been reserved. THANKS!!");
		window.location.href = "/hms/profile?email=${user.getPrimaryEmail()}";	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Appointment Selected ${app.day} ${app.appointment} </h2>
	<h3>Confirmation Email Has been Sent</h3>
	<div align="center">
<button onclick="returnBack()">OKAY</button>
</div>
</body>
</html>