<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.soccer.Team" %>
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
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>City</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList < Team> teams = (ArrayList<Team>) request.getAttribute("teamy");
                    if (teams !=null){
                        for(Team it:teams){
                %>
                <tr>
                    <td>
                        <%=it.getId()%>
                    </td>
                    <td>
                        <%=it.getName()%>
                    </td>
                    <td>
                        <%=it.getCountry()%>
                    </td>
                    <td>
                        <%=it.getCity()%>
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
