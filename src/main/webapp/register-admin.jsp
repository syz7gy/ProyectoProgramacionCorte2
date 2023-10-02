<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="style/stylesadminlogin.css">

<title>Admin Register</title>
</head>

<body>
	<h1>REGISTER ADMIN</h1>
	<form action="usercontrollerservlet" method="post">
	
		<br> <br> Nombre: <br> <br> <input type="text"
			name="textNom"> <br> cedula: <br> <input
			type="text" name="ced"> <br> contraseña: <br> <input
			type="text" name="con"> <br> <input
			type="submit" name="_method" value="Registrar Administrador"> <br>
			<input type="submit" name="_method" value="Modificar">
	</form>
</body>
</html>