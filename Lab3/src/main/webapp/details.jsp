<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab3.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
    <div class="container">
        <div class="row mt-5">
            <div class="col-sm-12">
                <%
                    Student student = (Student) request.getAttribute("student");
                    if(student!=null){


                %>
                <div class="card" style="width: 18rem;">
                    <img src="https://b.fssta.com/uploads/application/soccer/headshots/885.vresize.350.350.medium.14.png" class="card-img-top" alt="..." style="width:280px; height:280px; ">
                    <div class="card-body">
                        <h5 class="card-title"><%=student.getName() + " " + student.getSurname()%></h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">AGE: <%=student.getAge()%></li>
                        <li class="list-group-item">Year of admission: <%=student.getYear()%></li>
                        <li class="list-group-item">
                            <a href="/Lab3_war_exploded/update?id=<%=student.getId()%>" class="btn btn-info btn-sm">EDIT </a>
                        </li>
                    </ul>

                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>
