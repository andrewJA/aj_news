<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Post Adding Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
        $( function() {
            $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd', changeYear:true});
        } );
	</script>

</head>

<body>

	<h2>Registration Form</h2>

	<div class="generic-container">
		<div class="well lead">User Registration Form</div>
		<form:form method="POST" modelAttribute="post" class="form-horizontal">
		<form:input type="hidden" path="idPost" id="id"/>



		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Post name</label>
				<div class="col-md-7">
				<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="date">Posting date</label>
				<div class="col-md-7">
					<form:input type="text" path="date" id="datepicker" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="date" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="category">Category</label>
				<div class="col-md-7">
					<form:select path="category" items="${categories}" itemValue="idCategory" itemLabel="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="category" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="content">Content</label>
				<div class="col-md-7">
					<form:textarea rows="4" cols="40"  path="content" id="content"></form:textarea>
					<div class="has-error">
						<form:errors path="content" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>