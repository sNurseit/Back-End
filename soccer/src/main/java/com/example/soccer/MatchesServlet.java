package com.example.soccer;

import com.example.soccer.dbManager.CrudOperations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MatchesServlet", value = "/MatchesServlet")
public class MatchesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MatchTable> matchTables = new ArrayList<>();
        ArrayList<Team> teams = CrudOperations.getAllTeam();
        System.out.println(teams);
        for (Team team:teams) {

            ArrayList<Matches> matches = CrudOperations.getTablesInform(team.getId());
            System.out.println(matches);
            Long index = team.getId();
            String teamName = team.getName();
            int played = 0;
            int won = 0;
            int draw = 0;
            int lost = 0;
            int scored = 0;
            int missed= 0;
            int points = 0;

            for(Matches match:matches){
                played+=1;
                if (match.getHome_team_id() == index){

                    if (match.getHome_team_goals()>match.getAway_team_goals()){
                        won+=1;
                        scored+=3;
                        missed+=2;
                    }
                    else if (match.getHome_team_goals()<match.getAway_team_goals()){
                        lost+=1;

                    }
                    else {
                        draw+=1;
                        scored+=1;
                        missed+=1;
                    }
                }
                else if (match.getAway_team_id() == index){

                    if (match.getHome_team_goals()>match.getAway_team_goals()){
                        lost+=1;
                    }
                    else if (match.getHome_team_goals()<match.getAway_team_goals()){
                        won+=1;
                        scored+=3;
                        missed+=2;
                    }
                    else {
                        draw+=1;
                        scored+=1;
                        missed+=1;
                    }
                }
            }
            matchTables.add(new MatchTable(index,teamName,played,won,draw,lost,scored,missed,points));

        }
        System.out.println(matchTables);

        request.setAttribute("matchTably", matchTables);
        request.getRequestDispatcher("/addMatches.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long homeTeamId = Long.parseLong(request.getParameter("home_team_id"));
        int homeTeamGoal = Integer.parseInt(request.getParameter("home_team_goals"));
        Long awayTeamId = Long.parseLong(request.getParameter("away_team_id"));
        int away_team_goals = Integer.parseInt(request.getParameter("away_team_goals"));
        if (awayTeamId!=homeTeamId) {
            Matches matches = new Matches(homeTeamId, awayTeamId, homeTeamGoal, away_team_goals);
            try {
                CrudOperations.addMatch(matches);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        request.getRequestDispatcher("/addMatches.jsp").forward(request,response);
    }
}
