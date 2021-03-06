<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- To Make sure static files responded by the server -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Load resources which are mentioned according to dispatcher servlet -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!-- Context path value will be store inside contextRoot -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping - ${title}</title>
<!-- get the title from Page Controller -->
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<%-- <!-- Bootstrap Dark theme  CSS -->
<link href="${css}/bootstrap-yeti-theme.css" rel="stylesheet"> --%>

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<!-- Page Content -->

		<div class="content">
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- User Click Show Product -->
			<c:if test="${UserClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			<!-- User Click manage Product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

			<!-- User Click order Product -->
			<c:if test="${userClickOrderProducts == true}">
				<%@include file="orderProducts.jsp"%>
			</c:if>

			<!-- User Click order Product -->
			<c:if test="${userClickEmail == true}">
				<%@include file="emailForm.jsp"%>
			</c:if>

			<!-- User Click Supplier -->

			<c:if test="${userClickAllSuppliers == true}">
				<%@include file="supplier.jsp"%>
			</c:if>

			<c:if test="${userClickSupplierManagement == true}">
				<%@include file="manageSupplier.jsp"%>
			</c:if>

			<c:if test="${userClickAllItems == true }">
				<%@include file="listItems.jsp"%>
			</c:if>

			<!-- User Click delivery  Details -->
			<c:if test="${userClickDeliveryDetails == true}">
				<%@include file="deliveryDetails.jsp"%>
			</c:if>

			<!-- User Click accept  Details -->
			<c:if test="${userClickAcceptDetails == true}">
				<%@include file="acceptDetails.jsp"%>
			</c:if>
			<!-- User Click email  Details -->
			<c:if test="${userClickEmailDetails == true}">
				<%@include file="emailForm.jsp"%>
			</c:if>
			
			<!-- User Click Payment -->
			<c:if test="${userClickPayment == true}">
				<%@include file="payment.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<!-- Data Table Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Data Table BoostrapScript -->
		<script src="${js}/dataTables.bootstrap4.js"></script>

		<!-- BootBox -->
		<script src="${js}/bootbox.min.js"></script>
		<!-- Self coded java script -->

		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
