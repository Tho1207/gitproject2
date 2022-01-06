<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<link rel="stylesheet" href="css/login.css">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid text-center">
    	<p class="text-danger"><c:out value = "${sessionScope.error}"/></p>
    </div>
	<div class="container box h-100">
		  <div class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-xl-10 borderSpecial">
			  <div class="card rounded-3 text-black ">
				<div class="row g-3">
				  <div class="col-lg-6 ">
					<div class="card-body p-md-5 mx-md-4">
	  
					  <div class="text-center">
							<h1 class="mt-1 mb-3"><strong>Sign in</strong></h1>
					  </div>
	  
					  <form action="login" method="post" >
						<div class="form-outline mb-4 ">
						  <input type="text" name="username" class="form-control" placeholder="${cookie.user.value}"/>
						</div>
					  
						<div class="form-outline mb-4">
						  <input type="password" name="password" class="form-control" />
						</div>
					  
						<div class="text-center pt-1 mb-5">
						  <a class="text-muted text-decoration-none" href="#!">Forgot your password?</a><br><br>
						  <button type="submit" class="btnSpecial bg-danger text-white btn btn-outline-danger">Log In</button>
						</div>
					  
					  </form>
	  
					</div>
				  </div>
				  <div class="col-lg-6 d-flex align-items-center box-2">
					<div class="text-white p-5 text-center">
					  <h1 class="mb-4 ms-3"><strong>Welcome back!</strong></h1>
					  <h4 class="small mb-0 ms-3">To keep connected with us please login with your personal info</h4>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		</div>

</body>
</html>