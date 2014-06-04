<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<link href="/giftweb/resources/css/login-layout.css" rel="stylesheet">
</head>
<body>
	<div id="myform">
		<form method="post" action="<c:url value='j_spring_security_check'/>">
			<label><span>username/email id:</span></label> 
			<input type="text" id="j_username" name="j_username"> 
			<label><span>password: </span></label> 
			<input type="text" id="j_password" name="j_password">
			<div id="login-div">
			<input type="submit" value="Login">
			</div>
		</form>
	</div>
</body>
</html>