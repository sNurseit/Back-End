<%@ page import="com.example.lab3.Student" %><%--
  Created by IntelliJ IDEA.
  User: nurse
  Date: 28.02.2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>update</title>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container">
  <div class="row mt-5">
    <div class="col-sm-12">
      <%
        Student student = (Student) request.getAttribute("student");
        if(student!=null){
          System.out.println(student.getName());
      %>
          <h2>
            Update
          </h2>
          <form action="/Lab3_war_exploded/update" method = "post">
            <input value="<%=student.getId()%>" type="hidden" name = "id" >
            <div class="form-group">
              <label>Name: </label>
              <input value="<%=student.getName()%>" type="text" name ="name" class="form-control" >
            </div>
            <div class="form-group">
              <label>Surame: </label>
              <input value ="<%=student.getSurname()%>" type="text" name ="surname" class="form-control" >
            </div>
            <div class="form-group">
              <label>Age: </label>
              <input value="<%=student.getAge()%>" type="number" name ="age" class="form-control" >
            </div>
            <div class="form-group">
              <label>Year of admission: </label>
              <input value="<%= student.getYear()%>" type="number" name ="year" class="form-control" >
            </div>
            <div class="form-group">
              <button class="btn btn-success">Save Student</button>
            </div>

          </form>

      <%
        }
      %>
    </div>
  </div>
</div>
</body>
</html>
