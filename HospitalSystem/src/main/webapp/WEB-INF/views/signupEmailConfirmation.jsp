<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>New User</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">

</head>

<body>

<div class="spacer"></div>
<div id="wrapper">

	<div class="header" style="display:''">

	</div>

	<div class="content">
        
    	<div class="content-area">


<h2><c:out value="Congratulations , ${name} !!"/>
<P> YOUR ACCOUNT CREATED, EMAIL CONFIRMATION SENT TO YOUR MAIL ID, PLEASE ACTIVATE YOUR ACCOUNT!!</P> </h2>




</div>

</div>

</div>



</body>
</html>
