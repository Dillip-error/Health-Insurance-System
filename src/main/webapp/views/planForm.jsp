<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="../js/app.js"></script>
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
		modelAttribute="planEntity">

		<div class="container p-3 mb-2 bg-light text-dark "
			style="background-image: url('../images/Background.jpg');">


			<div class="card">
				<div
					class="card-header bg-primary text-white text-uppercase text-center">
					<h2>Create Plan</h2>
				</div>
			</div>


			<div class="row">
				<div class="col-4 ">
					<label for="pname"><b style="color: blue;">Plan Name</b></label>
				</div>
				<div class="col-4 p-1">
					 <form:hidden path="planId" /> 
					<form:input type="text" class="form-control" placeholder="Plan name"
						path="planName" id="pname"/>
				</div>
				<div class="col-4">
					<span id="pNameError"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="dec"><b style="color: blue;">Plan Description</b></label>
				</div>

				<div class="col-4 p-1">
					<form:textarea  class="form-control" placeholder="Plan Descriptio"
						path="planDescription" id="dec"></form:textarea>
				</div>
				<div class="col-4">
					<span id="decError"></span>
				</div>

			</div>

			<div class=" row">
				<div class="col-4">
					<label for="sdate"><b style="color: blue;">Plan StartDate</b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="date" class="form-control" id="sdate"
						placeholder="Start Date" path="startDate"></form:input>
				</div>

			</div>
			
			<div class=" row">
				<div class="col-4">
					<label for="edate"><b style="color: blue;">Plan EndDate</b></label>
				</div>
				<div class="col-4 p-1">
					<form:input type="date" class="form-control" id="edate"
						placeholder="End Date" path="endDate"></form:input>
				</div>

			</div>

			

			<div class="row">

				<div class="col-4 ">
					<input type="submit" value="create Plan" class="btn btn-primary"
						id="register">
				</div>

			</div>

			<c:if test="${!empty msg}">
				<div class="card-footer bg-info text-white text-center p-1">
					<h3>${msg}</h3>
				</div>
			</c:if>
		</div>

	</form:form>
</body>
</html>
