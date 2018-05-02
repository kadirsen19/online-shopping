<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css/" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content ="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${pageContext.request.contextPath}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap superHero Theme CSS -->
<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap DataTable  CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
<!-- manageProduct -->
<link href="${css}/manageProduct.css" rel="stylesheet">
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
			<c:if
				test="${userClickAllProducts==true or userClickCatagoryProducts==true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>
			<c:if
				test="${userClickShowProduct==true}">
				<%@ include file="productDetail.jsp"%>
			</c:if>
			<c:if
				test="${userClickManageProduct==true}">
				<%@ include file="manageProducts.jsp"%>
			</c:if>
			
			<c:if
				test="${userClickShowCart==true}">
				<%@ include file="cart.jsp"%>
			</c:if>

			<!-- /Page Content -->
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /Footer -->

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<!-- Jquery Validator -->
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/additional-methods.js"></script>
		<!-- DataTable Pluing -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>
		<!-- Dialog Allert Bootbox js-->
		<script src="${js}/bootbox.min.js"></script>
	</div>
</body>

</html>
