<%@page import="co.edu.unbosque.model.AdministrativoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.mapping.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Admin Register</title>
</head>

<body>
	<h1>REGISTER ADMIN</h1>
	<form action="usercontrollerservlet" method="post">

		<br> <br> Nombre: <br>
		<input type="text" name="textNom"> <br> Username: <br>
		<input type="text" name="userNameAd"> <br> cedula: <br>
		<input type="text" name="ced"> <br> Date of birth: <br>
		<input type="text" name="dateBirth"><br> Password: <br>
		<input type="text" name="con"> <br> <input type="submit"
			name="_method" value="Registrar Administrador"> <br> <input
			type="submit" name="_method" value="Mostrar">

	</form>

</body>
</html>