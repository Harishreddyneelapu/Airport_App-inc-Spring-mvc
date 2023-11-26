<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RUNWAY FORM</title>
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
	</div><br><br>
	<div class="form-container">
		<h1>Runway Form</h1>
		<form action="saveData" method="post">
			
			<table>
				<tr>
					<th>Runway Length:</th>
					<td><input name="length" type="number" value=""
						placeholder="Runway Length" required></td>
				</tr>
				<tr>
					<th>Runway Width:</th>
					<td><input name="width" type="number" value=""
						placeholder="Runway Width" required></td>
				</tr>
				<tr>
					<th>Surface Type:</th>
					<td><input name="surfaceType" type="text" value=""
						placeholder="Surface Type" required></td>
				</tr>
				<tr>
					<th>Direction:</th>
					<td><input name="direction" type="text" value=""
						placeholder="Direction" required></td>
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form>
	</div>
	
	<h2 style="background-color: ${isValid ? 'green' : 'red'};">${responseMessage}</h2>
	
	<div class="search-form-getAll">
		<form action="getAllRunways">
			<button type="submit">GetAll</button>
		</form>
	</div><br>
	
	<table class="search-results-all" border="1">
	

		<tr>
			<th>Runway ID</th>
			<th>Length</th>
			<th>Width</th>
			<th>Surface Type</th>
			<th>Direction</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach var="runway" items="${runwayList}">
			<tr>
				<td>${runway.runwayID}</td>
				<td>${runway.length}</td>
				<td>${runway.width}</td>
				<td>${runway.surfaceType}</td>
				<td>${runway.direction}</td>
				<td><a href="editRunway/${runway.runwayID}">Edit</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteRunwayByID/${runway.runwayID}">Delete</a></td>
			</tr>
		</c:forEach>

	</table><br><br>
	<div class="footer">
		<h1>Footer Content</h1>
	</div>
</body>
</html>
