<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5"> a
        <div class="col-sm-6 offset-3">
            <form action="/Lab3_war_exploded/addStudent" method = "post">
                <div class="form-group">
                    <label>Name: </label>
                    <input type="text" name ="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>Surame: </label>
                    <input type="text" name ="surname" class="form-control">
                </div>
                <div class="form-group">
                    <label>Age: </label>
                    <input type="number" name ="age" class="form-control">
                </div>
                <div class="form-group">
                    <label>Year of admission: </label>
                    <input type="number" name ="year" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Add Student</button>
                </div>

            </form>
        </div>
    </div>
</div>



</body>
</html>