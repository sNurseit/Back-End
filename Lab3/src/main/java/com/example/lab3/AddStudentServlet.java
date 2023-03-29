package com.example.lab3;

import com.example.lab3.dbManager.CrudOperations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddStudentServlet", value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        int year = Integer.parseInt(request.getParameter("year"));

        Student students = new Student(name,surname,age,year);
        try {
            CrudOperations.addStudent(students);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/Lab3_war_exploded/addStudent?success");
    }
}
