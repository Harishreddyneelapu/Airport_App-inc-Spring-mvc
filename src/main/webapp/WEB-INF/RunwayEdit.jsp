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
		<h1>Edit Runway Details</h1>
		<form action="${pageContext.request.contextPath}/updateRunway"
			method="post">
			<table>
				<tr>
					<th>Runway ID:</th>
					<td><input name="runwayID" type="number" value="${ID}"
						placeholder="Runway ID" required></td>
				</tr>
				<tr>
					<th>Length:</th>
					<td><input name="length" type="number"
						value="${Length}" placeholder="Length" required></td>
				</tr>
				<tr>
					<th>Width:</th>
					<td><input name="width" type="number"
						value="${Width}" placeholder="Width" required></td>
				</tr>
				<tr>
					<th>Surface Type:</th>
					<td><input name="surfaceType" type="text"
						value="${Surface_Type}" placeholder="Surface type" required></td>
				</tr>
				<tr>
					<th>Direction:</th>
					<td><input name="direction" type="text"
						value="${Direction}" placeholder="Direction" required></td>
				</tr>
			</table>
			<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
			<button type="submit">Update</button>
		</form>
	</div>
	<h2>${responseMessage}</h2>
</body>
</html>