package com.example.soccer.dbManager;

import com.example.soccer.MatchTable;
import com.example.soccer.Matches;
import com.example.soccer.Team;

import java.sql.*;
import java.util.ArrayList;

public class CrudOperations
{
    public static ArrayList<Team> getAllTeam(){
        ArrayList<Team> teams = new ArrayList<>();
        try{
            Connection connection = DbConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.team");
            ResultSet resultSet = statement.executeQuery();// executeUpdate(add,update,delete)

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");

                teams.add(new Team(id, name, country, city));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return teams;
    }
    public static void addTeam(Team team) throws SQLException, SQLException {
        PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                "INSERT INTO public.team \n" +
                "(name, country, city) \n" +
                "VALUES (?, ?, ?)");
        statement.setString(1, team.getName());
        statement.setString(2,team.getCountry());
        statement.setString(3,team.getCity());
        int rows = statement.executeUpdate();
        statement.close();
    }

    public static Team getTeam (Long id){
        Team teams = null;
        try{
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "SELECT * FROM public.team where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();// executeUpdate(add,update,delete)

            if (resultSet.next()){
                Long team_id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                teams = new Team(team_id, name, country, city);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teams;
    }

    public static  void updateTeam (Team team){
        try {
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "UPDATE public.team SET\n" +
                    "name = ?, country = ?, city = ?, year = ? \n" +
                    "WHERE id = ?;");
            statement.setString(1, team.getName());
            statement.setString(2,team.getCountry());
            statement.setString(3,team.getCity());
            statement.setLong(4,team.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteTeam (Long id){
        try{
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "delete from public.team \n" +
                    "where id = ?");
            statement.setLong(1, id);

            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Matches> getTablesInform(Long index){
        String s = String.valueOf(index);
        System.out.println("INDEX IN CRUT IS ---------------------------"+ s);
        ArrayList<Matches> matches = new ArrayList<>();
        try{
            Connection connection = DbConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT m.id as id, t1.id as home_team_id, t2.id as away_team_id, m.home_team_goals, m.away_team_goals\n" +
                    "FROM Matches m\n" +
                    "JOIN Team t1 ON m.home_team_id = t1.id\n" +
                    "JOIN Team t2 ON m.away_team_id = t2.id\n" +
                    "WHERE t1.id = ? OR t2.id = ?;");
            statement.setLong(1, index);
            statement.setLong(2, index);
            ResultSet resultSet = statement.executeQuery();// executeUpdate(add,update,delete)
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                Long homeTeamId = resultSet.getLong("home_team_id");
                Long awayTeamId = resultSet.getLong("away_team_id");
                int homeTeamGoals = resultSet.getInt("home_team_goals");
                int awayTeamGoals = resultSet.getInt("away_team_goals");
                matches.add(new Matches(id,homeTeamId ,awayTeamId ,homeTeamGoals,awayTeamGoals));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return matches;
    }


    public static void addMatch(Matches matches) throws SQLException, SQLException {
        PreparedStatement statement = DbConnect.getConnection().prepareStatement("INSERT INTO public.matches (home_team_id, away_team_id, home_team_goals, away_team_goals)\n" +
                "    VALUES (?, ?, ?, ?);");
        statement.setLong(1, matches.getHome_team_id());
        statement.setLong(2,matches.getAway_team_id());
        statement.setInt(3,matches.getHome_team_goals());
        statement.setInt(4,matches.getAway_team_goals());
        int rows = statement.executeUpdate();
        statement.close();
    }

}
