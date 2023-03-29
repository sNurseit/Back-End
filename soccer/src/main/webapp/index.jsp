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
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <h1 class="text-center">ADD TEAM</h1>
            <form action="/soccer_war_exploded/addServlet" method="post">

                <div class="form-group mt-2">
                    <label>Name: </label>
                    <input type="text" name="name" class="form-control">
                </div>

                <div class="form-group mt-2">
                    <label>Country: </label>
                    <input type="text" name="country" class="form-control">
                </div>

                <div class="form-group mt-2">
                    <label>City: </label>
                    <input type="text" name="city" class="form-control">
                </div>

                <div class="form-group mt-2">
                    <button class="btn btn-success mt-2">ADD</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>