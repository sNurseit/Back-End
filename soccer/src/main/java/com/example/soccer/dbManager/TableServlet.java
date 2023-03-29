package com.example.soccer.dbManager;

import com.example.soccer.MatchTable;
import com.example.soccer.Matches;
import com.example.soccer.Team;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "TableServlet", value = "/TableServlet")
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MatchTable> matchTables = new ArrayList<>();
        ArrayList<Team> teams = CrudOperations.getAllTeam();
        System.out.println("TEAMS -------------------" +teams);
        for (Team team:teams) {
            ArrayList<Matches> matches = CrudOperations.getTablesInform(team.getId());
            System.out.println(" MATCHES ----------------- "+" TEAM ID = "+team.getId()+"--------------------------------"+matches);
            Long index = team.getId();
            String teamName = team.getName();
            int played = 0;
            int won = 0;
            int draw = 0;
            int lost = 0;
            int scored = 0;
            int missed= 0;


            for(Matches match:matches){
                played+=1;
                if (match.getHome_team_id() == index){
                    if (match.getHome_team_goals()>match.getAway_team_goals()){
                        won+=1;
                    }
                    else if (match.getHome_team_goals()<match.getAway_team_goals()){
                        lost+=1;
                    }
                    else {
                        draw+=1;
                    }
                    missed+=match.getAway_team_goals();
                    scored+=match.getHome_team_goals();
                }
                else if (match.getAway_team_id() == index){
                    if (match.getHome_team_goals()>match.getAway_team_goals()){
                        lost+=1;
                    }
                    else if (match.getHome_team_goals()<match.getAway_team_goals()){
                        won+=1;
                    }
                    else {
                        draw+=1;
                    }
                    scored+=match.getAway_team_goals();
                    missed+=match.getHome_team_goals();
                }
            }
            int points = (won*3)+draw;
            matchTables.add(new MatchTable(index,teamName,played,won,draw,lost,scored,missed,points));
        }
        Comparator<MatchTable> byPoints = Comparator.comparing(MatchTable::getPoints);
        Collections.sort(matchTables, byPoints.reversed());

        request.setAttribute("matchTably", matchTables);
        request.getRequestDispatcher("/table.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
