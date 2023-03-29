<%@ page import="com.example.soccer.Team" %>
<%@ page import="com.example.soccer.dbManager.CrudOperations" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.soccer.Matches" %>
<%@ page import="com.example.soccer.MatchTable" %><%--
  Created by IntelliJ IDEA.
  User: nurse
  Date: 07.03.2023
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>

<div class="container">
  <div class="row mt-5">
    <div class="col-sm-6 offset-3">
      <h1 class="text-center">MATCHES</h1>

      <form action="/soccer_war_exploded/MatchesServlet" method="post">
        <div class="row g-2 mt-4">
          <div class="col-md">
            <div class="form-floating">
              <select class="form-select" name="home_team_id">
                <%
                  ArrayList<Team> teams = CrudOperations.getAllTeam();
                  if(teams!=null){
                    for(Team u : teams){
                %>
                <option value="<%=u.getId()%>">
                  <%=u.getName()%>
                </option>
                <%
                    }
                  }
                %>
              </select>
              <label>Home team</label>
            </div>
          </div>
          <div class="col-md">
            <div class="form-floating">
              <input type="text" class="form-control" name="home_team_goals">
              <label>Goals</label>
            </div>
          </div>
        </div>

        <div class="row g-2 mt-2">
          <div class="col-md">
            <div class="form-floating">
              <select class="form-select" name="away_team_id">
                <%
                  ArrayList<Team> teams2 = CrudOperations.getAllTeam();
                  if(teams2!=null){
                    for(Team u : teams2){
                %>
                <option value="<%=u.getId()%>">
                  <%=u.getName()%>
                </option>
                <%
                    }
                  }
                %>
              </select>
              <label>Away team</label>
            </div>
          </div>
          <div class="col-md">
            <div class="form-floating">
              <input type="text" class="form-control" name="away_team_goals">
              <label>Goals</label>
            </div>
          </div>
        </div>

        <button class="btn btn-success mt-2">Calculate</button>

      </form>
    </div>
  </div>
</div>



</body>
</html>
