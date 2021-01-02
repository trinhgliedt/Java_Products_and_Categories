<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
            <div class="row">
                <div class="col-6">
                    <div class="row my-2">
                        <h1>New Product</h1>
                    </div>
                    <form:form action="/products/new" method="post" modelAttribute="product">
	                    <div class="row my-2">
	                        <div class="col-6">Name:</div>
	                        <form:input path="name" type="text" class="col-6"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">Description</div>
	                        <form:textarea path="description" class="col-6"></form:textarea>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">Price</div>
	                        <form:input path="price" type="text" class="col-6"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <button type="submit" class="btn btn-primary">Create</button>
	                        </div>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-3">
	                            <form:errors class="text-danger" path="*"></form:errors>
	                        </div>
	                    </div>
                    </form:form>
                </div>
            </div>
        </div>
</body>
</html>