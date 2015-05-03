<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>HospitalManagementSystem</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="css/style.css" />">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div>
				<h1>HOSPITAL MANAGEMENT SYSTEM GROUP 7</h1>
			</div>
			<div style="float: right; margin: 20px;">
				<c:if test="${user==null}">
					<a style="color: black" href="<c:url value="/signup" />">Create
						Profile</a> |
					<a style="color: black" href="<c:url value="/login" />">Login</a>
				</c:if>
				<c:if test="${user!=null}">

					<a style="color: black" href="<c:url value="/updateProfile?email=${user.getPrimaryEmail()}" />">${user.getName()}

						</a> |

					<a style="color: black" href="<c:url value="/logout" />">Logout</a>
				</c:if>
			</div>
		</div>
		<div id="content">
			<div id="contentBody">
				<c:if test="${ErrorMsg.length()>0}">
					<span class="error"><c:out value="${ErrorMsg}" /></span>
				</c:if>
				<jsp:include page="${viewName}.jsp" />
			</div>
		</div>
		
		<div id="footer">&copy; Group-7 @2015 - All Rights Reserved
		<div style="float: right; margin: 20px;">
			
		</div>
		</div>
		
			
	</div>
</body>
</html>
