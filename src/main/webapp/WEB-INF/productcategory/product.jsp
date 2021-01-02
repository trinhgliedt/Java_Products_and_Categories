<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                        <h1><c:out value="${thisProduct.name}"></c:out></h1>
                    </div>
                    <div class="row my-2">
                        <h2 class="col-6">Categories:</h2>
                    </div>
                    <div class="row my-2">
                        <ul>
                        	<c:forEach items="${thisProdsCats}" var="category">
                            	<li><c:out value="${category.name}"></c:out></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-6">
                	<form action="/product/${thisProduct.id}/addToCategory" method="post">
	                    <div class="row my-2">
	                        <div class="col-6">Add Category:</div>
	                        <select name="category" name="category" id="category">
	                        	<c:forEach items="${categoriesForDropDown}" var="category">
	                            	<option value="${category.id}"><c:out value="${category.name}"></c:out></option>
	                            </c:forEach>
	                        </select>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <button type="submit" class="btn btn-primary">Add</button>
	                        </div>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>