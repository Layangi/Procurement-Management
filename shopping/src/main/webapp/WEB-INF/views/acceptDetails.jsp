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
		<div class="col-xs-12"></div>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Accept Delivery</h4>

				</div>

				<div class="panel-body">
					<!-- Form Elements -->

					<sf:form class="form-horizontal" modelAttribute="accept">

						<div class="form-group">

							<label class="control-label col-md-5" for="Id">Enter
								Purchase Order :</label>

							<div class="col-md-6">
								<sf:input type="text" path="Id" id="Id"
									placeholder="Purchase Order" class="form-control" />
								<sf:errors path="Id" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-5" for="Delid">Enter
								Delivery Order :</label>

							<div class="col-md-6">
								<sf:input type="text" path="Delid" id="Delid"
									placeholder="Delivery Order" class="form-control" />
								<sf:errors path="Delid" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-5" for="deDate">Enter
								Received Date :</label>

							<div class="col-md-6">
								<sf:input type="date" path="deDate" id="deDate"
									class="form-control" />
								<sf:errors path="deDate" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-5" for="status">Enter
								Order Status :</label>

							<div class="col-md-6">
								<sf:select class="form-control" id="status" path="status">
									<option value="Pending">Pending</option>
									<option value="Received">Received</option>
									<option value="Sent Back">Sent Back</option>
								</sf:select>
								<sf:errors path="status" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-5" for="a"> </label>
							<div class="col-md-6">
								<input type="submit" name="submit" id="submit" value="Confrim"
									class="btn btn-primary" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">

		<div class="col-xs-12">
			<h3>Received Delivery Information</h3>
			<hr />
		</div>

		<div class="col-xs-12">

			<div style="overflow: auto">

				<!-- Delivery Details -->

				<table id="acceptTable" class="table table-striped table-bordred">
					<thead>
						<tr>

							<th>Accept Id</th>
							<th>Purchase Order Id</th>
							<th>Delivery Id</th>
							<th>Status</th>
							<th>Date</th>
							<!-- <th></th> -->

						</tr>
					<tfoot>
						<tr>
							<th>Accept Id</th>
							<th>Purchase Order Id</th>
							<th>Delivery Id</th>
							<th>Status</th>
							<th>Date</th>
							<!-- <th></th> -->

						</tr>

					</tfoot>

				</table>

			</div>

		</div>


	</div>


</div>