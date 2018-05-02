<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-primary bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li id="home"><a class="nav-link"
					href="${pageContext.request.contextPath}/home">Home <span
						class="sr-only">(current)</span>
				</a></li>
				<li id="about"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">About</a></li>
				<li id="listProducts"><a class="nav-link"
					href="${pageContext.request.contextPath}/showAllProducts">Product</a>
				</li>
				<li id="contact"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Contact</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProducts"><a class="nav-link"
						href="${pageContext.request.contextPath}/manage/manageProduct">Product
							Manage</a>
					</li>
				</security:authorize>
			</ul>
			<!-- Spring webFlow navbar -->
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="register"><a class="nav-link"
						href="${pageContext.request.contextPath}/register">Sign Up</a>
					</li>
					<li id="login"><a class="nav-link"
						href="${pageContext.request.contextPath}/login">Login</a>
					</li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown">
						<a href="javascript:void(0)" class="btn btn-default dropdown-toggle" id="dropdownMenu1"
							data-toggle="dropdown"> ${userModel.fullName}<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">
								<li><a href="${pageContext.request.contextPath}/cart/show"> 
									<span><i class="fa fa-shopping-basket" style="font-size: 24px"></i>&nbsp;&nbsp;</span> 
									<span class="badge">${userModel.cart.cartLines}</span> ${userModel.cart.grandTotal} TL
									</a>
								</li>
								<li class="divider" role="separator"></li>
							</security:authorize>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
								</li>
							</ul>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
	window.userRole='${userModel.role}';
</script>


