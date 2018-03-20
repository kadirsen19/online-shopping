
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<!-- Always load the Sidebar on page -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-md-9">

			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
						
						<!-- this is for getting all json type products -->
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>

					</c:if>
					<c:if test="${userClickCatagoryProducts==true}">
						<!-- this is for getting all json type products by ID -->
						<script>
							window.categoryId = '${catagory.id}';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="breadcrumb-item">Category</li>
							<li class="breadcrumb-item">${catagory.name}</li>
						</ol>

					</c:if>
				</div>
			</div>

			<div class="row">

				<div class="col-lg-12">

					<table id="productListTable"
						class="table table-striped table-borderd">

						<thead>

							<tr>
								<th></th>
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>STOCK</th>
								<th>ACTION</th>
							</tr>

						</thead>
						<tfoot>

							<tr>
								<th></th>
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>STOCK</th>
								<th>ACTION</th>
							</tr>

						</tfoot>

					</table>

				</div>

			</div>

		</div>
	</div>


</div>