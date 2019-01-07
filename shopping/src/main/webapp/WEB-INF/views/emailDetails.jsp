<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

					<h4>Email Form</h4>
				</div>
				<div class="panel-body">

					<form id="sendEmailForm" method="post" action="emaiDetails"
						enctype="multipart/form-data" class="form-horizontal" >
						<table id="emailFormBeanTable" border="0" width="80%" class="table">
							<tr>
								<td>Email To:</td>
								<td><input id="receiverMail" type="text" name="mailTo"
									size="65" /></td>
							</tr>
							<tr></tr>
							<tr>
								<td>Subject:</td>
								<td><input id="mailSubject" type="text" name="subject"
									size="65" /></td>
							</tr>
							<tr>
								<td>Message:</td>
								<td><textarea id="mailMessage" cols="65" rows="10"
										name="message"></textarea></td>
							</tr>
							<tr>
								<td>Attachment:</td>
								<td><input id="mailAttachment" type="file"
									name="attachFileObj" size="60" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input id="" type="submit"
									value="Email" class="btn btn-primary"/></td>
							</tr>
						</table>
					</form>
			</div>

			</div>
		</div>
	</div>
</div>
</html>