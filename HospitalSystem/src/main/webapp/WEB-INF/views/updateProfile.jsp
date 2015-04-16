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
								<table class="tableMax">
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
									<th><input style = "width:165px" type = "date" id="dob" value = "${user.dateOfBirth}"required></th>
									<th><label>Sex:</label></th>
									<th><select id="sex" placeholder = "Sex" required style="width:170px">
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
								<th><label><b>***MAILING ADDRESS***</b></label></th>
								<th/>
									<th><label>Street Address:</label></th>
									<th><input type="text"
											id="streetAdd" value = "${user.mailingAddress.street}" required></th>
									<th><label>City:</label></th>
									<th><input type="text"
											id="city" value = "${user.mailingAddress.street}" required></th>
									
											
								</tr>
								<tr>
								<th/>
								<th/>
								<th><label>State:</label></th>
									<th><input type="text"
											id="state" value = "${user.mailingAddress.state}" required></th>
								<th><label>State:</label></th>
									<th><input type="number"
											id="zip" value = "${user.mailingAddress.zip}" required></th>
								</tr>
									<tr>
								<th><label><b>***INSURANCE DETAILS***</b></label></th>
								<th/>
									<th><label>Street Address:</label></th>
									<th><input type="text"
											id="streetAdd" value = "${user.mailingAddress.street}" required></th>
									<th><label>City:</label></th>
									<th><input type="text"
											id="city" value = "${user.mailingAddress.street}" required></th>
									
											
								</tr>
								<tr>
								<th/>
								<th/>
								<th><label>State:</label></th>
									<th><input type="text"
											id="state" value = "${user.mailingAddress.state}" required></th>
								<th><label>State:</label></th>
									<th><input type="number"
											id="zip" value = "${user.mailingAddress.zip}" required></th>
								</tr>
							</table>
								
							<input type="submit">

							</fieldset>
						</form>




</body>
</html>