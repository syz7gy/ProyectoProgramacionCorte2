<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Register</title>
</head>

<body>
	Update:
	<br> Ingrese id de administrador que desea cambiar:
	<form action="usercontrollerservlet" method="post">

		ID: <input type="text" name="chageIdAd"> <br> <br>
		Nombre: <br> <input type="text" name="textNom"> <br>
		Username: <br> <input type="text" name="userNameAd"> <br>
		Date of birth: <br> <input type="text" name="dateBirth">
		<br> cedula: <br> <input type="text" name="ced"> <br>
		Password: <br> <input type="text" name="con"> <br> <br>
		<input type="submit" name="_method" value="Modificar">
	</form>
</body>
</html>