<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container text-center mt-2">
	    <a href="/showAddStudent" class="btn btn-primary">Add Student</a>
		<h1>List of Students</h1>
		<table class="table border">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">City</th>
					<th scope="col">Salary</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${students}">

					<tr>
						<th scope="row">${student.id}</th>
						<td>${student.name}</td>
						<td>${student.city}</td>
						<td>${student.salary}</td>
						<td>
						   <a href="/deleteStudent/${student.id}" class="btn btn-danger">Delete</a>
						   <a href="/showUpdateStudent/${student.id}" class="btn btn-success">Update</a>
						</td>
					</tr>

				</c:forEach>


			</tbody>
		</table>

	</div>
</body>
</html>