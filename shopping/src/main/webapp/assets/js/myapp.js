$(function() {
	// active menu
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'Manage Supplier':
		$('#manageSupplier').addClass('active');
		break;
	case 'Supplier Management':
		$('#supplierManagement').addClass('active');
		break;
	case 'Order Products':
		$('#orderProducts').addClass('active');
		break;
	case 'Send Email':
		$('#orderProducts').addClass('active');
		break;
	case 'Delivery Details':
		$('#deliveryDetails').addClass('active');
		break;
	case 'Accept Delivery':
		$('#acceptDetails').addClass('active');
		break;
	case 'All Items':
		$('#listItems').addClass('active');
		break;
	case 'Send':
		$('#orderProducts').addClass('active');
		break;
	case 'Payment':
		$('#payment').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery DataTable

	var jsonUrl = '';
	if (window.categoryId == '') {
		jsonUrl = window.contextRoot + '/json/data/all/products';

	} else {

		jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.catgortId + '/products';
	}

	var $table = $('#productListTable')
	// execute below code only where we have this table

	if ($table.length) {

		// console.log('Inside the Table');

		$table
				.DataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 5,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'id'

							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return 'Rs:' + data
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {

										return '<span style="color:red">Out Of Stock</span>';
									}
									return data;
								}

							}
					

					]
				});
	}
	// data table for admin

	var jsonUrl = '';

	var $adminProductsTable = $('#adminProductsTable')
	// execute below code only where we have this table

	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		// console.log('Inside the Table');

		$adminProductsTable
				.DataTable({

					lengthMenu : [
							[ 10, 20, 50, -1 ],
							[ '10 Records', '20 Records', '50 Records',
									'ALL Records' ] ],
					pageLength : 10,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

							{
								data : 'id'

							},
							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {

										return '<span style="color:red">Out Of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return 'Rs:' + data
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					]

				});
	}
	// data table for order

	var jsonUrl = '';

	var $adminOrdersTable = $('#adminOrdersTable')
	// execute below code only where we have this table

	if ($adminOrdersTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/orders';
		// console.log('Inside the Table');

		$adminOrdersTable
				.DataTable({

					lengthMenu : [
							[ 10, 20, 50, -1 ],
							[ '10 Records', '20 Records', '50 Records',
									'ALL Records' ] ],
					pageLength : 10,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

							{
								data : 'id'

							},

							{
								data : 'name'

							},
							{
								data : 'brand'

							},
							{
								data : 'email'

							},
							{
								data : 'supplier'

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {

										return '<span style="color:red">Out Of Stock</span>';
									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return 'Rs:' + data

								}

							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '"/>';

									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '"/>';
									}

									/* str += '<div class="slider"></div></label>'; */
									str += '<div class="slider round"></div></label>';

									return str;
								}

							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="${contextRoot}/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					],

					// render table
					initComplete : function() {

						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the order?'
													: 'You want to deactivate the order';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Order Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {

															if (confirmed) {
																console
																		.log(value);
																// prepare url
																// for
																// activation
																var activationUrl = window.contextRoot
																		+ '/order/orders/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({

																								size : 'medium',
																								title : 'Information',
																								message : data
																							});

																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});

										});
					}

				});
	}

	// suplier

	var jsonUrl = '';

	var $supplierTable = $('#supplierTable');

	if ($supplierTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/all/supplier';

		$supplierTable
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [ {
						data : 'id'
					}, {
						data : 'name'
					}, {
						data : 'email'
					}, {
						data : 'phone'
					} 
					],

				});
	}

	var jsonUrl2 = '';

	var $supplierTable = $('#AllSupplierTable');

	if ($supplierTable.length) {

		var jsonUrl2 = window.contextRoot + '/json/data/all/supplier';

		$supplierTable
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl2,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'name'
							},
							{
								data : 'email'
							},
							{
								data : 'phone'
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'+window.contextRoot+'/manage/'
											+ data
											+ '/supplier" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					],

				});
	}	//

	// code for jquery data table for items
	// create a data set

	/*
	 * var items = [ [ '1', 'ABC', '1', '1', 'Tyres', '500', 'TRUE' ], [ '1',
	 * 'DEF', '2', '1', 'Tyres', '500', 'TRUE' ] ];
	 */
	var jsonUrl = '';
	if (window.itemId == '') {
		jsonUrl = window.contextRoot + '/json/data/all/items';

	}/*
		 * else {
		 * 
		 * jsonUrl = window.contextRoot + '/json/data/all/items' +
		 * window.catgortId + '/products'; }
		 */

	var $table = $('#itemListTable');

	// execute the below code only when we have this table
	if ($table.length) {

		// console.log('Inside the table');

		$table
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					// data : items

					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

							{
								data : 'id'

							},
							{
								data : 'delid',

							},
							{
								data : 'itmId'

							},
							{
								data : 'itemN'

							},
							{
								data : 'quantity'

							},
							{
								data : 'matched',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '"/>';

									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '"/>';
									}

									/* str += '<div class="slider"></div></label>'; */
									str += '<div class="slider round"></div></label>';

									return str;
								}

							}

					],

				});
	}

	// code for jquery data table for delivery
	// create a data set

	var jsonUrl = '';

	var $deliveryTable = $('#deliveryTable')

	/*
	 * if (window.itemId == '') { jsonUrl = window.contextRoot +
	 * '/json/data/all/deliveries';
	 *  }
	 */

	// execute the below code only when we have this table
	if ($deliveryTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/all/deliveries';
		// console.log('Inside the table');

		$deliveryTable
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					// data : items

					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

					{
						data : 'delId'

					}, {
						data : 'id'

					}, {
						data : 'branch'

					}, {
						data : 'address'

					}, {
						data : 'ddate'

					}, {
						data : 'no'

					}

					],

				});
	}

	// code for jquery data table for accept
	// create a data set

	var jsonUrl = '';

	var $deliveryTable1 = $('#acceptTable')

	// execute the below code only when we have this table
	if ($deliveryTable1.length) {
		var jsonUrl = window.contextRoot + '/json/data/all/accepts';
		// console.log('Inside the table');

		$deliveryTable1
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					// data : items

					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

					{
						data : 'acpId'

					}, {
						data : 'id'

					}, {
						data : 'delid'

					}, {
						data : 'status'

					}, {
						data : 'deDate'

					}

					],

				});
	}

	// payment
	var jsonUrl = '';

	var $paymentTable = $('#paymentTable')

	// execute the below code only when we have this table
	if ($paymentTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/all/payments';
		// console.log('Inside the table');

		$paymentTable
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'ALL Records' ] ],
					pageLength : 10,
					// data : items

					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [

					{
						data : 'id'

					}, {
						data : 'supplier'

					}, {
						data : 'paid'

					}, {
						data : 'oid'

					}, {
						data : 'amount'

					}

					],

				});
	}

	// dismissing the alert after 3 seconds

	var $alert = $('.alert');
	if ($alert.length) {

		setTimeot(function() {

			$alert.fadeOut('slow');
		}, 3000)

	}

});