<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<!-- Personal form -->
		<div class="col-sm-6">

			<div class="card card-outline-secondary">
				<div class="card-header">
					<h3 class="mb-0">User Information</h3>
				</div>
				<div class="card-body">
					<sf:form id="registerForm" class="form" role="form"
						modelAttribute="user" method="POST">
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">First
								Name</label>
							<div class="col-lg-9">
								<label class="col-lg-3 col-form-label form-control-label">${registerModel.user.firstName}</label>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Last
								Name</label>
							<div class="col-lg-9">
								<label class="col-lg-3 col-form-label form-control-label">${registerModel.user.lastName}</label>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-2 col-form-label form-control-label">Email</label>
							
								<label class="col-lg-4 col-form-label form-control-label">${registerModel.user.email}</label>
							
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Contact
								Number</label>
							
								<label class="col-lg-3 col-form-label form-control-label">${registerModel.user.contactNumber}</label>
							
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Password</label>
							<div class="col-lg-9">
								<label class="col-lg-3 col-form-label form-control-label">${registerModel.user.password}</label>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Select
								Role</label>
							<div class="col-lg-9">
								<label class="col-lg-3 col-form-label form-control-label">${registerModel.user.role}</label>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label"></label>
							<div class="col-lg-9">
								<a href="${flowExecutionUrl}&_eventId_personal"
									class="btn btn-primary">Edit</a>
							</div>
						</div>
					</sf:form>
				</div>
			</div>

		</div>
		<!-- Personal form -->
		<!-- Address show flow form -->
		<div class="col-sm-6">

			<div class="card card-outline-secondary">
				<div class="card-header">
					<h3 class="mb-0">Addres Information</h3>
				</div>
				<div class="card-body">

					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">First
							Address</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.addressLineOne}</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Second
							Address</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.addressLineTwo}</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">City</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.addressLineOne}</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">State</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.state}</label>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Country</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.country}</label>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Postal
							Code</label>
						<div class="col-lg-9">
							<label class="col-lg-3 col-form-label form-control-label">${registerModel.billing.postalCode}</label>
						</div>
					</div>


					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label"></label>
						<div class="col-lg-9">
							<a href="${flowExecutionUrl}&_eventId_billing"
								class="btn btn-primary">Edit</a>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
	<!-- Address show flow form -->
	<br>
	
	
	<div class="text-center">
		<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-success">Confirm</a>
	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>