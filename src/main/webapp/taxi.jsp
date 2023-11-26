<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TAXI FORM</title>
<style>
body {
	background-color: #ffccdd;
	display: flex;
	flex-direction: column;
	justify-content: left;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.header, .footer {
	background-color: #cce6ff;
	width: 100%;
	padding: 10px;
	text-align: center;
}

.form-container {
	background-color: #cce6ff;
	border: 1px solid #ddd;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: center;
	margin-bottom: 20px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	font-weight: bold;
}

input[type="number"], input[type="text"] {
	width: 100%;
	padding: 5px;
}

button[type="submit"] {
	background-color: orange;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
table.search-results-all {
	border-collapse: collapse;
	width: 60%;
	border: 1px solid #cce6ff;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Header Content</h1>
		<a href="welcome.jsp">BACK</a>
	</div>
	<br>
	<br>
	<div class="form-container">
		<h1>Taxi Form</h1>
		<form action="saveTaxi" method="post">
			<table>
				<tr>
					<th>Model:</th>
					<td><input name="model" type="text" value=""
						placeholder="Model" required></td>
				</tr>
				<tr>
					<th>Driver Name:</th>
					<td><input name="driverName" type="text" value=""
						placeholder="DriverName" required></td>
				</tr>
				<tr>
					<th>Curr Location:</th>
					<td><input name="currLocation" type="text" value=""
						placeholder="CurrentLocation" required></td>
				</tr>
				<tr>
					<th>Availability:</th>
					<td><input name="availability" type="text" value=""
						placeholder="Availability" required></td>
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form>
	</div>
	<h2 style="background-color: ${isValid ? 'green' : 'red'};">${responseMessage}</h2>
	
	<div class="search-form-getAll">
		<form action="getAllTaxi">
			<button type="submit">GetAll</button>
		</form>
	</div><br>
	<table class="search-results-all" border="1">

		<tr>
			<th>Taxi ID</th>
			<th>Model</th>
			<th>Driver Name</th>
			<th>Curr Location</th>
			<th>Availability</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach var="taxi" items="${taxiList}">
			<tr>
				<td>${taxi.taxiID}</td>
				<td>${taxi.model}</td>
				<td>${taxi.driverName}</td>
				<td>${taxi.currLocation}</td>
				<td>${taxi.availability}</td>
				<td><a href="editTaxi/${taxi.taxiID}">Edit</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteTaxiByID/${taxi.taxiID}">Delete</a></td>
			</tr>
		</c:forEach>

	</table><br><br>
	<div class="footer">
		<h1>Footer Content</h1>
	</div>
</body>
</html>











