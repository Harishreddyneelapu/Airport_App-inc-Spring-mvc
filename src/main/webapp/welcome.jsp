<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airport Form</title>
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

.search-form {
	background-color: #cce6ff;
	border: 1px solid #ddd;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	text-align: center;
}

table.search-results {
	border-collapse: collapse;
	width: 60%;
	border: 1px solid #ddd;
	margin-bottom: 10px;
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
		<a href="taxi.jsp">TAXI</a>&emsp;&emsp;&emsp;&emsp; <a href="runway.jsp">RUNWAY</a>
	</div>
	<br>
	<br>

	<div class="form-container">
		<h1>AIRPORT FORM</h1>
		<form action="getDataFromHtml" method="post">
			<table>
				<tr>
					<th>Airport Name:</th>
					<td><input name="airportName" type="text" value=""
						placeholder="Airport Name" required></td>
				</tr>
				<tr>
					<th>Airport Location:</th>
					<td><input name="airportLocation" type="text" value=""
						placeholder="Airport Location" required></td>
				</tr>
				<tr>
					<th>No Of Planes:</th>
					<td><input name="noOfPlanes" type="number" value=""
						placeholder="No Of Planes" required></td>
				</tr>
				<tr>
					<th>No Of RunWays:</th>
					<td><input name="noOfRunways" type="number" value=""
						placeholder="No Of Runways" required></td>
				</tr>
			</table>
			<br>
			<button type="submit">Submit</button>
		</form>
	</div>
	<h2 style="background-color: ${isValid ? 'green' : 'red'};">${responseMessage}</h2>

	<div class="search-form">
		<form action="searchAirport">
			<table>
				<tr>
					<th>Search Airport Details:</th>
					<td><input name="airportID" type="number"
						placeholder="Airport ID" required></td>
				</tr>
			</table>
			<button type="submit">SearchByID</button>
		</form>
	</div>
	<table class="search-results">
		<tr>
			<td><h3>${ID}</h3></td>
			<td><h3>${AirportName}</h3></td>
			<td><h3>${AirportLocation}</h3></td>
			<td><h3>${NO_OF_Planes}</h3></td>
			<td><h3>${NO_OF_Runways}</h3></td>
		</tr>
	</table>

	<div class="search-form">
		<form action="searchAirportByName">
			<table>
				<tr>
					<th>Search AirportByName:</th>
					<td><input name="airportName" type="text"
						placeholder="Airport Name" required></td>
				</tr>
			</table>
			<button type="submit">SearchByName</button>
		</form>
	</div>
	<br>

	<div class="search-form">
		<form action="deleteByID">
			<table>
				<tr>
					<th>Delete By ID:</th>
					<td><input name="airportID" type="number"
						placeholder="Airport ID" required></td>
				</tr>
			</table>
			<button type="submit">DeleteByID</button>
		</form>
	</div>
	<br>

	<div class="search-form">
		<form action="deleteByName">
			<table>
				<tr>
					<th>Delete By Name:</th>
					<td><input name="airportName" type="text"
						placeholder="Airport Name" required></td>
				</tr>
			</table>
			<button type="submit">DeleteByName</button>
		</form>
	</div>
	<br>
	<div class="search-form">
		<form action="updateByID">
			<table>
				<tr>
					<th>Update by ID:</th>
					<td><input name="airportID" type="number"
						placeholder="Airport ID" required></td>
				</tr>
				<tr>
					<th>Airport Name:</th>
					<td><input name="airportName" type="text" value=""
						placeholder="Airport Name" required></td>
				</tr>
				<tr>
					<th>Airport Location:</th>
					<td><input name="airportLocation" type="text" value=""
						placeholder="Airport Location" required></td>
				</tr>
				<tr>
					<th>No Of Planes:</th>
					<td><input name="noOfPlanes" type="number" value=""
						placeholder="No Of Planes" required></td>
				</tr>
				<tr>
					<th>No Of RunWays:</th>
					<td><input name="noOfRunways" type="number" value=""
						placeholder="No Of Runways" required></td>
				</tr>
			</table>
			<button type="submit">UpdateByID</button>
		</form>
	</div>
	<br>
	<div class="search-form">
		<form action="updateByName">
			<table>
				<tr>
					<th>Update by Name:</th>
					<td><input name="airportName" type="text"
						placeholder="Airport Name" required></td>
				</tr>
				<tr>
					<th>Airport Location:</th>
					<td><input name="airportLocation" type="text" value=""
						placeholder="Airport Location" required></td>
				</tr>
				<tr>
					<th>No Of Planes:</th>
					<td><input name="noOfPlanes" type="number" value=""
						placeholder="No Of Planes" required></td>
				</tr>
				<tr>
					<th>No Of RunWays:</th>
					<td><input name="noOfRunways" type="number" value=""
						placeholder="No Of Runways" required></td>
				</tr>
			</table>
			<button type="submit">UpdateByName</button>
		</form>
	</div>
	<br>
	<div class="search-form-getAll">
		<form action="getAll">
			<button type="submit">GetAll</button>
		</form>
	</div>
	<br>


	<table class="search-results-all" border="1">

		<tr>
			<th>Airport ID</th>
			<th>Airport Name</th>
			<th>Airport Location</th>
			<th>No. of Planes</th>
			<th>No. of RunWays</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach var="airport" items="${airportList}">
			<tr>
				<td>${airport.airportID}</td>
				<td>${airport.airportName}</td>
				<td>${airport.airportLocation}</td>
				<td>${airport.noOfPlanes}</td>
				<td>${airport.noOfRunways}</td>
				<td><a href="editAirport/${airport.airportID}">Edit</a></td>
				<td><a
					href="${pageContext.request.contextPath}/deleteByID/${airport.airportID}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<br>

	<div class="footer">
		<h1>Footer Content</h1>
	</div>
</body>
</html>


