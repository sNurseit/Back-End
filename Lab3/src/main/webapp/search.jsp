<%@ page import="com.example.lab3.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nurse
  Date: 06.03.2023
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
  <div class="container">
    <div class="row mt-5">

      <div class="col-sm-12">
        <table class="table">
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <th>Year of admission</th>
            <th>Details</th>
          </tr>
          </thead>
          <tbody>
          <%
            ArrayList < Student> students = (ArrayList<Student>) request.getAttribute("studenty");
            if (students !=null){
              for(Student it:students){
          %>
          <tr>
            <td>
              <%=it.getId()%>
            </td>
            <td>
              <%=it.getName()%>
            </td>
            <td>
              <%=it.getSurname()%>
            </td>
            <td>
              <%=it.getAge()%>
            </td>
            <td>
              <%=it.getYear()%>
            </td>
            <td>
              <a href = "/Lab3_war_exploded/details?id=<%=it.getId()%>" class="btn btn-info btn-sm">Details</a>
              <a href = "/Lab3_war_exploded/delete?id=<%=it.getId()%>" class="btn btn-info btn-sm">Delete</a>

            </td>
          </tr>


          <%
              }
            }
          %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>
