
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Procurement Management</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<%-- <li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>

				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li> --%>
				
				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">Products Management</a></li>
					
				<li class="nav-item" id="orderProducts"><a class="nav-link"
					href="${contextRoot}/order/orderproducts">Order Products</a></li>

				<li class="nav-item" id="emailForm"><a class="nav-link"
					href="${contextRoot}/email/emailForm">Send Email</a></li>

				<!-- Supplier -->
				<li class="nav-item" id="manageSupplier"><a class="nav-link"
					href="${contextRoot}/show/all/supplier">Manage Supplier</a></li>


				<li class="nav-item" id="deliveryDetails"><a class="nav-link"
					href="${contextRoot}/delivery/deliverydetails">Delivery Details</a></li>

				<li class="nav-item" id="acceptDetails"><a class="nav-link"
					href="${contextRoot}/accept/acceptdetails">Accept Delivery</a></li>

				<li class="nav-item" id="listItems"><a class="nav-link"
					href="${contextRoot}/show/all/items">View Items</a></li>

				<li class="nav-item" id="emailForm"><a class="nav-link"
					href="${contextRoot}/email/emailForm">Send Back</a></li>
					
					<li class="nav-item" id="payment"><a class="nav-link"
					href="${contextRoot}/payment">Payment</a></li>
			</ul>
		</div>
	</div>
</nav>
