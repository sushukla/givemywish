<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>

<%@ attribute name="cartNum" required="false" type="java.lang.Integer"%>
<%@ attribute name="uid" required="false" type="java.lang.String"%>
<%@ attribute name="catList" required="false" type="java.util.List"%>

<div id="hdleft">
	<a href="/giftweb/home"><img src="/giftweb/resources/img/logo.jpg"></a>
</div>

<div id="hdright">
	<div id="rhlinks">
		<div id="signindiv">
			<a href="/giftweb/user/${uid}">
			<img height="40" width="40" src="/giftweb/resources/img/user.jpg" >
			</a>
		</div>
		<div id="cartdiv">
			${cartNum} <a href="/giftweb/home"><img height="40" width="40"
				src="/giftweb/resources/img/cart.png"></a>
		</div>
		<div id="wlistdiv">Wish<br/>List</div>
	</div>
</div>

<div id="srchhdright">
	<form id="srchform" action="post">
		<input id="srchbox" type="text" value="search your wish">
	</form>
</div>
<div id="hdbottom">
	<h:homeCategories catList="${catList}"></h:homeCategories>
</div>


