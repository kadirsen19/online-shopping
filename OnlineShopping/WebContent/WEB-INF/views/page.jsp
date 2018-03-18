<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css/" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${pageContext.request.contextPath}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap superHero Theme CSS -->
<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable  CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>
		<!-- /Navigation -->

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome==true }">
				<%@ include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout==true }">
				<%@ include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true }">
				<%@ include file="contact.jsp"%>
			</c:if>
			<c:if test="${userClickAllProducts==true or userClickCatagoryProducts==true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>

			<!-- /Page Content -->
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /Footer -->

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<!-- DataTable Pluing -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>
	</div>
</body>

</html>
