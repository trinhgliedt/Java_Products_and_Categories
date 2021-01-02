<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container col-8">
            <div class="row">
                <div class="col-6">
                    <div class="row my-2">
                        <h1><c:out value="${thisCategory.name}"></c:out></h1>
                    </div>
                    <div class="row my-2">
                        <h2 class="col-6">Products:</h2>
                    </div>
                    <div class="row my-2">
                        <ul>
                        	<c:forEach items="${thisCatsProducts}" var="product">
	                            <li><c:out value="${product.name}"></c:out></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-6">
                	<form action="/categories/${thisCategory.id}/addProduct" method="post">
	                    <div class="row my-2">
	                        <div class="col-6">Add Product:</div>
	                        <select name="product" id="product">
	                        	<c:forEach items="${productsForDropDown}" var="product">
		                            <option value="${product.id}"><c:out value="${product.name}"></c:out></option>
	                        	</c:forEach>
	                        </select>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <button type="submit" class="btn btn-primary">Add</button>
	                        </div>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <form:errors class="text-danger" path="*"></form:errors>
	                        </div>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>