<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC >
<html>
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

	<form:form method="post" action="processUpdatePatientProfile"
		commandName="patient" class="bs-example form-horizontal">
		<form:errors path="*" element="div" cssClass="commonerrorblock" />
		<fieldset>
			<legend>Update Profile Form</legend>

			<!-- Start of standard user profile Table -->
			<table>

				<!-- The first row [username name middleName lastname]  -->
				<tr>


					<th><form:label path="username">UserName:</form:label></th>
					<th><form:input path="username" readonly="true"></form:input></th>
					<th><form:label path="Name">Name:</form:label></th>
					<th><form:input path="Name"></form:input></th>
					<th><form:label path="middleName">Middle Name</form:label></th>
					<th><form:input path="middleName"></form:input></th>
					<th><form:label path="lastName">Last Name</form:label></th>
					<th><form:input path="lastName"></form:input></th>


				</tr>
				<tr>
					<!-- SecondRow [sex maritalstatus role mobilephone] -->
					<th><form:label path="sex">Sex:</form:label></th>
					<th><form:select path="sex">
							<form:option value="male" label="Male" />
							<form:option value="female" label="Female" />
						</form:select></th>
					<th><form:label path="maritialStatus">Maritial Status:</form:label></th>
					<th><form:input path="maritialStatus"></form:input></th>
					<th><label>Role:</label></th>
					<th><form:input path="jobTitle" readonly="true"></form:input></th>
					<th><form:label path = "dateOfBirth">Date of Birth:</form:label></th>
					<th><form:input path = "dateOfBirth" style="width: 145px" type="date" id="dob"></form:input></th>




				</tr>
				<tr>
					<!-- Thirdrow [moblePhone primaryPhone secondaryPhone SecondaryEmail -->
					<th><form:label path="mobilePhoneNumber">Mobile Number:</form:label></th>
					<th><form:input path="mobilePhoneNumber"></form:input></th>
					<th><form:label path="primaryPhone">Phone Number:</form:label></th>
					<th><form:input path="primaryPhone"></form:input></th>
					<th><form:label path="secondaryPhone">Secondary Phone Number:</form:label></th>
					<th><form:input path="secondaryPhone"></form:input></th>
					<th><form:label path="secondaryEmail">secondaryEmail:</form:label></th>
					<th><form:input path="secondaryEmail"></form:input></th>
				</tr>
				<tr>
					<th><form:label path="userAddress.street">Street Address:</form:label></th>
					<th><form:input path="userAddress.street"></form:input></th>
					<th><form:label path="userAddress.city">City:</form:label></th>
					<th><form:input path="userAddress.city"></form:input></th>
					<th><label>State:</label></th>
					<th><form:select path="userAddress.state">
							<option value=""></option>
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="FL">Flordia</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Neveda</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virgina</option>
							<option value="WA">Washinton</option>
							<option value="WV">West Virgina</option>
							<option value="WI">Wisconson</option>
							<option value="WY">Wyoming</option>

						</form:select></th>
					<th><form:label path="userAddress.zipCode">ZIPCODE:</form:label></th>
					<th><form:input path="userAddress.zipCode"></form:input></th>
				</tr>
			</table>
			<!-- End of standard user Table -->

			<!-- Start of emergency Contact Table -->
			<table class="emergencyContact">
				<tr>
					<th><label><b>***Emergency Contact Information***</b></label></th>
				</tr>
				<tr>
					<th><form:label path="ecFirstName">First Name</form:label></th>
					<th><form:input path="ecFirstName"></form:input></th>

					<th><form:label path="ecLastName">Last Name</form:label></th>
					<th><form:input path="ecLastName"></form:input></th>

					<th><form:label path="ecPhoneNumber">Phone Number</form:label></th>
					<th><form:input path="ecPhoneNumber"></form:input></th>

					<th><form:label path="ecEmailAddress">Email Address</form:label></th>
					<th><form:input path="ecEmailAddress"></form:input></th>
			</table>
			<!-- End of Emergency Contact Table -->

			<!-- Start of Patient Specific table -->
			<table class="insuranceInformation">
				<tr>
					<th><label><b>***INSURANCE***</b></label></th>
				</tr>
				<tr>
					<th><form:label path="patientInsurance.provider">Insurance Provider</form:label></th>
					<th><form:input path="patientInsurance.provider"></form:input></th>
					<th><form:label path="patientInsurance.insuranceID">Insurance ID:</form:label></th>
					<th><form:input path="patientInsurance.insuranceID"></form:input></th>
					<th><label>Start Date:</label></th>
					<th><input style="width: 145px" type="date" id="startDate"
						value="${patient.getInsuranceStartDate()}"></th>
					<th><label>End Date:</label></th>
					<th><input style="width: 145px" type="date" id="endDate"
						value="${patient.getInsuranceEndDate()}"></th>

				</tr>
			</table>
			<!-- End of Patient Specific Table -->
			<input type="submit">
		</fieldset>
	</form:form>




</body>
</html>