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
		<h1>Edit Airport Details</h1>
		<form action="${pageContext.request.contextPath}/updateAirport" method="post">
			<table>
				<tr>
					<th>Airport ID:</th>
					<td><input name="airportID" type="number" value="${ID}"
						placeholder="Airport ID" required></td>
				</tr>
				<tr>
					<th>Airport Name:</th>
					<td><input name="airportName" type="text"
						value="${AirportName}" placeholder="Airport Name" required></td>
				</tr>
				<tr>
					<th>Airport Location:</th>
					<td><input name="airportLocation" type="text"
						value="${AirportLocation}" placeholder="Airport Location" required></td>
				</tr>
				<tr>
					<th>No Of Planes:</th>
					<td><input name="noOfPlanes" type="number"
						value="${NO_OF_Planes}" placeholder="No Of Planes" required></td>
				</tr>
				<tr>
					<th>No Of RunWays:</th>
					<td><input name="noOfRunways" type="number"
						value="${NO_OF_Runways}" placeholder="No Of Runways" required></td>
				</tr>
			</table>
			<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
			<button type="submit">Update</button>
		</form>
	</div>
	<h2>${responseMessage}</h2>

</body>
</html>