<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">
	<!-- test -->
	<div class="row">

		<%@include file="./shared/sidebar.jsp"%>


		<!-- </div> -->

		<!-- To Display The Actual Product -->
		<div class="col-md-12">
			<!-- Added breadcrumb component-->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllSuppliers == true}">
						<script>
							window.supplierId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a> /</li>

							<li><a href="${contextRoot}/manage/supplier"> Supplier
									Management </a> /</li>

							<li class="active">Supplier Details</li>
						</ol>
					</c:if>
				</div>
				<div class="col-xs-8">
					<table id="supplierTable" class="table table-striped table-bordred">
						<thead>
							<tr>

								<th>ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Phone</th>



							</tr>

						</thead>

						<tfoot>
							<tr>

								<th>ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Phone</th>


							</tr>

						</tfoot>

					</table>

				</div>
			</div>
		</div>

	</div>
</div>
