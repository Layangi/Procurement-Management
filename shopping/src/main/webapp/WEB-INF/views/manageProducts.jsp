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
		<div class="com-md-offset-2 col-md-8">
 
			<div class="panel panel-info">


				<div class="panel-heading">

					<h4>Product Management</h4>
				</div>
				<div class="panel-body">

					<!-- Form Elements -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Product
								Name</label>


							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
								
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />


							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="supplierId">Supplier
								Name:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="supplierId"
									path="supplierId" items="${suppliers}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>
						
						<div class="form-group">


							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!-- Hidden Field For product -->
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

	<hr />
	<h1>Available Products</h1>
	<hr />

	<div class="row">


		<div class='col-xs-12'>


			<table id="adminProductsTable"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>												
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Edit</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Id</th>					
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Edit</th>
					</tr>
				</tfoot>


			</table>


		</div>


	</div>


</div>