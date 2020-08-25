<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
thead {
	background: black;
}
/* td {
	background: silver;
} */
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#plan').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are yuo sure ..You want to delete");
	}

	function confirmActive() {
		return confirm("Are you sure ..You want to Active");
	}
</script>
</head>
<body>
	<table border="1" id="plan">
		<thead style="color: red;">
			<tr>
				<th>S.NO</th>
				<th>PLAN NAME</th>
				<th>PLAN DESCRIPTION</th>
				<th>START DATE</th>
				<th>END DATE</th>
				<th>ACTIONS</th>
			</tr>
		</thead>
		<c:forEach items="${allPlans}" var="obj" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${obj.planName}</td>
				<td>${obj.planDescription}</td>
				<td>${obj.startDate}</td>
				<td>${obj.endDate}</td>

				<td>
				<button class="btn btn-warning"><a href="edit?pid=${obj.planId}">EDIT</a></button>
				 <c:choose>
						<c:when test="${obj.deleteStatus eq 'null'}">

							<button class="btn btn-danger"><a href="delete?pid=${obj.planId}"
								onClick="return confirmDelete()">DELETE</a></button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-light"><a href="active?pid=${obj.planId}" onClick="return confirmActive()">ACTIVATE</a></button>
							
							
						</c:otherwise>
					</c:choose>
					 </td>
			</tr>


		</c:forEach>
		<tbody>
		</tbody>
	</table>
</body>
</html>








