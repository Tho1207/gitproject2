<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="login.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post">
  <div class="imgcontainer">
    <img src="data:image/jpeg;base64,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" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
   <div class="container" style="background-color:#f1f1f1">
    	<button type="button" class="cancelbtn">Cancel</button>
   		 <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
  
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>