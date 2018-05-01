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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<nav class="navbar navbar-expand-lg navbar-primary bg-light fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/home">Online Shopping</a>
				</div>
			</div>
		</nav>
		<!-- /Navigation -->
		<!-- Login Page  -->
		<div class="content">
		<!-- this will be display username and password are wrong -->
			<c:if test="${not empty message}">
				<div class="text-right">
					<div class="col-md-12 mx-auto">
						<div class="alert alert-danger">${message}</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty logout}">
				<div class="text-right">
					<div class="col-md-12 mx-auto">
						<div class="alert alert-success">${logout}</div>
					</div>
				</div>
			</c:if>
			<div class="container py-5">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6 mx-auto">
								<!-- form card login -->
								<div class="card rounded-0">
									<div class="card-header">
										<h3 class="mb-0">Login</h3>
									</div>
									<div class="card-body">
										<form action="${pageContext.request.contextPath}/login"
											id="loginForm" method="POST">
											<div class="form-group">
												<label for="uname1">Username</label> <input type="text"
													placeholder="ex:@gmail.com"
													class="form-control form-control-lg rounded-0"
													name="username">

											</div>
											<div class="form-group">
												<label>Password</label> <input type="password"
													class="form-control form-control-lg rounded-0"
													name="password">

											</div>
											<div>
												<label class="custom-control custom-checkbox"> <input
													type="checkbox" class="custom-control-input"> <span
													class="custom-control-indicator"></span> <span
													class="custom-control-description small text-dark">Remember
														me on this computer</span>
												</label>
											</div>
											<div>
												<button type="submit"
													class="btn btn-success btn-lg float-right" id="btnLogin">Login</button>
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}">

											</div>
										</form>
									</div>
									<!--/card-block-->
								</div>
								<!-- /form card login -->
							</div>
						</div>
						<!--/row-->
					</div>
					<!--/col-->
				</div>
				<!--/row-->
			</div>
		</div>
		<!-- Login Page  -->
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /Footer -->

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<!-- Jquery Validator -->
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/additional-methods.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
