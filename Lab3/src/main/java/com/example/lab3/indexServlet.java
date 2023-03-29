package com.example.lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "indexServlet", value = "/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        ArrayList<Student> students = DBManager.getStudent(id);
        PrintWriter out = response.getWriter();

        out.println("<h1>List</h1>");
        for (Student it:students){
            out.println("<h3>"+it.getName()+" "+it.getSurname()+" "+it.getAge()+" "+it.getYear()+"</h3>");
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
