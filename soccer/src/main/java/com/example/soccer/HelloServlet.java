package com.example.soccer;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.soccer.dbManager.CrudOperations;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/home")
public class HelloServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Team> teams = CrudOperations.getAllTeam();
        request.setAttribute("teamy", teams);
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }

    public void destroy () {
    }
}