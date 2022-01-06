<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/admin.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body id="body" onload="welcome()">
<div id="mySidenav" class="sidenav">
	<a href="#" class="headName text-center">1849 TEAM</a>
	<hr>
	<div class="row" id="test">
		<div class="col-2"><i class="fas fa-th-large"></i></div>
		<div class="col-9"><a href="#" class="fields">Dashboard</a></div>
	</div>
	<div class="row " id="test">
		<div class="col-2"><i class="fas fa-users"></i></div>
		<div class="col-9"><a href="#" class="fields">Staff Manager</a></div>
	</div> 
	<div class="row " id="test">
		<div class="col-2"><i class="fas fa-sign-out-alt"></i></div>
		<div class="col-9"><a href="../logout" class="fields"> Log Out </a></div>
	</div>
</div>
<div id="main">
  <img src="../picture/1.jpg" alt="pic">
  <button id="open" onclick="openNav()"> open</button>
  <button id="close" style="display: none" onclick="closeNav()">close</button>

</div>

<table id="myTable" class="w-75 table table-dark text-center">
	<thead>
		<tr>
			<td colspan="4" id="first">Members of the team </td>
		</tr>

	</thead>
	<tbody>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Student ID</th>
			<th>Class</th>
		  </tr>
	  <tr>
		<td>1</td>
		<td>Member 1</td>
		<td>Member Code 1</td>
		<td>Class 1</td>
	  </tr>
	  <tr>
		<td>2</td>
		<td>Member 2</td>
		<td>Member Code 2</td>
		<td>Class 2</td>
	  </tr>
	</tbody>
  </table>


<script>
function welcome() {
	var name = '${sessionScope.user}';
	alert("Welcome " + name.split('@')[0]);
}
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
  document.getElementById("myTable").style.marginLeft = "250px";
  document.getElementById("open").style.display="none";
  document.getElementById("close").style.display="block";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
  document.getElementById("myTable").style.marginLeft = "0";
  document.getElementById("open").style.display="block";
  document.getElementById("close").style.display="none";
  
}





</script>
   


</body>
</html>