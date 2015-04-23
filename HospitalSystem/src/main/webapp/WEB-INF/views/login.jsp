<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form id = "profile" method="POST" action="/hms/profile">

	<fieldset>
		<legend>Login</legend>
		<div class="table">
		<table>
			<tr><td>E-mail: </td><td><input type="email" id="email" name="email" placeholder = "Email Id" required></td></tr>
			<tr><td>Password: </td><td><input  type="password" id="password" name="password" placeholder = "Password" required></td></tr>
		</table>
			<div class="row">
				<span class="fieldCell"><input class="PrimaryButton"
					type="submit" id="submitButton" value="Login" /></span> <span
					class="fieldCell"> 
					<a href="<c:url value="/signup" />">Create Account</a></span>
			</div>
		</div>
	</fieldset>
</form:form>