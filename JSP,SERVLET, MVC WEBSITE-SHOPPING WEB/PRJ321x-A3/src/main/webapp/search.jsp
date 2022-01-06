<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
		<c:set var="num" value="0"/>
			<c:forEach var="o" items="${results}">
			 	<c:if test="${o!=null}"> <c:set var="num" value="1"/> </c:if>
				<div class="col-lg-3 col-md-6 pb-5">
					<div class="card-header position-relative overflow-hidden bg-transparent p-0">
                        <img class="img-fluid w-100" id = "card-img" src="${o.src}" alt="">
                    </div>
                    <div class="card-body text-center p-0 pt-4 pb-3">
                       	<h6 class="text-truncate text-light mb-3">CELLPHONE</h6>	
						<h6 class="text-truncate font-size-bold text-primary mb-3">${o.name}</h6>
                        <div class="d-flex justify-content-center">
                            <h6 class="text-danger">${o.price}</h6>
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-between bg-light">
                        <a href="description?id=${o.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                        <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                    </div>
				</div>
				<div class=" col-lg-1 d-md-none d-lg-block pb-5"></div>
			 </c:forEach>
			</div>
		</div> 
		
		<c:if test="${num == 0}"><div class="alert alert-danger" style="margin-bottom: 250px;" role="alert">No results found</div></c:if>
		<!-- Products End -->
		
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>