<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
	<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
	<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>	
<script>

$( document ).ready(function() {
	var role = '${user.getJobTitle()}';
	var bill = '${billedList}';
	var appointments = '${appList}';
	if(role==("Patient")){
		$("#MakeAppointment").show();
		if (!(bill==null))
		$("#viewBill").show();
	//	$("#DoctorName").show();
	//	$("#NurseNameHeader").show();
	//	$("#NurseName").show();
		
	}
		if(role==("Admin")){
			alert(role);
		for(var i = 0; i<appointments.length()-1;i++){
			alert(i);
			$("#patientProfile").show();
		}
		
		/*$("#PatientNameHeader").show();
		$("#PatientName").show();
		$("#NurseNameHeader").show();
		$("#NurseName").show();*/
	
	}
	if(role==("Nurse")){
		/*$("#DoctorNameHeader").show();
		$("#DoctorName").show();*/
	}
});
</script>
</head>

<body>

<div class="row">
	
		<h2><c:out value="Welcome: ${user.getName()}" /></h2>
		<h3><c:out value="Role: ${user.getJobTitle()}" /></h3>

</div>

<div class="row">
		<div class="col-lg-4">		
			<a href="<c:url value="/" />">Home</a>
			<div id = "UpdateLink"><a href="<c:url value="/updateProfile?email=${user.getPrimaryEmail()}" />">Update My Profile</a></div> 
			<div id = "MakeAppointment" hidden=true><a href="<c:url value="/makeAppointment"/>"> Make an Appointment</a></div>
			<div id = "viewBill" hidden=true><a href="<c:url value="/viewBill"/>">View Bill</a></div>
		</div>
		<div class="col-lg-8">
			<h2>List of upcoming appointments</h2>
			<form:form id ="viewPatientProfile" method="POST" action = "/hms/viewPatientProfile">	
			<input hidden=true name="email" value="${user.getPrimaryEmail()}">
			<table class="tableMax">
				<tr>
												<th></th>
												<th><div id="PatientNameHeader">Patient</div></th>
												<th>Start Time</th>
												<th>End Time</th><th>Date</th>
												<th>Day</th><th><div id="DoctorNameHeader">Attending Doctor</div></th>
												<th><div id="NurseNameHeader">Attending Nurse</div></th>
				</tr>
				<c:choose>
		      		<c:when test="${empty appList}">
		      				<tr><td colspan="8" style="color:blue;text-align:left;"><strong>No upcoming Appointments!!</strong></td></tr>
		      		</c:when>
		
					 <c:otherwise>
							<c:forEach items="${appList}" var="app" >
						   						
						   			<tr>				   					
						   							<td><button id="patientProfile" type = "submit" name="patientEmail" hidden=true value = "${app.getPatient()}">View</button></td>	
						   							<td style="text-align: center;"><div id="PatientName"><c:out value="${app.getPatientName()}"/></div></td>			   							
						   							<td style="text-align: center;"><c:out value="${app.getStartTime()}"/></td>
						   							<td style="text-align: center;"><c:out value="${app.getEndTime()}"/></td>				   							
						   							<td style="text-align: center;"><c:out value="${app.getAppDate()}"/></td>	
						   							<td style="text-align: center;"><c:out value="${app.getDay()}"/></td>
						   							<td style="text-align: center;"><div id="DoctorName" ><c:out value="${app.getDoctorName()}"/></div></td>
						   							<td style="text-align: center;"><div id="NurseName"><c:out value="${app.getNurseName()}"/></div></td>
						   							<td><button id="ReleaseBill" type = "submit" name="ReleaseBill" hidden=true value = "${app.getPatient()}">Release Bill</button></td>	
						   							<td style="text-align: center;"><input id="appId" name="appId" value="${app.getAppId()}" hidden="true"></td>
						   							
						   			</tr>
							</c:forEach>										    
					 </c:otherwise>
				</c:choose>
			</table>
				</form:form>
			
	</div>
</div>

</body>
</html>
