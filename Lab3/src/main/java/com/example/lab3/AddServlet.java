package com.example.lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/index.jsp").forward(request,response);
//
//        Student student = new Student();
//        if(student!=null){
//            request.setAttribute("students",student);
//            request.getRequestDispatcher("/index.jsp").forward(request,response);
//            DBManager.addStudent(student);
//        }
//
//        String name=request.getParameter("user_name");
//        String surname=request.getParameter("user_surname");
//        int age=Integer.parseInt(request.getParameter("user_age"));
//        int gpa=Integer.parseInt(request.getParameter("user_gpa"));
//
//
//        student.setName(name);
//        student.setSurname(surname);
//        student.setAge(age);
//        student.setGpa(gpa);
//
//
//
//        response.sendRedirect("/Lab3_war_exploded/index");

    }
}
