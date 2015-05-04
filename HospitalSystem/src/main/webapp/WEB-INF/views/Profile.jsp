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
<script>

function AlertReleased() {
	alert("Bill for this patient has been Released");
}
</script>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>	
<script>

$( document ).ready(function() {
	var role = '${user.getJobTitle()}';
	var bill = '${billedList}';	
	var billAmount = '${billAmount}';
	if(role==("Patient")){
		$("#MakeAppointment").show();
		$("#releaseBill").hide();
		$("#viewPayCheck").hide();
		if (bill==null||billAmount<=0.0)
			$("#viewBill").hide();
		$("table td:nth-child(7),th:nth-child(7)").show();
		$("table td:nth-child(8),th:nth-child(8)").show();
	}
	if(role==("Admin")){
			$("#viewBill").hide();
			$("table td:nth-child(2),th:nth-child(2)").show();
			$("table td:nth-child(7),th:nth-child(7)").show();
			$("table td:nth-child(8),th:nth-child(8)").show();
			
				
	}
	if(role==("Nurse")){
		$("#releaseBill").hide();
		$("#viewBill").hide();
		$("table td:nth-child(2),th:nth-child(2)").show();
		$("table td:nth-child(7),th:nth-child(7)").show();
	}
	if (role==("Doctor")){
		$("#releaseBill").hide();
		$("#viewBill").hide();
		$("table td:nth-child(1),th:nth-child(1)").show();
		$("table td:nth-child(2),th:nth-child(2)").show();
		$("table td:nth-child(8),th:nth-child(8)").show();
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
			<div id = "UpdateLink"><a href="<c:url value="/updateProfile?email=${user.getPrimaryEmail()}" />">Update My Profile</a></div> 
			<div id = "MakeAppointment" hidden=true><a href="<c:url value="/makeAppointment?email=${user.getPrimaryEmail()}"/>"> Make an Appointment</a></div>
			<div id = "viewBill"><a href="<c:url value="/viewBill?email=${user.getPrimaryEmail()}&billAmount=${billAmount}" />">View Bill</a></div>
			<div id = "viewPayCheck"><a href="<c:url value="/viewPayCheck?email=${user.getPrimaryEmail()}" />">View Paycheck</a></div>
		</div>
		<div class="col-lg-8">
			<h2>List of appointments</h2>
			<form:form id ="viewPatientProfile" method="POST" action = "/hms/viewPatientProfile">	
			<input hidden=true name="email" value="${user.getPrimaryEmail()}">
			<table class="tableMax">
				<tr>
												<th hidden = true></th>
												<th hidden = true><div id="PatientNameHeader">Patient</div></th>
												<th>Start Time</th>
												<th>End Time</th><th>Date</th>
												<th>Day</th><th hidden = true><div id="DoctorNameHeader">Attending Doctor</div></th>
												<th hidden = true><div id="NurseNameHeader">Attending Nurse</div></th>
												<th></th>
				</tr>
				<c:choose>
		      		<c:when test="${empty appList}">
		      				<tr><td colspan="8" style="color:blue;text-align:left;"><strong>No upcoming Appointments!!</strong></td></tr>
		      		</c:when>
		
					 <c:otherwise>
							<c:forEach items="${appList}" var="app" >
						   						
						   			<tr>				   					
						   							<td hidden = true><button id="patientProfile"type = "submit" name="patientEmail" value = "${app.getPatient()}">View</button></td>	
						   							<td hidden = true style="text-align: center;"><div id="PatientName"><c:out value="${app.getPatientName()}"/></div></td>			   							
						   							<td style="text-align: center;"><c:out value="${app.getStartTime()}"/></td>
						   							<td style="text-align: center;"><c:out value="${app.getEndTime()}"/></td>				   							
						   							<td style="text-align: center;"><c:out value="${app.getAppDate()}"/></td>	
						   							<td style="text-align: center;"><c:out value="${app.getDay()}"/></td>
						   							<td hidden = true style="text-align: center;"><div id="DoctorName" ><c:out value="${app.getDoctorName()}"/></div></td>
						   							<td hidden = true style="text-align: center;"><div id="NurseName"><c:out value="${app.getNurseName()}"/></div></td>
						   							<td style="text-align: center;"><input id="appId" name="appId" value="${app.getAppId()}" hidden="true"></td>
						   							
						   			</tr>
							</c:forEach>										    
					 </c:otherwise>
				</c:choose>
			</table>
			</form:form>
			<form:form id ="releaseBill" method="POST" action = "/hms/releaseBill">	
			<input hidden=true name="email" value="${user.getPrimaryEmail()}">
			<br/>
			<br/>
			<table id = "released" class="tableMax">
				<tr>	
												<th><div id="PatientNameHeader">Patient</div></th>
												<th></th>
				</tr>
				<c:choose>
		      		<c:when test="${empty releasedUsers}">
		      				<tr><td colspan="8" style="color:blue;text-align:left;"><strong>No Patient Released by Doctor at the Moment</strong></td></tr>
		      		</c:when>
		
					 <c:otherwise>
							<c:forEach items="${releasedUsers}" var="release" >
						   						
						   			<tr>				   					
						   							
						   							<td style="text-align: center;"><div id="patient"><c:out value="${release}"/></div></td>
						   							<td><button id="ReleaseBill" onClick = "AlertReleased()" type = "submit" name="releaseBill" value = "${release}">Release Bill</button></td>	
						   							
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
