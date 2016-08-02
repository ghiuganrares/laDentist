<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Cauta Pacient</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<%@include file="/home.jsp" %>
	
	<form action="search" method="get" class="sidebar-form">
		<div class="container">
			<div class="jumbotron">
				<div class="col-sm-3">
					<div class="input-group">
						<input type="search" name="search" class="form-control input-xs"
							placeholder="Search..."> <span class="input-group-btn">
							
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
							
								<span class="glyphicon glyphicon-search"></span>
	
								</button>
							
					</div>
				</div>
			</div>
		</div>
	</form>



	<div class="container">
		<div class="jumbotron">
			<table class="table">
				<thead>
					<tr>
						<th>Nume</th>
						<th>Prenume</th>
						<th>CNP</th>
						<th>Data Nastere</th>
						<th>Adresa</th>
						<th>Ocupatia</th>
						<th>Telefon</th>
						<th>Email</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<c:forEach var="pacient" items="${listaPacienti}">
							<tr>
								<td><a href="fisaPacient"><c:out value="${pacient.nume}" /></a></td>
								<td><c:out value="${pacient.prenume}" /></td>
								<td><c:out value="${pacient.cnp}" /></td>
								<td><c:out value="${pacient.dataNastere}" /></td>
								<td><c:out value="${pacient.adresa}" /></td>
								<td><c:out value="${pacient.ocupatia}" /></td>
								<td><c:out value="${pacient.telefon}" /></td>
								<td><c:out value="${pacient.email}" /></td>
							</tr>
						</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>