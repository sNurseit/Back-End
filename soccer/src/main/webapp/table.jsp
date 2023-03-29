<%@ page import="com.example.soccer.MatchTable" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nurse
  Date: 11.03.2023
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/head.jsp"%>
    <title>Table</title>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5">

        <div class="col-sm-12">
            <table class="table">
                <thead>
                <tr>
                    <th>place</th>
                    <th>Team</th>
                    <th>Played</th>
                    <th>Won</th>
                    <th>Draw</th>
                    <th>Lost</th>
                    <th>Scorred</th>
                    <th>Missed</th>
                    <th>Points</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<MatchTable> matches = (ArrayList<MatchTable>) request.getAttribute("matchTably");
                    int index = 1;
                    if (matches !=null){
                        for(MatchTable it:matches){
                %>
                <tr>
                    <td>
                        <%=index%>
                    </td>
                    <td>
                        <%=it.getTeam()%>
                    </td>
                    <td>
                        <%=it.getPlayed()%>
                    </td>
                    <td>
                        <%=it.getWon()%>
                    </td>
                    <td>
                        <%=it.getDraw()%>
                    </td>
                    <td>
                        <%=it.getLost()%>
                    </td>
                    <td>
                        <%=it.getScored()%>
                    </td>
                    <td>
                        <%=it.getMissed()%>
                    </td>
                    <td>
                        <%=it.getPoints()%>
                    </td>
                </tr>


                <%
                            index++;
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
