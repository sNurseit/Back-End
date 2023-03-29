package com.example.soccer;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.soccer.dbManager.CrudOperations;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddTeamServlet", value = "/addServlet")
public class AddTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String city = request.getParameter("city");

        Team teams = new Team(name,country,city);
        try {
            CrudOperations.addTeam(teams);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/soccer_war_exploded/addServlet?success");

    }
}
