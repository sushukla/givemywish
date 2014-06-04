<%@ taglib tagdir="/WEB-INF/tags/viewitem" prefix="v"%>
<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<link href="/giftweb/resources/css/layout.css" rel="stylesheet">
<script src="/giftweb/resources/js/viewitem.js"></script>
</head>
<body>
	<div id="container">
		<div id="toppanel">
		<h:topPanelHome></h:topPanelHome>
		</div>
		<div id="bottompanel">
		<v:bottom item="${item}"></v:bottom>
		</div>
	</div>
</body>
</html>
