<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
  prefix="c" %>
<%@ attribute name="itemList" required="true" type="java.util.List"%>
  	<div id="blocks">
<c:forEach items="${itemList}" var="element">    
    <div style="height: 150px; background-color: lightgray;">${element.title}<br/>
    <img src="/giftweb/resources/img/phonepart.jpg" alt="Smiley face" width="80" height="80">
    <br/>${element.price}</div>
</c:forEach>
    </div>
