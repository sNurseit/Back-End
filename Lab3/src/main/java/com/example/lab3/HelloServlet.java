package com.example.lab3;

import java.io.*;
import java.util.ArrayList;

import com.example.lab3.dbManager.CrudOperations;
import com.example.lab3.dbManager.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/home")
public class HelloServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Student> students = CrudOperations.getAllStudents();
        request.setAttribute("studenty", students);
        request.getRequestDispatcher("/home.jsp").forward(request,response);

    }

    public void destroy () {
    }
}
