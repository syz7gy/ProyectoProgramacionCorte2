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
<link rel="stylesheet" href="style/styles.css">
<title>Sign up as</title>
</head>
<body>
	<div class="wrapper">
		<form action="usercontrollerservlet" method="post">
			<h1>Welcome to anonymous alcoholics, what do you wish to sign
				as?</h1>

			<br> <br>
			<a id="admin" href="login-admin.jsp" class="btn">Admin</a>
			<br> <br>
			<a id="client" href="login-client.jsp" class="btn">Client</a>
			<br> <br>
			<a id="psychologist" href="login-psychologist.jsp" class="btn">Psychologist</a>
			<br> <br>
			<a id="services" href="login-services.jsp" class="btn">Services</a>
			<br> <br>
		</form>
	</div>
</body>
</html>