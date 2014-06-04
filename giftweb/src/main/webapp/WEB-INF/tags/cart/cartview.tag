<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="cart" required="true"
	type="com.givemewish.giftweb.model.ShoppingCart"%>
<div id="carttop">
	<span id="cartlabel">Your Shopping Cart</span>
</div>
<div id="cart">
	<c:forEach var="entry" items="${cart.cartItems}">
		<div id="cartitemimg">
			<img src="${entry.key.imgurl}" alt="Smiley face" width="100"
				height="100"></img>
		</div>
		<div id="cartitemdesc">
		<form method="post" action="/giftweb/updatecart/${entry.key.id}">
			<span id="cartlabel"><c:out value="${entry.key.title}" /></span> <br />
			Price:
			<c:out value="${entry.key.price}" />
			<br /> Quantity:
			<input id="cqty" name="cqty" type="text" value="${entry.value}" size="5em"></input>
			<br/>
		</form>	
			<!-- <a href="">Remove</a> -->
		</div>
	</c:forEach>
</div>
<div id="cartsummary">
<div><p id="tmargin"><span id="cartlabel">Cart Summary</span></p></div>
<div><p id="tmargin"> Total: <c:out value="${cart.cartTotal}" /></p></div>
<div><p id="tmargin"> <button id="addbutton" onclick="javascript;">CHECKOUT</button></p></div>
</div>