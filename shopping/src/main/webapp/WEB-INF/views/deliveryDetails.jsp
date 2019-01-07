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
					<h4>Delivery Information</h4>
				</div>


				<div class="panel-body">

					<!-- Form Elements -->

					<sf:form class="form-horizontal" modelAttribute="delivery">

						<div class="form-group">

							<label class="control-label col-md-5" for="Id">Enter
								Purchase Order :</label>

							<div class="col-md-6">
								<sf:input type="text" path="Id" id="Id"
									placeholder="Purchase Order" class="form-control" />
								<!-- <sf:errors path="Id" cssClass="help-block" element="em" /> -->
								<!-- <em class="help-block">Please Enter Purchase Order</em> -->
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-5" for="ddate">Enter
								Due Date :</label>

							<div class="col-md-6">
								<sf:input type="date" path="ddate" id="ddate"
									placeholder="Due Date" class="form-control" />
								<!-- <em class="help-block">Please Enter Due Date</em> -->
							</div>
						</div>

						<div class="col-md-8">
							<h3>
								<b>Site Details</b>
							</h3>
						</div>

						<div class="form-group">
							<label class="control-label col-md-5" for="branch">Enter
								Company Branch :</label>

							<div class="col-md-6">
								<sf:select class="form-control" id="branch" path="branch">
									<option value="Colombo">Colombo</option>
									<option value="Kandy">Kandy</option>
									<option value="Matara">Matara</option>
									<option value="Jaffna">Jaffna</option>

								</sf:select>
								<sf:errors path="branch" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-5" for="address">Enter
								Branch Address :</label>

							<div class="col-md-6">
								<sf:input type="text" path="address" id="address"
									placeholder="Branch Address" class="form-control" />
								<sf:errors path="address" cssClass="help-block" element="em" />
								<!-- <em class="help-block">Please Enter Branch Address</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-5" for="no">Enter
								Branch Contact No :</label>

							<div class="col-md-6">
								<sf:input type="text" path="no" id="no" placeholder="Contact No"
									class="form-control" />
								<sf:errors path="no" cssClass="help-block" element="em" />
								<!-- <em class="help-block">Please Enter Branch Contact No</em> -->
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-5" for="a"> </label>
							<div class="col-md-6">
								<input type="submit" name="submit" id="submit" value="Submit"
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
			<h3>Delivery Information</h3>
			<hr />
		</div>

		<div class="col-xs-12">

			<div style="overflow: auto">

				<!-- Delivery Details -->

				<table id="deliveryTable" class="table table-striped table-bordred">
					<thead>
						<tr>

							<th>Delivery</th>
							<th>Purchase Order Id</th>
							<th>Branch</th>
							<th>Address</th>
							<th>Due Date</th>
							<th>Contact No</th>
							<!-- <th></th> -->

						</tr>
					<tfoot>
						<tr>
							<th>Delivery</th>
							<th>Purchase Order Id</th>
							<th>Branch</th>
							<th>Address</th>
							<th>Due Date</th>
							<th>Contact No</th>
							<!-- <th></th> -->

						</tr>

					</tfoot>

				</table>



			</div>

		</div>


</div>

