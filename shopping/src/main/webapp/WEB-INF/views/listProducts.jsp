<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">

	<div class="row">

		<!-- To Display The Actual Product -->
		<div class="col-md-9">
			<!-- Added breadcrumb componenet -->

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
						
							<li class="active">All Products</li>
							<li><a href="${contextRoot}/manage/products">Manage Products</a></li>							
						 
							<li><a href="${contextRoot}/home">Home</a></li>


						</ol>
					</c:if>
				</div>

			</div>


			<div class="row">

				<div class="col-xs-8">
					<table id="productListTable"
						class="table table-striped table-bordred">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>


							</tr>

						</thead>

						<tfoot>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>

							</tr>

						</tfoot>

					</table>

				</div>
			</div>
		</div>

	</div>
</div>
