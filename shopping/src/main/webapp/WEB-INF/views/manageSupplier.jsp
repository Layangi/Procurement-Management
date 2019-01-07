<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismisible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Supplier Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form elements -->
					<sf:form class="form-horizontal" modelAttribute="supplier"
						action="${contextRoot}/manage/supplier" method="POST">
						<%-- <div class="form-group">
							<label class="control-label col-md-4" for="Id">
								Supplier ID
							</label>
							<div class="col-md-8">
								<sf:input type="text" path="Id" id="Id" placeholder="Supplier ID" class="form-control"/>
							</div>
						</div>
						 --%>
						<div class="form-group">
							<label class="control-label col-md-4" for="name">
								Supplier Name </label>
							<div class="col-md-8">
								<sf:input type="text" path="Name" id="name"
									placeholder="Supplier Name" class="form-control" />
								<sf:errors path="Name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="email"> Email
								Address </label>
							<div class="col-md-8">
								<sf:input type="text" path="Email" id="Email"
									placeholder="Email" class="form-control" />
								<sf:errors path="Email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="phone">
								Contact Number </label>
							<div class="col-md-8">
								<sf:input type="text" path="phone" id="phone"
									placeholder="Contact Number" class="form-control" />
								<sf:errors path="phone" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<!-- hidden fields for supplier -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>Supplier Details</h3>
			<hr/>
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto">
				<table id="AllSupplierTable" class="table table-striped table-bordred">
					<thead>
						<tr>
							<th>ID</th>							
							<th>Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Edit</th>

						</tr>

					</thead>
					
					
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Edit</th>

						</tr>

					</tfoot>

				</table>
			</div>
		</div>
	</div>
</div>