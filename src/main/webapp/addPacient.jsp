<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Adaugare Pacient</title>
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
			<h2>Adaugare Pacient</h2>
			<form role="form" action="addPacient" method="POST">
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
						<div class="form-group">
							<label for="pwd">CNP:</label> <input type="text"
								class="form-control" name="cnp" placeholder="Enter CNP" required>
						</div>
						<div class="form-group">
							<label for="pwd">Data Nastere:</label> <input type="text"
								class="form-control" name="datanastere"
								placeholder="Enter data nastere">
						</div>
					</div>
					<div class="col-sm-9 col-md-6">
						<div class="form-group">
							<label for="pwd">Adresa:</label> <input type="text"
								class="form-control" name="adresa" placeholder="Enter adresa">
						</div>
						<div class="form-group">
							<label for="pwd">Ocupatie:</label> <input type="text"
								class="form-control" name="ocupatie"
								placeholder="Enter ocupatie">
						</div>
						<div class="form-group">
							<label for="pwd">Telefon:</label> <input type="text"
								class="form-control" name="telefon" placeholder="Enter telefon">
						</div>
						<div class="form-group">
							<label for="pwd">Email:</label> <input type="text"
								class="form-control" name="email" placeholder="Enter email">
						</div>
					</div>
					<button type="submit" class="btn btn-default">Salveaza</button>
				</div>
			</form>
		</div>
	</div>

	<div class="container">
		<h2>Diagnostic: select</h2>
		<form role="form" action="addPacient" method="POST">
			<div class="form-group">
				<label for="sel1">Select nume (select one):</label> <select
					class="form-control" name="sel1">
					<c:forEach var="diagnostic" items="${listDiagnostic}">
						<option><c:out value="${diagnostic.nume}" /></option>
					</c:forEach>
				</select>
				<label for="sel1">Select descriere: (select one):</label> <select
					class="form-control" name="sel1">
					<c:forEach var="diagnostic" items="${listDiagnostic}">
						<option><c:out value="${diagnostic.descriere}" /></option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>


	<div class="container">
		<h2>Plan tratament:</h2>
		<form role="form" action="addPacient" method="POST">
			<div class="form-group">
				<label for="comment">Comment:</label>
				<textarea class="form-control" rows="5" id="comment"></textarea>
			</div>
		</form>
	</div>

	<div class="container">
		<h2>Tratament:</h2>
		<form role="form" action="addPacient" method="POST">
			<div class="form-group">
				<label for="sel1">Select act terapeutic (select one):</label> <select
					class="form-control" id="sel1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select> <br> <label for="sel2">Mutiple select list (hold shift
					to select more than one):</label> <select multiple class="form-control"
					id="sel2">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
		</form>
	</div>
	<div class="container">
		<h2>Medic:</h2>
		<form role="form" action="addPacient" method="POST">
			<div class="form-group">
				<label for="sel1">Select medic (select one):</label> <select
					class="form-control" id="sel1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
		</form>
	</div>
</body>
</html>