
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" />
<link rel="stylesheet" href="style/stylesAdmin.css">

<title>Services</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand"><h1>Services</h1></a> <a class="navbar-brand"><h6>Anonymous
					alcoholics</h6></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">
						Services</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Clients</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Log out</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>


	<br>
	<br>
	<br>
	<br>
	<div class="wrapper">
		<h1>What do you wish to do?</h1>
		<br> <br> <br> <br>

		<h2>Edit your info:</h2>
		<div class="second-wrapper-s" id="wrapper-service">
			<div id="services-list" class="div-list">
				<br> <br>
				<div class="wrapper-crud"></div>
				<br> <br>
			</div>
		</div>
		<h2>Clients:</h2>
		<br>
		<div class="second-wrapper" id="wrapper-alcoholic">
			<div class="handle-alcoholics"></div>
			<div class="div-crud">
				<div class="crud-alcoholic-wrapper">
					<h3>Handle clients:</h3>
					<form action="#" id="crud">
						<input type="text" id="name" placeholder="Name" /> <input
							type="text" id="nickname" placeholder="Nickname" /> <input
							type="text" id="document" placeholder="Document" /> <label
							for="quantity">Number of sessions attended:</label> <input
							type="number" id="quantity" name="quantity" min="0" max="1000">
						<label> Enter your birthdate: <input type="date"
							name="bdate" value="2023-10-01" />
						</label> <input type="text" id="birth-place" placeholder="Birth place" />
						<button type="submit" id="addbtn">Add</button>
					</form>
				</div>

				<div class="div-list">
					<h5>Clients list</h5>
					<div class="wrapper-crud"></div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>