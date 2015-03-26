<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Guys!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P> ${welcomeMessage}</P>
<P><a href="<c:url value="/signup" />"> Signup</a><P>
</body>
</html>
