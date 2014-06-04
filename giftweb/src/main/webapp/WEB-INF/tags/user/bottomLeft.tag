<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="user" required="true"
	type="com.givemewish.giftweb.model.User"%>
<%@ attribute name="wlists" required="true" type="java.util.List"%>
<b> Your Wish Lists (${user.name})</b>
<c:set var="uid" value="${user.id}"></c:set>
<ol>
	<c:forEach items="${wlists}" var="element">
		<li>
			<form method="post" action="/giftweb/user/${uid}/delw">
				<a href="/giftweb/user/${uid}/${element.id}">${element.name}</a>
				<button name="wid" type="submit" value="${element.id}">X</button>
			</form> 
		</li>
	</c:forEach>
	<li>
		<form method="post" action="/giftweb/user/${uid}/addw">
			<input name="wname" type="text" size="25"></input> 
			<input type="submit" value="Go" />
		</form>
	</li>
</ol>
