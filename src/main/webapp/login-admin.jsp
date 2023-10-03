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
		<form action="usercontrollerservlet" method="post">
			<h1>Admin</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" name="username" required
					id="username"> <i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Password" name="password"
					required id="password"> <i class='bx bxs-lock-alt'></i>
			</div>
			<pre>
			</pre>
			<a type="submit" href="register-admin.jsp" class="btn">Register</a> <br>
			<br> <input type="submit" name="_method" value="login"
				class="btn">
		</form>
	</div>
</body>
</html>