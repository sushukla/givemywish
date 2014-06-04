<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="user" required="true"
	type="com.givemewish.giftweb.model.User"%>
<%@ attribute name="currentList" required="true"
	type="java.lang.Integer"%>
<%@ attribute name="itemList" required="true" type="java.util.List"%>
<%@ attribute name="ulist" required="true" type="com.givemewish.giftweb.model.UserWishList"%>
<%@ attribute name="totals" required="true" type="com.givemewish.giftweb.model.UserWishListTotals"%>

  <script>
  $(function() {
    $( ".slider-range-min" ).slider({
      range: "min",
      value: $( "#contrib2" ).val(),
      min: 0,
      slide: function( event, ui ) {
    	  var id = $(this).attr("id");
    	  $( "#contrib"+id ).val( ui.value );
    	  $( "#"+id ).slider("option","max", $( "#itmprice"+id ).text());
      }
    });
  });
  
  function popup()
  {
    var generator=window.open('','name','height=400,width=500');

    generator.document.write('<html><head><title>Popup</title>');
    //generator.document.write($("#test").html());
    generator.document.write('</body></html>');
    generator.document.close();
  }
  </script>
<div id="viewlist">
	<div> 
		<div class="ptext"><b>${ulist.name}</b></div>
		<div class="ptext"><br/>${ulist.description}<br/></div>
		<div style="float: right;">
		<button class="ptext" name="addprod" type="submit" value="go" onclick="javascript:popup();">Add Product</button>
		<button class="ptext" name="bnow" type="submit" value="go">Buy Now</button>
		<button class="ptext" name="invite" type="submit" value="go">Invite</button>
		</div>
	</div>
	<table id="prodtable">
		<thead>
			<tr>
				<th><div style="width: 5%">Select</div></th>
				<th><div style="width: 10%">Item Id</div></th>
				<th><div style="width: 20%">Name</div></th>
				<th><div style="width: 10%">Qty</div></th>
				<th><div style="width: 10%">Price</div></th>
				<th nowrap><div style="width: 30%">My Amount</div></th>
				<th><div style="width: 15%">ShortFall</div></th>
			</tr>
		</thead>
		<c:forEach items="${itemList}" var="element">
			<tr>
				<td><input type="checkbox"></input></td>
				<td><img src="${element.imgurl}" alt="Smiley face" width="80" height="80"></img></td>
				<td>${element.title}</td>
				<td>1</td>
				<td><span id="itmprice${element.id}">${element.price}</span></td>
				<td class="ptcell">
				<form method="post" action="/giftweb/user/${user.id}/${currentList}/${element.id}">
				<input id="contrib${element.id}" name="contrib" type="text" style="float: left; 
					display: inline; width: 5em" value="${element.contrib}"/>
				</form>
				<div id="${element.id}" class="slider-range-min" style="width: 8em; float: right; margin: auto;"></div>
				</td>
				<td>${element.shortfall}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><b>Total</b></td>
			<td></td>
			<td>1</td>
			<td></td>
			<td>${totals.totalPrice}</td>
			<td>${totals.totalContrib}</td>
			<td>${totals.totalShortfall}</td>
			
		</tr>
	</table>
</div>

