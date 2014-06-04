<%@ taglib tagdir="/WEB-INF/tags/home" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<script type="text/javascript"
	src="/giftweb/resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="/giftweb/resources/js/jquery.jcarousel.js"></script>
<link rel="stylesheet" type="text/css"
	href="/giftweb/resources/css/skin.css" />
<link href="/giftweb/resources/css/layout.css" rel="stylesheet">

<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#mycarousel').jcarousel();
	});
	jQuery(document).ready(function() {
		jQuery('#popularcarousel').jcarousel();
	});
</script>
</head>
<body>
	<div id="container">
		<div id="toppanelhome">
			<h:topPanelHome cartNum="${cartNum}" catList="${catList}" />
		</div>

		<div id="bottompanel">
			<div id="bottomleftpanel">
				<div id="bannerpanelhome">
					<h:bannerPanelHome />
				</div>
				<div id="bottomcats">
					<h:bottomCats childCats="${childCats}" />
				</div>
				<div id="bestsellerCarousel">
					<div id="bestsellerBanner">
					<b> Best Selling </b>
					</div>
					<h:popularCarousel carouselItems="${carouselItems}"></h:popularCarousel>
				</div>
			</div>
			<div id="bottomrightpanel">
				<h:rightRail />
			</div>
		</div>

	</div>
</body>
</html>
