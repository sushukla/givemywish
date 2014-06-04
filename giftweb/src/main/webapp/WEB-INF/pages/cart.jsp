<%@ taglib tagdir="/WEB-INF/tags/cart" prefix="ca"%>
<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<link href="/giftweb/resources/css/layout.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<div id="toppanel">
		<h:topPanelHome></h:topPanelHome>
		</div>
		<div id="bottompanel">
		<ca:cartview cart="${cart}"></ca:cartview>
		</div>
	</div>
</body>
</html>
