<div class="container">
	<!-- test -->
	<div class="row">

		<!-- </div> -->

		<!-- To Display The Actual Product -->
		<div class="col-md-9">
			<!-- Added breadcrumb componenet -->

			<div class="row">

				<div class="col-lg-12">
				
					<c:if test="${userClickAllItems == true}">

						<script>
							window.itemId = '${item.itemId}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/ All Items</li>
							<li class="active">${item.itemN}</li>
						</ol>
					</c:if>

				</div>

			</div>


			<div class="row">

				<div class="col-xs-8">
					<table id="itemListTable"
						class="table table-striped table-bordred">
						<thead>
							<tr>
								
								<th>Purchase Order Id</th>
								<th>Delivery </th>
								<th>Item</th>
								<th>Item Name</th>
								<th>Quantity</th>
								<th>Matched</th>
								<!-- <th></th> -->

							</tr>

						</thead>

					 	<tfoot>
							<tr>
							
								<th>Purchase Order Id</th>
								<th>Delivery </th>
								<th>Item</th>
								<th>Item Name</th>
								<th>Quantity</th>
								<th>Matched</th>
							

							</tr>

						</tfoot>

					</table>

				</div>
			</div>
		</div>

	</div>
</div>
