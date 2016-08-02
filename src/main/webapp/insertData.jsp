<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Insert Data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<%@include file="/home.jsp"%>


	<div class="container">
		<div class="jumbotron">
			<h2>Adauga Diagnostic</h2>
			<form role="form" action="insertData" method="POST">
				<div class="row">
					<div class="col-sm-3 col-md-6">
						<div class="form-group">
							<label for="email">Diagnostic:</label> <input type="text"
								class="form-control" name="diagnostic" placeholder="Enter diagnostic"
								required>
						</div>
						<div class="form-group">
							<label for="prenume">Descriere:</label> <input type="text"
								class="form-control" name="descriere" placeholder="Enter descriere"
								required>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-default">Salveaza</button>
			</form>
		</div>
	</div>
	
	<div class="container">
		<div class="jumbotron">
			<h2>Adauga Act Terapeutic</h2>
			<form role="form" action="insertData" method="POST">
				<div class="row">
					<div class="col-sm-3 col-md-6">
						<div class="form-group">
							<label for="email">Act terapeutic:</label> <input type="text"
								class="form-control" name="actT" placeholder="Enter act"
								required>
						</div>
						<div class="form-group">
							<label for="prenume">Descriere:</label> <input type="text"
								class="form-control" name="descriereA" placeholder="Enter descriere"
								required>
						</div>
					</div>
					
				</div>
				<button type="submit" class="btn btn-default">Salveaza</button>
			</form>
		</div>
	</div>
	
	<div class="container">
		<div class="jumbotron">
			<h2>Adauga Medic</h2>
			<form role="form" action="insertData" method="POST">
				<div class="row">
					<div class="col-sm-3 col-md-6">
						<div class="form-group">
							<label for="email">Nume:</label> <input type="text"
								class="form-control" name="nume" placeholder="Enter nume"
								required>
						</div>
						<div class="form-group">
							<label for="prenume">Prenume:</label> <input type="text"
								class="form-control" name="prenume" placeholder="Enter prenume"
								required>
						</div>
					</div>
					
				</div>
				<button type="submit" class="btn btn-default">Salveaza</button>
			</form>
		</div>
	</div>
	

</body>
</html>