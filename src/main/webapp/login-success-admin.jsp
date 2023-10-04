
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

<title>Admin</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand"><h1>Admin</h1></a> <a class="navbar-brand"><h6>
					Anonymous alcoholics</h6></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">
						Admin</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#wrapper-alcoholic">Clients</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#wrapper-psychologist">Psychologists</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#wrapper-service">Services</a></li>
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
		<h2>Clients:</h2>
		<br>
		<div class="second-wrapper" id="wrapper-alcoholic">
			<div class="handle-alcoholics"></div>
			<div class="div-crud">
				<div class="crud-alcoholic-wrapper">
					<h3>Handle clients:</h3>
					<form action="admincontrollerservlet" method="post">
						<input type="text" id="id" placeholder="ID" name="idCli">
						<input type="text" id="name" placeholder="Name" name="nameCli">
						<input type="text" id="nickname" placeholder="Username" name="usernameCli"> 
						<input type="text" id="document" placeholder="Document" name="documentCli"> 
						<input type="text" id="birth-place" placeholder="Birth place" name="bdateCli">
						<input type="text" id="apodo" placeholder="Apodo" name="apodo">
						<input type="text" id="sesion" placeholder="sesion" name="nSesiones">
						<input type="text" id="password" placeholder="Password" name="passwordCli"> 
						
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="AgregarClient">Add</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="ActualizarClient">Update</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="MostrarClientes">Show</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="EliminarClint">Delete</button>
					</form>
				</div>

				<div class="div-list">
					<h5>Clients list</h5>
					<div class="wrapper-crud"></div>

				</div>
			</div>
		</div>

		<br> <br> <br> <br> <br> <br> <br>
		<br>

		<h2>Psychologist:</h2>
		<br>
		<div class="second-wrapper-p" id="wrapper-psychologist">
			<div class="handle-psychologist"></div>
			<div class="div-crud-p">
				<div class="crud-psychologist-wrapper">
					<h3>Handle psychologists:</h3>
						<form action="admincontrollerservlet" method="post">
						<input type="text" id="id" placeholder="ID" name="idPsy">
						<input type="text" id="name" placeholder="Name" name="namePsy">
						<input type="text" id="nickname" placeholder="Username" name="usernamePsy"> 
						<input type="text" id="document" placeholder="Document" name="documentPsy"> 
						<input type="text" id="birth-place" placeholder="Birth place" name="bdatePsy">
						<input type="text" id="graduate" placeholder="Date Graduation" name="dateGra">
						<input type="text" id="sesion" placeholder="Sesion" name="sesionesApo">
						<input type="text" id="dServicio" placeholder="Days of Service" name="dServicio">
						<input type="text" id="salario" placeholder="Salario" name="salarioPsy">
						<input type="text" id="password" placeholder="Password" name="passwordPsy"> 
						
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="AgregarPsy">Add</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="ActualizarPsy">Update</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="MostrarPsy">Show</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="EliminarPsy">Delete</button>
					</form>
				</div>

				<div class="div-list">
					<h5>Clients list</h5>
					<div class="wrapper-crud"></div>

				</div>
			</div>
		</div>

		<br> <br>
		<h2>Service people:</h2>
		<br>
		<div class="second-wrapper-s" id="wrapper-service">
			<div class="handle-service"></div>
			<div class="div-crud-s">
				<div class="crud-service-wrapper">
					<h3>Handle clients:</h3>
					<form action="admincontrollerservlet" method="post">
					<input type="text" id="id" placeholder="ID" name="idSer">
						<input type="text" id="name" placeholder="Name" name="nameSer">
						<input type="text" id="nickname" placeholder="Username" name="usernameSer"> 
						<input type="text" id="document" placeholder="Document" name="documentSer"> 
						<input type="text" id="birth-place" placeholder="Birth place" name="bdateSer">
						<input type="text" id="salario" placeholder="Salario" name="salarioSer">
						<input type="text" id="sesion" placeholder="sesion" name="nSesionesSer">
						<input type="text" id="password" placeholder="Password" name="passwordSer">  
						
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="AgregarSer">Add</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="ActualizarSer">Update</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="MostrarSer">Show</button>
						<button type="submit" id="addbtn" name="_methodAdmin"
							value="EliminarSer">Delete</button>
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