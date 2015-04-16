<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Make Appointment</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/demo_table.css" />">
	<script>function getDoctorsDetails(){
		var doctor = document.getElementById('selectedUser').value;
		alert("Warning: Are you sure you want to make appointment with "+doctor+"?");
	}
		</script>
	</head>
	
	<body>
		<div class="spacer"></div>
		<div id="wrapper">
		
			<div class="header" style="display:''">	</div>
		
			<div class="content">     
		    	<div class="content-area">
				<h2>Please Search for Appointments here based on Departments</h2>
				
				
				<form:form id ="makeAppointment" method="GET">
			<div>	
			<table>
		<tr>			
			<th> Departments :</th> <th><select id="Department" name = "department" required style="width:146px">
									 <option value="general">General Physician</option>
 									 <option value="cardiology">Cardiologist</option>
								     <option value="neurology">Neurology</option>
 									 <option value="pediatrics">Pediatrics</option>
 									 <option value="gynaecology">Gynaecology</option>
  									 </select></th>
  									 <th></th>
			<th> <input class="PrimaryButton" type="submit" id="submitButton" value="Search" name="search"/> </th>	
		</tr>	
			</table>	
				</div>
		
			</form:form>					
				<h2>Available Doctors</h2>
								
				<table class="tableMax">
									<tr>
										<th></th>
										
										<th>Doctor Name</th>
										<th>Affiliation</th><th>Degree</th>
										<th>Specialization</th><th>Available Days</th>
									</tr>
						
							<c:choose>
      							<c:when test="${empty doctorList}">
      								<tr><td colspan="8" style="color:blue;text-align:left;"><strong>No Doctors currently available in this department. Try searching for a General Physician .</strong></td></tr>
      							</c:when>

							    <c:otherwise>
									<c:forEach items="${doctorList}" var="user" >
				   						
				   						<tr>				   					
				   							<td><button id="selectedUser" type = "submit" name="selectDoc" value = "${user}">Select</button></td>				   							
				   							<td id= "docName" style="text-align: center;"><c:out value="${user.getName()}"/></td>
				   							<td style="text-align: center;"><c:out value="${user.getAffiliation()}"/></td>				   							
				   							<td style="text-align: center;"><c:out value="${user.getDegree()}"/></td>	
				   							<td style="text-align: center;"><c:out value="${user.getSpecialization()}"/></td>
				   							<td style="text-align: center;"><c:out value="${user.getAvailableDays()}"/></td>
				   						</tr>
									</c:forEach>										    
							    </c:otherwise>
							</c:choose>
						
					</table>
					
					<br>
					<br>
		
					<a href="<c:url value="/" />">Home</a> <br>
				    	
				</div>
			</div>
		</div>
	</body>
</html>