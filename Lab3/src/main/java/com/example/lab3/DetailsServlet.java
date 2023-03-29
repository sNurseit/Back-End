package com.example.lab3;

import com.example.lab3.dbManager.CrudOperations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DetailsServlet", value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Student students = CrudOperations.getStudent(id);

        if(students!=null){
            request.setAttribute("student",students);
            request.getRequestDispatcher("/details.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
