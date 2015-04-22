<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	 <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script>
	$( document ).ready(function() {
		var role = '${user.getJobTitle()}';
		if(role==("Doctor")||role==("Nurse")){
			$("#providerInformation").show();
			
		}else if(role==("Patient")){
			$("#insuranceInformation").show();
		}else if(role==("Admin")){
			$("#administratorInfromation").show();
		}
	
	});
	</script>
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
			<h2>Hi  ${user.getName()} !! Please Update your Profile</h2>
							<form id="myForm" method="post"
							class="bs-example form-horizontal">
							<fieldset>
								<legend>Update Profile Form</legend>
								<table >
								<tr>
									<th><label>UserName:</label></th>
									<th><input type="text"
											id="userName" value="${user.getPrimaryEmail()}" disabled></th>
									<th><label>Role:</label></th>	
									<th><input type="text"
											id="role" value = "${user.getJobTitle()}" disabled></th>
									<th><label>Name:</label></th>	
									<th><input type="text"
											id="name" value = "${user.getName()}" disabled></th>
								</tr>
								<tr>
									<th><label>Date of Birth:</label></th>
									<th><input style = "width:145px" type = "date" id="dob" value = "${user.dateOfBirth}"required></th>
									<th><label>Sex:</label></th>
									<th><select id="sex" required style="width:150px">
									 <option value="male">Male</option>
 									 <option value="female">Female</option>
 									 </select></th>
 									 <th><label>Marital Status:</label></th>
 									 <th><input type="text"
											id="name" value = "${user.maritialStatus}"></th>
								</tr>
								<tr>
									<th><label>Phone Number:</label></th>
									<th><input type="tel"
											id="phoneNumber" value = "${user.primaryPhone}" required></th>
									<th><label>Mobile Number:</label></th>
									<th><input type="tel"
											id="secondNumber" value = "${user.secondaryPhone}"></th>
											<th><label>Secondary Email:</label></th>
									<th><input type="email"
											id="secondEmail" value = "${user.secondaryEmail}"></th>
								</tr>
																<tr>
									<th><label>Street Address:</label></th>
									<th><input type="text"
											id="streetAdd" value = "${user.userAddress}" required></th>
									<th><label>City:</label></th>
									<th><input type="text"
											id="city" value = "${user.userAddress}" required></th>			
								<th><label>State:</label></th>
									<th><select  id="state" required style="width:150px">
											<option value = "AL">Alabama</option>
											<option value = "AK">Alaska</option>
											<option value = "AZ">Arizona</option>
											<option value = "AR">Arkansas</option>
											<option value = "CA">California</option>
											<option value = "CO">Colorado</option>
											<option value = "CT">Connecticut</option>
											<option value = "DE">Delaware</option>
											<option value = "FL">Flordia</option>
											<option value = "GA">Georgia</option>
											<option value = "HI">Hawaii</option>
											<option value = "ID">Idaho</option>
											<option value = "IN">Indiana</option>
											<option value = "IA">Iowa</option>
											<option value = "KS">Kansas</option>
											<option value = "KY">Kentucky</option>
											<option value = "LA">Louisiana</option>
											<option value = "ME">Maine</option>
											<option value = "MD">Maryland</option>
											<option value = "MA">Massachusetts</option>
											<option value = "MI">Michigan</option>
											<option value = "MN">Minnesota</option>
											<option value = "MS">Mississippi</option>
											<option value = "MO">Missouri</option>
											<option value = "MT">Montana</option>
											<option value = "NE">Nebraska</option>
											<option value = "NV">Neveda</option>
											<option value = "NH">New Hampshire</option>
											<option value = "NJ">New Jersey</option>
											<option value = "NM">New Mexico</option>
											<option value = "NY">New York</option>
											<option value = "NC">North Carolina</option>
											<option value = "ND">North Dakota</option>
											<option value = "OH">Ohio</option>
											<option value = "OK">Oklahoma</option>
											<option value = "OR">Oregon</option>
											<option value = "PA">Pennsylvania</option>
											<option value = "RI">Rhode Island</option>
											<option value = "SC">South Carolina</option>
											<option value = "SD">South Dakota</option>
											<option value = "TN">Tennessee</option>
											<option value = "TX">Texas</option>
											<option value = "UT">Utah</option>
											<option value = "VT">Vermont</option>
											<option value = "VA">Virgina</option>
											<option value = "WA">Washinton</option>
											<option value = "WV">West Virgina</option>
											<option value = "WI">Wisconson</option>
											<option value = "WY">Wyoming</option>
											
										</select>
									
									
									</th>
								
								</tr>
								<tr>
								<th/>
								<th/>
								<th/>
								<th/>
								<th><label>ZIPCODE:</label></th>
									<th><input type="number"
											id="zip" value = "${user.userAddress}" required></th>
								</tr>
								
								</table>
								
								<table id = "insuranceInformation" class="insuranceInformation" hidden=true>
									<tr>
										<th><label><b>***INSURANCE DETAILS***</b></label></th>
									</tr>
									<tr>
										<th><label>Insurance Provider</label></th>
										<th><input type ="text" id = "insuranceProvider" value = "${patient.insurance.provider}">
										
										<th><label>Insurance ID:</label></th>
										<th><input type="text"id="insuranceID" value = "${patient.insurance.insuranceID}"></th>
										
									</tr>
									<tr>
										<th><label>Start Date:</label></th>
										<th><input style= "width:145px" type= "date" id="startDate" value = "${user.userAddress}"></th>
											<th><label>End Date:</label></th>
										<th><input style="width:145px" type="date" id="endDate" value = "${user.userAddress}" ></th>
							
									</tr>
								</table>
								
								<table id = "providerInformation" class = "providerInformation" hidden=true>
									<tr>
										<th><label><b>***PROVIDER DETAILS***</b></label></th>
									</tr>
										<tr>
											<th><label>Affiliation</label></th>
											<th><input type="text" id="affiliation" value = "${provider.affiliation}"></th>
										
											<th><label>Available Days</label></th>
											<th><input type="text" id = "availableDays" value = "${provider.availableDays}"></th>
										
											<th><label>Certification</label></th>
											<th><input type="text" id = "certifcation" value = "${provider.certification}"></th>
										</tr>
										<tr>
											<th><label>Degree</label></th>
											<th><input type ="text" id="degree" value = "${provider.degree }"></th>
										
											<th><label>Department</label></th>
											<th><input type="text" id = "department" value = "${provider.department }"></th>
										
											<th><label>Experience</label></th>
											<th><input type="text" id = "experience" value = "${provider.experience }}"></th>
										</tr>
										<tr>
											<th><label>Specialization</label></th>
											<th><input type="text" id = "specialization" value = "${provider.experience }"></th>
										</tr>
									</table>
								
								
								
									<table id = "administratorInfromation" class = "administratorInfromation" hidden=true>
										<tr>
											<th><label><b>***ADMINISTRATOR DETAILS***</b></label></th>
										</tr>
										<tr>
											<th><label>Certifications</label></th>
											<th><input type="text" id = "certifications" value = "${adminstrator.certifications }"></th>
												
											<th><label>Degree</label></th>
											<th><input type="text" id = "degree" value = "${administratior.degree }"></th>
											<th><label>Specializations</label></th>
											<th><input type="text" id = "specializations" value = "${administrator.specializations }"></th>
										
										</tr>
										
									</table>	
								<input type="submit">
							</fieldset>
						</form>




</body>
</html>