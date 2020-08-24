<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#account').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are yuo sure ..You want to delete");
	}
</script>
</head>
<body>
	<table border="1" id="account">
		<thead>
			<tr>
				<th>S.NO</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>ROLE</th>
				<th>ACTIONS</th>
			</tr>
		</thead>
		<c:forEach items="${allAccounts}" var="obj" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${obj.firstName}${obj.lastName}</td>
				<td>${obj.email}</td>
				<td>${obj.role}</td>
				<td><a href="delete?cid=${obj.regId}"
					onClick="return confirmDelete()">DELETE</a> <a
					href="edit?cid=${obj.regId}">EDIT</a></td>
			</tr>
		</c:forEach>
		<tbody>
		</tbody>
	</table>
</body>
</html>














<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#account').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are yuo sure ..You want to delete");
	}
</script>

</head>
<!-- <style>
td {
	text-align: center
}

tr {
	text-align: center;
}
</style> -->

<body>
	<div class="container">
		<!-- class="container" -->
		<!-- <h2>Accounts List</h2> -->
		<c:choose>
			<c:when test="${!empty allAccounts}">
				<!-- <a href="/account/">+Add Account</a> -->
				<table border="1" id="account" class="display" style="width: 100%"
					cellspacing="0">
					<!--  class="table table-border table-hover" -->
					<thead>
						<tr>
							<!--  class="table-primary -->
							<th>S.NO</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>ROLE</th>
							<th>ACTIONS</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${allAccounts}" var="obj" varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>${obj.firstName}  ${obj.lastName}</td>
								<td>${obj.email}</td>
								<td>${obj.role}</td>
								<td>
									<button>
										<a href="delete?cid=${obj.regId}" onClick="return confirmDelete()">DELETE</a>
									</button>
									<button>
										<a href="edit?cid=${obj.regId}">EDIT</a>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h4>No Account Found!!!</h4>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html> --%>