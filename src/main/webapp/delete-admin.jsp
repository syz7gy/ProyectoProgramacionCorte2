<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Register</title>
</head>
<body>
	<h1>DELETE ADMIN</h1>
	<form action="usercontrollerservlet" method="post">
		Ingrese el id del admin que quiere eliminar: <br> <input
			type="text" name="deleteAdmin"> <br> <input
			type="submit" name="_method" value="Delete">

	</form>
</body>
</html>