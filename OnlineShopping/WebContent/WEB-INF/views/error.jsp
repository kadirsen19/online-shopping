<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css/" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Online Shopping-${title}</title>



<link rel="stylesheet" href="${css}/error_style.css">


</head>

<body>

	<div id="clouds">
		<div class="cloud x1"></div>
		<div class="cloud x1_5"></div>
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
	</div>
	<div class='c'>
		<div class='_404'>404</div>
		<hr>
		<c:if test="${productNotFountException==true }">
			<div class='_1'>PRODUCT</div>
			<div class='_2'>WAS NOT FOUND</div>
		</c:if>
		<c:if test="${globalException==true }">
			<div class='_1' style=>THE PAGE</div>
			<div class='_2'>WAS NOT FOUND</div>
		</c:if>
		<c:if test="${productNotFountGeneralException== true }">
			<div class='_1' style=>Contact</div>
			<div class='_2'>with the site administrator</div>
		</c:if>
		<a class='btn btn-primary'
			href="${pageContext.request.contextPath}/home">BACK TO HOME</a>
	</div>

</body>

</html>
