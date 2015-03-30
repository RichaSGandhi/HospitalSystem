<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">

</head>

<body>

<div class="spacer"></div>
<div id="wrapper">

	<div class="header" style="display:''">
	<h1>User's Account</h1>
	</div>

	<div class="content">
<h2><c:out value="Welcome: ${name}" /></h2>
<table>				
<tr><td><a href="<c:url value="/" />">Home</a> </td></tr>
<tr><td><a href="<c:url value="/user/edit" />">Update My Profile</a> </td></tr>
</table>
     <P>Hi!! This is your home page</P>    
    <div class="content-area">
		<p><c:out value="${name}"/> </p>
	</div>
	
</div>

</div>



</body>
</html>