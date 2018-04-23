<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" align="center">
	<div class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="card card-outline-secondary">
			<div class="card-header">
				<h3 class="mb-0">Addres Information</h3>
			</div>
			<div class="card-body">
				<sf:form id="registerForm" class="form" role="form"
					modelAttribute="billing" method="POST">
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">First Address</label>
						<div class="col-lg-9">
							<sf:input type="text" path="addressLineOne" class="form-control"
								placeholder="First Address" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Second Address</label>
						<div class="col-lg-9">
							<sf:input type="text" path="addressLineTwo" class="form-control"
								placeholder="Second Address" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">City</label>
						<div class="col-lg-9">
							<sf:input type="text" path="city" class="form-control"
								placeholder="City" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">State</label>
						<div class="col-lg-9">
							<sf:input type="text" path="state" class="form-control"
								placeholder="State" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Country Number</label>
						<div class="col-lg-9">
							<sf:input type="text" path="country" class="form-control"
								placeholder="Country" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Postal Code</label>
						<div class="col-lg-9">
							<sf:input type="text" path="postalCode" class="form-control"
								placeholder="Postal Code" />
						</div>
					</div>
					
					
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label"></label>
						<div class="col-lg-9">
							<button type="submit" class="btn btn-danger" name="_eventId_personal">
								Previous-Personal
							</button>
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success" name="_eventId_confirm">
								Next-Confirm
							</button>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>