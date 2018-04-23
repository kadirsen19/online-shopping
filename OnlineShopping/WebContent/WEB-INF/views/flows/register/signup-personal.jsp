<%@include file="../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container" align="center">
	<div class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="card card-outline-secondary">
			<div class="card-header">
				<h3 class="mb-0">User Information</h3>
			</div>
			<div class="card-body">
				<sf:form id="registerForm" class="form" role="form"
					modelAttribute="user" method="POST">
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Firstname</label>
						<div class="col-lg-9">
							<sf:input type="text" path="firstName" class="form-control"
								placeholder="First Name" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Lastname</label>
						<div class="col-lg-9">
							<sf:input type="text" path="lastName" class="form-control"
								placeholder="Last Name" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Email</label>
						<div class="col-lg-9">
							<sf:input type="text" path="email" class="form-control"
								placeholder="Email" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Contact
							Number</label>
						<div class="col-lg-9">
							<sf:input type="text" path="contactNumber" class="form-control"
								placeholder="Cantact Number" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Password</label>
						<div class="col-lg-9">
							<sf:input type="text" path="password" class="form-control"
								placeholder="Password" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label">Select
							Role</label>
						<div class="col-lg-9">
							<label class="radio-inline"> 
								<sf:radiobutton path="role" value="USER"  /> User
							</label> 
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<label class="radio-inline"> 
								<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
							</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label form-control-label"></label>
						<div class="col-lg-9">
							<input type="reset" class="btn btn-danger"  value="Cancel">
							&nbsp;&nbsp;&nbsp;
							<button type="submit" class="btn btn-success" name="_eventId_billing">
								Next-Billing
							</button>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>