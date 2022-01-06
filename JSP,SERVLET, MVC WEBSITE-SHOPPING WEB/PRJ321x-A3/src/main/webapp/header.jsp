<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/user.css">
<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
<header>
		<div class="pt-4 bg-dark row">
			<div class="col-3">
				<a class="text-white text-center text-decoration-none" href="paging"><h1>PRJ321x</h1></a>
				<p class="text-center fs-6 text-primary">
					Welcome to my website
				</p>
			</div>
			<div class="col-9">
				<form action="search" method="post">
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
					<input name="s" value="${inputVal}"class="form-control" type="text" placeholder="What are you looking for?">
					<button class="searchBtn" type="submit"><i class="fas fa-search"></i></button>
				</div>
				</form>
			</div>
		</div>
	
		<div class="topnav row">
			<div class="col-3"></div>
			<div class="col-9">
				<a class="active" href="paging">Home</a>
				<a href="#">Products</a>
				<a href="#">About us</a>
				<div class="topnav-right pe-3">
					<a href="cart.jsp">Cart</a>
					<a href="login.jsp">Log in</a>
					<a href="register.jsp">Register</a>
				</div>
			</div>
		</div>


	</header>

</body>
</html>