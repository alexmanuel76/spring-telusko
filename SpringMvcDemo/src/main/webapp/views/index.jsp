<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Generico</title>
</head>
<body>
	welcome to the Jungle!!
	<br>
	<form action="addAlien" method="post">
		Agrege su ID: <input type="text" name="aid"><br>
		Ingrese su nombre: <input type="text" name="aname"><br> <input
			type="submit">
	</form>
	<br>
	<hr width="60%" color="red">
	<br>
	<form action="findAlienByName" method="get">
		Ingrese su nombre: <input type="text" name="aname"><br>
		<input type="submit">
	</form>
	<hr width="60%" color="blue">
	<br>
	<form action="findAlienByNameQ" method="get">
		Ingrese su nombre: <input type="text" name="aname"><br>
		<input type="submit">
	</form>
</body>
</html>