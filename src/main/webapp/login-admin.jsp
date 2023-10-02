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


<title>Admin login</title>
</head>
<body>
	<div class="wrapper">
		<form action="">
			<h1>Admin</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" required id="username">
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Password" required id="password">
				<i class='bx bxs-lock-alt'></i>
			</div>
			<pre>
			</pre>
			<a id="registeAdmin" href="register-admin.jsp">Register</a>
			<br>
			<button type="submit" href="show-admin.jsp" name="_method" value="Login" class="btn">Login</button>
		</form>
	</div>
</body>
</html>