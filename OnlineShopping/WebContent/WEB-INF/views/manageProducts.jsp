<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty message}">
	<div class="col-xs-12">
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${message}
		</div>
	</div>
</c:if>
<div class="bg-contact2">
	
	<div class="container-contact2">
		<div class="wrap-contact2">
			<form:form action="${pageContext.request.contextPath}/manage/saveProduct" class="contact2-form validate-form"
				modelAttribute="product" method="POST" enctype="multipart/form-data">
				<span class="contact2-form-title"> Add A New Product </span>

				<div class="wrap-input2 validate-input"
					data-validate="Product Name is required">
					<span class="focus-input2" data-placeholder="PRODUCT NAME"></span>
					<form:input class="input2" type="text" path="name" />
					<form:errors path="name" cssClass="help-block" element="em" />
				</div>

				<div class="wrap-input2 validate-input"
					data-validate="Valid email is required: ex@abc.xyz">
					<span class="focus-input2" data-placeholder="BRAND NAME"></span>
					<form:input class="input2" type="text" path="brand" />
					<form:errors path="brand" cssClass="help-block" element="em" />
				</div>

				<div class="wrap-input2 validate-input"
					data-validate="DESCRİPTION is required">
					<span class="focus-input2" data-placeholder="PRODUCT DESCRIPTION"></span>
					<form:textarea class="input2" path="description" />
					<form:errors path="description" cssClass="help-block" element="em" />
				</div>
				<div class="wrap-input2 validate-input"
					data-validate="Product Name is required">
					<span class="focus-input2" data-placeholder="UNIT PRICE"></span>
					<form:input class="input2" type="text" path="unitPrice" />
					<form:errors path="unitPrice" cssClass="help-block" element="em" />
				</div>

				<div class="wrap-input2 validate-input"
					data-validate="Product Name is required">
					<span class="focus-input2" data-placeholder="QUANTITY AVAILABLE"></span>
					<form:input class="input2" type="text" path="quantity" />
					<form:errors path="quantity" cssClass="help-block" element="em" />
				</div>
				<div class="wrap-input2 validate-input">
					<form:select class="form-control" id="categoryId" path="categoryId"
						items="${categories}" itemLabel="name" itemValue="id" />
				</div>
				<br>
				<!-- File element upload image -->
				<div class="wrap-input2 validate-input">
					<span class="focus-input2" data-placeholder=""></span>
					<form:input class="form-control" type="file" path="file" />
					<form:errors path="file" cssClass="help-block" element="em" />
				</div>

				<div class="container-contact2-form-btn">
					<div class="wrap-contact2-form-btn">
						<div class="contact2-form-bgbtn"></div>
						<c:if test="${newProduct==true}">
						<button class="contact2-form-btn">Add Product</button>
						</c:if>
						<c:if test="${editProduct==true}">
						<button class="contact2-form-btn">Update Product</button>
						</c:if>
					</div>
				</div>
				<form:hidden path="id"/>
				<form:hidden path="code" />
				<form:hidden path="purchases" />
				<form:hidden path="views" />
				<form:hidden path="supplierId" />
				<form:hidden path="active" />
			</form:form>
		</div>
	</div>
	
	<div class="row">

	<div class="container">
		<h3 >Available Product</h3>
		
		<hr />
	</div>
	<div class="container">
		<div style="overflow: auto;">
			<!-- Product table for Admin -->
			<table id="adminProductTable"
				class="table table-striped table-bordered">

				<thead>

					<tr>
						<th>ID</th>
						<th></th>
						<th>NAME</th>
						<th>BRAND</th>
						<th>STOCK</th>
						<th>PRICE</th>
						<th>ACTIVATION</th>
						<th>EDIT</th>

					</tr>

				</thead>
				<tfoot>
					<tr>
						<th>ID</th>
						<th></th>
						<th>NAME</th>
						<th>BRAND</th>
						<th>STOCK</th>
						<th>PRICE</th>
						<th>ACTIVATION</th>
						<th>EDIT</th>
					</tr>
				</tfoot>
			</table>
		</div>

	</div>
</div>
	
</div>
<script src="js/main.js"></script>


<!-- Global site tag (gtag.js) - Google Analytics -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-23581568-13');
</script>
