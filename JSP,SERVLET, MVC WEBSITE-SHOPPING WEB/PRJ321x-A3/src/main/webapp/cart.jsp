<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<script src="https://kit.fontawesome.com/44d72dc3b3.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
<section class="h-100" style="background-color: #eee;">
  <div class="container h-100 py-5">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-10">

        
        <div class="d-flex justify-content-between align-items-center mb-4">
          <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
          <div>
            <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">price <i
                  class="fas fa-angle-down mt-1"></i></a></p>
          </div>
        </div>
        
        
        <c:set var="total" value="0"></c:set>
        
		<c:forEach var="item" items="${sessionScope.cart.items}">
			<c:set var="total" value="${total + item.price * item.number }"></c:set>
        	<div class="card rounded-3 mb-4">
        		<div class="card-body p-4">
            		<div class="row d-flex justify-content-between align-items-center">
              			<div class="col-md-2 col-lg-2 col-xl-2">
                				<img src="${item.src}" class="img-fluid rounded-3" alt="${item.name}">
              			</div>
              			<div class="col-md-3 col-lg-3 col-xl-3">
                				<p class="lead fw-normal mb-2">${item.name}</p>
             			 </div>
              			<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
              					<a href="addToCart?action=delete&id=${item.id}">
               						 <button class="btn btn-link px-2"
                  						onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                  						<i class="fas fa-minus"></i>
                					</button>
								</a>
								
                				<input id="form1" min="0" name="quantity" value="${item.number}" type="number" class="form-control form-control-sm" />
				
								<a href="addToCart?action=add&id=${item.id}">
                						<button class="btn btn-link px-2"
                 						 	onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                 						 	<i class="fas fa-plus"></i>
               							 </button>
                				</a>
              			</div>
              			
              			
              			<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                				<h5 class="mb-0">${item.price}</h5>
              			</div>
              			<div class="col-md-1 col-lg-1 col-xl-1 text-end">
                				<a href="addToCart?action=delete&id=${item.id}" class="text-danger"><i class="fas fa-trash fa-lg"></i></a>
              			</div>
              			
            </div>
          </div>
          
        </div> 
	 </c:forEach>  
	 </div>
          </div>
          
        </div>
       
   
       <div class="container card mb-4">
       		<div class="card-body p-4 d-flex flex-row">
       			<form action="updateInfo" method="post">
  				<div class=" row">
    				<div class="mb-4 col-12">
    					<lable>Address</lable>
      					<input type="text" class="flex-fill form-control form-control-lg" placeholder="Enter address" value="${sessionScope.address}" name="address">
    				</div>
    				<lable>Phone</lable>
    				<div class="col-12">
     				 	<input type="text" class="flex-fill form-control form-control-lg" placeholder="Enter phone" value="${sessionScope.phone}" name="phone">
    				</div>
  				</div>
  			<div class="mt-4">
  				<button type="submit" class="btn btn-warning">Submit</button>
  			</div>
   			
			</form>
          
			</div>
        </div>
       

        <div class="container card mb-4">
          <div class="card-body p-4 d-flex flex-row">
            <div class="form-outline flex-fill">
              <input type="text" id="form1" class="form-control form-control-lg" />
              <label class="form-label" for="form1">Discount code</label>
            </div>
            <button type="button" class="btn btn-outline-warning btn-lg ms-3">Apply</button>
          </div>
        </div>
        
        <div class="container card">
          <div class="card-body">
           	<h1>Total price: <fmt:formatNumber type="number" maxIntegerDigits="3" value="${total}" /></h1>
          </div>
        </div>

        <div class="container card">
          <div class="card-body row">
           	<div class="col-6">
           		<a href="insertToDS">
            	<button type="button" class="me-5 btn btn-warning btn-block btn-lg">Buy</button>
          		</a>
           	</div>
           	<div class="col-6">
           		<a href="paging">
            	<button type="button" class="btn btn-warning btn-block btn-lg">Coninue Shopping</button>
          		</a>
           	</div>
          	
          	
          </div>
        </div>

      
</section>

</body>
</html>