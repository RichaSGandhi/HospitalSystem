<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Update User Profile</title>

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h2>Update Profile page</h2>
				<p>Its absolutely quick!</p>
			</div>
		</div>

		<div></div>
	</div>

	<form:form id="myForm" method="post" action="processUpdateAdminProfile"
		commandName="admin" class="bs-example form-horizontal">
		<fieldset>
			<legend>Update Profile Form</legend>
						<!-- Start of standard user profile Table -->
			<table>

				<!-- The first row [username name middleName lastname]  -->
				<tr>


					<th><form:label path="username">UserName:</form:label></th>
					<th><form:input path="username" readonly="true"></form:input></th>
					<th><form:label path="Name">Name:</form:label></th>
					<th><form:input type="text" path="Name"></form:input></th>
					<th><form:label path="middleName">Middle Name</form:label></th>
					<th><form:input type="text" path="middleName"></form:input></th>
					<th><form:label path="lastName">Last Name</form:label></th>
					<th><form:input type="text" path="lastName"></form:input></th>


				</tr>
				<tr>
					<!-- SecondRow [sex maritalstatus role mobilephone] -->
					<th><form:label path="sex">Sex:</form:label></th>
					<th><form:select path="sex">
							<form:option value="male" label="Male" />
							<form:option value="female" label="Female" />
						</form:select></th>
					<th><form:label path="maritialStatus">Maritial Status:</form:label></th>
					<th><form:input type="text"  path="maritialStatus"></form:input></th>
					<th><form:label path="jobTitle">Role:</form:label></th>
					<th><form:input path="jobTitle" readonly="true"></form:input></th>
					<th><form:label path = "dateOfBirth">Date of Birth:</form:label></th>
					<th><form:input type="date" path ="dateOfBirth" ></form:input></th>




				</tr>
				<tr>
					<!-- Thirdrow [moblePhone primaryPhone secondaryPhone SecondaryEmail -->
					<th><form:label path="mobilePhoneNumber">Mobile Number:</form:label></th>
					<th><form:input type="number" path="mobilePhoneNumber"></form:input></th>
					<th><form:label path="primaryPhone">Phone Number:</form:label></th>
					<th><form:input type="number" path="primaryPhone"></form:input></th>
					<th><form:label path="secondaryPhone">Secondary Phone Number:</form:label></th>
					<th><form:input type="number" path="secondaryPhone"></form:input></th>
					<th><form:label path="secondaryEmail">secondaryEmail:</form:label></th>
					<th><form:input type="email" path="secondaryEmail"></form:input></th>
				</tr>
				<tr>
					<th><form:label path="userAddress.street">Street Address:</form:label></th>
					<th><form:input type="text" path="userAddress.street"></form:input></th>
					<th><form:label path="userAddress.city">City:</form:label></th>
					<th><form:input type="text" path="userAddress.city"></form:input></th>
					<th><form:label path="userAddress.state">State:</form:label></th>
					<th><form:select path="userAddress.state">
							<form:option value="" label=""/>
							<form:option value="AL" label="Alabama"/>
							<form:option value="AK" label="Alaska"/>
							<form:option value="AZ" label="Arizona"/>
							<form:option value="AR" label="Arkansas"/>
							<form:option value="CA" label="California"/>
							<form:option value="CO" label="Colorado"/>
							<form:option value="CT" label="Connecticut"/>
							<form:option value="DE" label="Delaware"/>
							<form:option value="FL" label="Flordia"/>
							<form:option value="GA" label="Georgia"/>
							<form:option value="HI" label="Hawaii"/>
							<form:option value="ID" label="Idaho"/>
							<form:option value="IN" label="Indiana"/>
							<form:option value="IA" label="Iowa"/>
							<form:option value="KS" label="Kansas"/>
							<form:option value="KY" label="Kentucky"/>
							<form:option value="LA" label="Louisiana"/>
							<form:option value="ME" label="Maine"/>
							<form:option value="MD" label="Maryland"/>
							<form:option value="MA" label="Massachusetts"/>
							<form:option value="MI" label="Michigan"/>
							<form:option value="MN" label="Minnesota"/>
							<form:option value="MS" label="Mississippi"/>
							<form:option value="MO" label="Missouri"/>
							<form:option value="MT" label="Montana"/>
							<form:option value="NE" label="Nebraska"/>
							<form:option value="NV" label="Neveda"/>
							<form:option value="NH" label="New Hampshire"/>
							<form:option value="NJ" label="New Jersey"/>
							<form:option value="NM" label="New Mexico"/>
							<form:option value="NY" label="New York"/>
							<form:option value="NC" label="North Carolina"/>
							<form:option value="ND" label="North Dakota"/>
							<form:option value="OH" label="Ohio"/>
							<form:option value="OK" label="Oklahoma"/>
							<form:option value="OR" label="Oregon"/>
							<form:option value="PA" label="Pennsylvania"/>
							<form:option value="RI" label="Rhode Island"/>
							<form:option value="SC" label="South Carolina"/>
							<form:option value="SD" label="South Dakota"/>
							<form:option value="TN" label="Tennessee"/>
							<form:option value="TX" label="Texas"/>
							<form:option value="UT" label="Utah"/>
							<form:option value="VT" label="Vermont"/>
							<form:option value="VA" label="Virgina"/>
							<form:option value="WA" label="Washinton"/>
							<form:option value="WV" label="West Virgina"/>
							<form:option value="WI" label="Wisconson"/>
							<form:option value="WY" label="Wyoming"/>

						</form:select></th>
					<th><form:label path="userAddress.zipCode">ZIPCODE:</form:label></th>
					<th><form:input type="number" path="userAddress.zipCode"></form:input></th>
				</tr>
			</table>
			<!-- End of standard user Table -->
			
			<!-- Start of emergency Contact Table -->
			<table class ="emergencyContact">
				<tr><th><label><b>***Emergency Contact Information***</b></label></th></tr>
				<tr>
					<th><form:label path = "ecFirstName">First Name</form:label></th>
					<th><form:input path = "ecFirstName"></form:input></th>
					
					<th><form:label path = "ecLastName">Last Name</form:label></th>
					<th><form:input path = "ecLastName"></form:input></th>
						
					<th><form:label path = "ecPhoneNumber">Phone Number</form:label></th>
					<th><form:input type ="number" path = "ecPhoneNumber"></form:input></th>
						
					<th><form:label path = "ecEmailAddress">Email Address</form:label></th>
					<th><form:input type="email" path = "ecEmailAddress"></form:input></th>		
			</table>
			<!-- End of Emergency Contact Table -->

			<!-- Start of Admin Specific Table -->
			<table class="administratorInfromation">
				<tr>
					<th><label><b>***ADMINISTRATOR***</b></label></th>
				</tr>
				<tr>
					<th><form:label path="certifications"> Certifications</form:label></th>
					<th><form:input path="certifications"></form:input></th>

					<th><form:label path="degree"> Degree</form:label></th>
					<th><form:input path="degree"></form:input></th>

					<th><form:label path="department">Department</form:label></th>
					<th><form:input path="department"></form:input></th>

					<th><form:label path="specializations">Specializations</form:label></th>
					<th><form:input path="specializations"></form:input></th>

				</tr>
			</table>
			<!-- End of Admin Specific table -->
			<input type="submit">
		</fieldset>
	</form:form>




</body>
</html>