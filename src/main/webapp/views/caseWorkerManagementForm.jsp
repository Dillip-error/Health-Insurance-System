<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>


</head>

<body>

	<form:form action="create" method="POST"
		modelAttribute="caseWorkerManagementEntity">

		<div class="container p-3 mb-2 bg-light text-dark "
			style="background-image: url('../images/Background.jpg');">


			<div class="card">
				<div
					class="card-header bg-primary text-white text-uppercase text-center">
					<h2>Create Account</h2>
				</div>
			</div>


			<div class="row">
				<div class="col-4 ">
					<label for="fname"><b style="color: blue;">First Name</b></label>
				</div>
				<div class="col-4 p-1">
					 <form:hidden path="regId" /> 
					<form:input type="text" class="form-control" placeholder="First name"
						path="firstName" id="fname"/>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="lname"><b style="color: blue;">Last Name</b></label>
				</div>

				<div class="col-4 p-1">
					<form:input type="text" class="form-control" placeholder="Last name"
						path="lastName" id="lname"></form:input>
				</div>

			</div>

			<div class=" row">
				<div class="col-4">
					<label for="email"><b style="color: blue;">Email Adrss</b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="email" class="form-control" id="email"
						placeholder="dillipksahoo1996@gmail.com" path="email"></form:input>
				</div>

			</div>




			<div class="row">
				<div class="col-4">
					<label for="gen"><b style="color: blue;">Gender</b></label>
				</div>

				<div class="col-4 p-1 ">
                 <form:radiobutton path="gender" value="male"/><b style="color: blue;">MALE</b>
                 <form:radiobutton path="gender" value="female"/><b style="color: blue;">FEMALE</b>
                 <form:radiobutton path="gender" value="other"/><b style="color: blue;">OTHER</b>
				</div>

			</div>
			
			<div class="row">
				<div class="col-4">
					<label for="role"><b style="color: blue;">Role</b></label>
				</div>

				<div class="col-4 p-1">
					<form:select class="form-control" path="role">
						<form:option value="">Choose Role...</form:option>
						<form:option value="CaseWorker">CaseWorker</form:option>
						<form:option value="Admin">Admin</form:option>
					</form:select>
				</div>

			</div>
			

			<div class="row">

				<div class="col-4 ">
					<input type="submit" value="Reset Account" class="btn btn-warning" />
				</div>

				<div class="col-4 ">
					<input type="submit" value="create Account" class="btn btn-primary"
						id="register">
				</div>

			</div>

			<c:if test="${!empty msg}">
				<div class="card-footer bg-info text-white text-center p-1">
					<h3>${msg}</h3>
					<h3>
						<a
							href="send?url=https://accounts.google.com/AccountChooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser/">click
							here to Check your Mail...</a>
					</h3>
				</div>
			</c:if>
		</div>

	</form:form>
</body>
</html>
