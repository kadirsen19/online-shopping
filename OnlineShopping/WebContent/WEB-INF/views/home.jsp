<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">

		<div class="col-lg-3">

			<%@ include file="./shared/sidebar.jsp" %>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item">
						<img class="d-block img-fluid" src="${images}/rsz_adv6.jpg"
							alt="Third slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid" src="${images}/rsz_adv5.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item active">
						<img class="d-block img-fluid" src="${images}/rsz_adv3.jpg"
							alt="First slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="row">
   				<c:forEach items="${product}" var="allProductlist">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="${pageContext.request.contextPath}/show/${allProductlist.id}/product">
							<img src="${images}/${allProductlist.code}.jpg" 
											 alt="${allProductlist.name}"
											class="img-responsive cartImg" /></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="${pageContext.request.contextPath}/show/${allProductlist.id}/product">${allProductlist.name}</a>
								</h4>
								<h5>${allProductlist.unitPrice}</h5>
								<p class="card-text">${allProductlist.description}</p>
							</div>
							<div class="text-right">
								<a type="button" href="${pageContext.request.contextPath}/show/${allProductlist.id}/product" 
									class="btn btn-info">View</a>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
									&#9734;</small>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->