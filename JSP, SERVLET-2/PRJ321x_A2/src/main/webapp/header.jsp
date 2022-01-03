<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/mystyle.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
	<div class="pt-4 bg-dark row">
		<div class="col-3">
			<a class="text-white text-center text-decoration-none" href="#"><h1>PRJ1</h1></a>
			<p class="text-center fs-6 text-primary">
				Welcome to my website
			</p>
		</div>
		<div class="col-9">
			<div class="input-group mt-3 mb-3 pb-5 pe-5">
				<div class="dropdown dropdown-menu-end">
					<button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
					    Categories
					</button>
					<ul class="dropdown-menu">
					  <li><a class="dropdown-item" href="#">Link 1</a></li>
					  <li><a class="dropdown-item" href="#">Link 2</a></li>
					  <li><a class="dropdown-item" href="#">Link 3</a></li>
					</ul>
				</div>
				<input class="form-control" type="text" placeholder="What are you looking for?...">
				<button class="searchBtn" type="submit">Go</button>
			</div>
		</div>
	</div>
	
	<div class="topnav row">
		<div class="col-3"></div>
		<div class="col-9">
			<a class="active" href="#">Home</a>
			<a href="#">Products</a>
			<a href="#">About us</a>
			<div class="topnav-right pe-5">
				<a href="login.jsp">Log in</a>
			</div>
		</div>
	</div>
 </header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>