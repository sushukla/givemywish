<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="carouselItems" required="true" type="java.util.List"%>
<%@ attribute name="uid" required="false" type="java.lang.String"%>
<div>
<ul id="popularcarousel" class="jcarousel-skin-tango">
	<c:forEach items="${carouselItems}" var="element">
		<li>
			<img src="${element.imgurl}" alt="Smiley face" width="100"
				height="100"></img> <br />
			<a href="/giftweb/item/${element.id}">${element.title}</a>
			<br />Price:${element.price}
			<c:if test="${not empty uid && uid != 'anonymousUser'}">
			<br/><a href="/giftweb/user/${uid}/1/${element.id}">Add to Wishlist</a>
			</c:if>
		</li>
	</c:forEach>
</ul>
</div>
