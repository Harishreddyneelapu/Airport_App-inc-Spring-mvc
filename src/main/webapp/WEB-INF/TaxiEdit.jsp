<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Update</title>
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

.form-container {
	background-color: #cce6ff;
	border: 1px solid #ddd;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: left;
	margin-bottom: 20px;
}

button[type="submit"] {
	background-color: orange;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="form-container">
		<h1>Edit Taxi Details</h1>
		<form action="${pageContext.request.contextPath}/updateTaxi"
			method="post">
			<table>
				<tr>
					<th>Taxi ID:</th>
					<td><input name="taxiID" type="number" value="${ID}"
						placeholder="Taxi ID" required></td>
				</tr>
				<tr>
					<th>Model:</th>
					<td><input name="model" type="text"
						value="${Model}" placeholder="Model" required></td>
				</tr>
				<tr>
					<th>Driver Name:</th>
					<td><input name="driverName" type="text"
						value="${Driver_Name}" placeholder="Driver Name" required></td>
				</tr>
				<tr>
					<th>Curr Location:</th>
					<td><input name="currLocation" type="text"
						value="${Curr_Location}" placeholder="Curr Location" required></td>
				</tr>
				<tr>
					<th>Availability:</th>
					<td><input name="availability" type="text"
						value="${Availability}" placeholder="Availability" required></td>
				</tr>
			</table>
			<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
			<button type="submit">Update</button>
		</form>
	</div>
	<h2>${responseMessage}</h2>
</body>
</html>