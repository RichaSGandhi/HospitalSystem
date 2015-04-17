<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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

							<form id="myForm" method="post"
							class="bs-example form-horizontal">
							<fieldset>
								<legend>Update Profile Form</legend>
								<table >
								<tr>
									<th><label>UserName:</label></th>
									<th><input type="text"
											id="userName" value = "${user.userName}" disabled></th>
									<th><label>Role:</label></th>	
									<th><input type="text"
											id="role" value = "${user.role}" disabled></th>
									<th><label>Name:</label></th>	
									<th><input type="text"
											id="name" value = "${user.name}" disabled></th>
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
											<th><label>Mobile Number:</label></th>
									<th><input type="email"
											id="secondEmail" value = "${user.secondaryEmail}"></th>
								</tr>
																<tr>
									<th><label>Street Address:</label></th>
									<th><input type="text"
											id="streetAdd" value = "${user.mailingAddress.street}" required></th>
									<th><label>City:</label></th>
									<th><input type="text"
											id="city" value = "${user.mailingAddress.city}" required></th>			
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
											id="zip" value = "${user.mailingAddress.zip}" required></th>
								</tr>
								
								</table>
								<table class="insuranceInformation">
									<tr>
										<th><label><b>***INSURANCE DETAILS***</b></label></th>
									</tr>
									<tr>
										<th><label>Insurance Provider</label></th>
										<th><input type ="text" id = "insuranceProvider" value = "${user.mailingAddress.zip}">
										
										<th><label>Insurance ID:</label></th>
										<th><input type="text"id="insuranceID" value = "${user.mailingAddress.state}"></th>
										
									</tr>
									<tr>
										<th><label>Start Date:</label></th>
										<th><input style= "width:145px" type= "date" id="startDate" value = "${user.mailingAddress.street}"></th>
											<th><label>End Date:</label></th>
										<th><input style="width:145px" type="date" id="endDate" value = "${user.mailingAddress.city}" ></th>
							
									</tr>
								</table>
								
								<table class = "providerInformation">
									<tr>
										<th><label><b>***PROVIDER DETAILS***</b></label></th>
									</tr>
										<tr>
											<th><label>Affiliation</label></th>
											<th><input type="text" id="affiliation" value = "${user.mailingAddress.state}"></th>
										
											<th><label>Available Days</label></th>
											<th><input type="text" id = "availableDays" value = "${user.mailingAddress.state}"></th>
										
											<th><label>Certification</label></th>
											<th><input type="text" id = "certifcation" value = "${user.mailingAddress.state}"></th>
										</tr>
										<tr>
											<th><label>Degree</label></th>
											<th><input type ="text" id="degree" value = "${user.mailingAddress.state }"></th>
										
											<th><label>Department</label></th>
											<th><input type="text" id = "department" value = "${user.mailingAddress.state }"></th>
										
											<th><label>Experience</label></th>
											<th><input type="text" id = "experience" value = "${user.mailingAddress.state }"></th>
										</tr>
										<tr>
											<th><label>Specialization]</label></th>
											<th><input type="text" id = "specialization" value = "${user.mailingAddress.state }"></th>
										</tr>
									</table>
								
								
								
									<table class = "administratorInfromation">
										<tr>
											<th><label><b>***ADMINISTRATOR DETAILS***</b></label></th>
										</tr>
										<tr>
											<th><label>Certifications</label></th>
											<th><input type="text" id = "certifications" value = "${user.mailingAddress.state }"></th>
												
											<th><label>Degree</label></th>
											<th><input type="text" id = "degree" value = "${user.mailingAddress.state }"></th>
											
											<th><label>Job Title</label></th>
											<th><input type="text" id = "jobTitle" value = "${user.mailingAddress.state }"></th>
										</tr>
										<tr>		
											<th><label>Specializations</label></th>
											<th><input type="text" id = "specializations" value = "${user.mailingAddress.state }"></th>
												
										</tr>
									</table>	
								<input type="submit">
							</fieldset>
						</form>




</body>
</html>