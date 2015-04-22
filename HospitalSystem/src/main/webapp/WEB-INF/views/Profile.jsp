<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<script>
	$( document ).ready(function() {
		var role = '${user.getJobTitle()}';
		if(role==("Patient")){
			$("#MakeAppointment").show();
		}
	});
</script>
</head>

<body>

<div class="spacer"></div>
<div id="wrapper">

	<div class="header" style="display:''">
	
	</div>

	<div class="content">
<h2><c:out value="Welcome: ${user.getName()}" /></h2>
<h3><c:out value="Role: ${user.getJobTitle()}" /></h3>
			
<a href="<c:url value="/" />">Home</a>
<h2>List of upcoming appointments</h2>
								<table class="tableMax">
									<tr>
										<th></th>
										<th>Patient</th>
										<th>Start Time</th>
										<th>End Time</th><th>Date</th>
										<th>Day</th><th>Attending Doctor</th>
										<th>Attending Nurse</th>
									</tr>
								<c:choose>
      							<c:when test="${empty appList}">
      								<tr><td colspan="8" style="color:blue;text-align:left;"><strong>No upcoming Appointments!!</strong></td></tr>
      							</c:when>

							    <c:otherwise>
									<c:forEach items="${appList}" var="app" >
				   						
				   						<tr>				   					
				   							<td><button id="selectedUser" type = "submit" name="email" hidden=true value = "${user.getPrimaryEmail()}">Select</button></td>	
				   							<td style="text-align: center;"><c:out value="${app.getPatientName()}"/></td>			   							
				   							<td style="text-align: center;"><c:out value="${app.getStartTime()}"/></td>
				   							<td style="text-align: center;"><c:out value="${app.getEndTime()}"/></td>				   							
				   							<td style="text-align: center;"><c:out value="${app.getAppDate()}"/></td>	
				   							<td style="text-align: center;"><c:out value="${app.getDay()}"/></td>
				   							<td style="text-align: center;"><c:out value="${app.getDoctorName()}"/></td>
				   							<td style="text-align: center;"><c:out value="${app.getNurseName()}"/></td>
				   						</tr>
									</c:forEach>										    
							    </c:otherwise>
							</c:choose>
							</table>
<div id = "UpdateLink"><a href="<c:url value="/updateProfile?email=${user.getPrimaryEmail()}" />">Update My Profile</a></div> 
<div id = "MakeAppointment" hidden=true><a href="<c:url value="/makeAppointment"/>"> Make an Appointment</a></div>

     <P>Hi!! This is your home page</P>    
 
	
</div>

</div>



</body>
</html>