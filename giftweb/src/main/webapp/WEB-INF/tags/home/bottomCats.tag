<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="childCats" required="true" type="java.util.List"%>
<%@ attribute name="uid" required="false" type="java.lang.String"%>
<div>
<ul id="mycarouselul" class="jcarousel-skin-tango">
	<c:forEach items="${childCats}" var="element">
		<li>
			<img src="${element.catimg}" alt="Smiley face" width="100"
				height="100"></img> <br />
			<a href="">${element.name}</a>

		</li>
	</c:forEach>
</ul>
</div>
