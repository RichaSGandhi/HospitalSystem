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
					<th><label>Date of Birth:</label></th>
					<th><input style="width: 145px" type="date" id="dob"></th>




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
			<table class ="emergencyContact">
				<tr><th><label><b>***Emergency Contact Information***</b></label></th></tr>
				<tr>
					<th><form:label path = "ecFirstName">First Name</form:label></th>
					<th><form:input path = "ecFirstName"></form:input></th>
					
					<th><form:label path = "ecLastName">Last Name</form:label></th>
					<th><form:input path = "ecLastName"></form:input></th>
						
					<th><form:label path = "ecPhoneNumber">Phone Number</form:label></th>
					<th><form:input path = "ecPhoneNumber"></form:input></th>
						
					<th><form:label path = "ecEmailAddress">Email Address</form:label></th>
					<th><form:input path = "ecEmailAddress"></form:input></th>		
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