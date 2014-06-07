<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<script type="text/javascript">
function showWishDiv() {
	   document.getElementById('bannerhdright').style.display = "block";
	   document.getElementById('bannerhdrightinvite').style.display = "none";
	   document.getElementById('bannerhdrightpayments').style.display = "none";
}
function showInviteDiv() {
   document.getElementById('bannerhdrightinvite').style.display = "block";
   document.getElementById('bannerhdright').style.display = "none";
   document.getElementById('bannerhdrightpayments').style.display = "none";
}
function showPaymentsDiv() {
	   document.getElementById('bannerhdrightpayments').style.display = "block";
	   document.getElementById('bannerhdright').style.display = "none";
	   document.getElementById('bannerhdrightinvite').style.display = "none";
}
</script>

<div id="bannerhdleft">
	<a id="bannera" href="#" onclick="javascript:showWishDiv();">
		<div id="bannerop">
			Create <br /> <span id="bannerbottomfont"> Wishlist </span>
		</div>
	</a> <a id="bannera" href="#" onclick="javascript:showInviteDiv();">
		<div id="bannerop">
			Send <br /> <span id="bannerbottomfont"> Invite </span>
		</div>
	</a> <a id="bannera" href="#" onclick="javascript:showPaymentsDiv();">
		<div id="bannerop">
			Receive <br /> <span id="bannerbottomfont"> Payments </span>
		</div>
	</a>
</div>
<div id="bannerhdright">
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-wish.png">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-wish.png">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-wish.png">
	</div>
</div>
<div id="bannerhdrightinvite" style="display:none;">
	<div id="bannertile"> 
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid.jpg">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid-2.jpg">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid-3.jpg">
	</div>
</div>
<div id="bannerhdrightpayments" style="display:none;">
	<div id="bannertile"> 
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid.jpg">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid-2.jpg">
	</div>
	<div id="bannertile">
		<img id="bannerimg" src="/giftweb/resources/img/banner/banner-paid-3.jpg">
	</div>
</div>

