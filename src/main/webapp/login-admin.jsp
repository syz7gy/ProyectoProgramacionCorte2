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
			<h1>Admin Log in</h1>
			<div class="input-box">
				<input id="username-client"type="text" placeholder="Username" required id="username">
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input id="password-client"  type="password" placeholder="Password" required id="password">
				<i class='bx bxs-lock-alt'></i>
			</div>
			<pre>
			</pre>
			<button type="submit" class="btn">Login</button>
		</form>
		<br>
		<button class="btn"
			onclick="document.getElementById('id01').style.display='block'">Sign
			Up</button>
		
		<div id="id01" class="modal">
			<form class="modal-content" action="/action_page.php">
				<div class="container">
					<h1>Sign Up</h1>
					<p>Please fill in this form to create an account.</p>
					<hr>
					<div class="input-box">
						<label for="Name"><b>Name</b></label> <input type="text"
							placeholder="Enter name" name="name" required>
					</div>
					
					<div class="input-box">
						<label for="psw"><b>Document</b></label> <input type="password"
							placeholder="Enter Document" name="psw" required>
					</div>
					<div class="input-box">
						<label for="username"><b>Username</b></label> <input type="text"
							placeholder="Enter username" name="username" required>
					</div>
					<div class="input-box">
						<label for="psw"><b>Password</b></label> <input type="password"
							placeholder="Enter password" name="psw" required>
					</div>
	
					<div class="clearfix">
						<button type="submit" class="btn">Sign Up</button>
						<br> <br> 
						<button type="button"
							onclick="document.getElementById('id01').style.display='none'"
							class="cancelbtn">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>