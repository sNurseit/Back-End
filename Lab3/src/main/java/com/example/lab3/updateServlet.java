package com.example.lab3;

import com.example.lab3.dbManager.CrudOperations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateServlet", value = "/update")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student students = CrudOperations.getStudent(id);

        if(students!=null){
            request.setAttribute("student",students);
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/404.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        int year = Integer.parseInt(request.getParameter("year"));
        Student student = CrudOperations.getStudent(id);

        if(student!=null){
            student.setName(name);
            student.setSurname(surname);
            student.setAge(age);
            student.setYear(year);
            CrudOperations.updateStudent(student);

            response.sendRedirect("/Lab3_war_exploded/update?id="+id+"&success");
        }
        else{
            response.sendRedirect("/");
        }
    }
}
