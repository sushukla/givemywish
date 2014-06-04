<%@ taglib tagdir="/WEB-INF/tags/user" prefix="u"%>
<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<script src="/giftweb/resources/js/jquery-1.10.2.js"></script>
<script src="/giftweb/resources/js/jquery-ui-1.10.4.custom.js"></script>
<link href="/giftweb/resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css" />
<link href="/giftweb/resources/css/user-layout.css" rel="stylesheet">

</head>
<body>
	<div id="container">
		<div id="toppanel">
			<h:topPanelHome />		
		</div>
		<div id="bottompanel">
			<div id="bottomleftpanel">
				<u:bottomLeft user="${user}" wlists="${wlists}"/>				
			</div>
			<div id="bottomcenterpanel">
				<u:bottomCenter 
				user="${user}" 
				currentList="${currentList}" 
				itemList="${itemList}" 
				ulist="${ulist}"
				totals="${totals}">
				</u:bottomCenter>
			</div>			
 			<div id="bottomrightpanel">
				<div>text</div>
			</div> 
		</div>
		<div id="footer">
		Footer Test<br/>Prod
		</div>
	</div>
</body>
</html>
