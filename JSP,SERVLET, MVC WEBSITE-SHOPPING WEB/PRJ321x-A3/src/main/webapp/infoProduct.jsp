<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<link rel="stylesheet" href="css/info.css">
<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Information</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 <div class="container-fluid pb-1 pt-2">
        <p class="title ms-3">${product.name}</p>
    </div>
    <hr>
    
    <div class="container-fluid py-5">
        <div class="row">
            <div class="col-md-6 pb-5">
                <img class="w-100 h-100 ms-3" src="${product.src }" alt="Image">
            </div>
            <div class="col-md-3 pb-5">
                <h1 class="ms-3 font-weight-bold mb-4 text-danger">${product.price}</h1>
                <p class="ms-3 mb-4">
                ${product.description }
                </p>
                <a href="addToCart?action=add&id=${product.id}">
                <button style="background-color:#E25715;"class="ms-3 px-3 text-white btn btn-add"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
           		</a>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>