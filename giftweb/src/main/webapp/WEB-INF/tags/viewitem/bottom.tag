<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="item" required="true"
	type="com.givemewish.giftweb.model.Item"%>
<%@ attribute name="cart" required="false"
	type="com.givemewish.giftweb.model.ShoppingCart"%>
<div id="itempic">
<img src="${item.imgurl}" width="200" height="200"></img>
</div>
<div id="itemdetails">
<h2>${item.title}</h2>
<h2>Price: ${item.price}</h2>
<button id="addbutton" onclick="javascript:addToCart(${item.id});">ADD TO CART</button>
</div>
