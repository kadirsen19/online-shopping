<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container">
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/showAllProducts">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>

		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="card">
				<div class="row">
					<div class="col-sm-7">
						<img id="productDetailImg" src="${images}/${product.code}.jpg"
							alt="Card image cap"> <label class="text-light">Photo</label>
						<label class="text-light date text-center">07 MAR</label>
					</div>
					<div class="col-sm-5">
						<div class="card-block">
							<h4>${product.brand.toUpperCase()}</h4>
							<hr>
							<h4>
								<span class="text-danger">${product.name}</span>
							</h4>
							<hr>
							<p>${product.description}</p>
							<hr>
							<h4>
								<span class="text-danger">Price : ${product.unitPrice}</span>
							</h4>
							<hr>

							<c:choose>
								<c:when test="${product.quantity < 1}">
									<h4>
										<h6>
											Qty.Available: <span style="color:red">&nbsp;Out of Stock</span>
										</h6>
									</h4>
								</c:when>
								<c:otherwise>
									<h4>
										<span class="text-danger">Quantity :
											${product.quantity}</span>
									</h4>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${product.quantity < 1}">
									<a class="btn btn-warning text-light disabled"
										href="javascript.void(0)"><strikethrough>
										<i class="fa fa-shopping-cart" style="font-size: 24px"></i>
										&nbsp; Add To Card</strikethrough>
									</a>
								</c:when>
								<c:otherwise>
									<a class="btn btn-warning text-light"
										href="${pageContext.request.contextPath}/card/add/${product.id}/product">
										<i class="fa fa-shopping-cart" style="font-size: 24px"></i>
										&nbsp; Add To Card
									</a>
								</c:otherwise>

							</c:choose>

							&nbsp; &nbsp; &nbsp; &nbsp; <a class="btn btn-primary text-light"
								href="${pageContext.request.contextPath}/showAllProducts"><i
								class="fa fa-toggle-left" style="font-size: 24px"></i>&nbsp;Back
								To List</a>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
