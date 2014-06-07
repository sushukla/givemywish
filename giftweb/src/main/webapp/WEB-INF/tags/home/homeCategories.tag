<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="catList" required="true" type="java.util.List"%>
<c:forEach items="${catList}" var="element">
	<div id="homecats">
		<div id="catlink">
			<a id="headera" href="/giftweb/list/${element.id}">${element.name}</a>
		</div>
	</div>
</c:forEach>
