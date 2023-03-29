package com.example.lab3;

import com.example.lab3.dbManager.CrudOperations;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "searchServlet", value = "/search")
public class searchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("mySelect");
        String input = request.getParameter("search");

        ArrayList<Student> students = CrudOperations.getAllStudents();
        ArrayList<Student> array = new ArrayList<Student>();
        for(int i=0; i<students.size(); i++){
            if (students.get(i)!=null){
                if(search.equals("name")){
                    if(input.equals(students.get(i).getName())){
                        array.add(students.get(i));
                    }
                }
                else if(search.equals("surname")){
                    if(input.equals(students.get(i).getSurname())){
                        array.add(students.get(i));
                    }
                }
                else if(search.equals("age")){
                    if(Integer.parseInt(input) == students.get(i).getAge()){
                        array.add(students.get(i));
                    }
                }
                else if(search.equals("year")){
                    if(Integer.parseInt(input) == students.get(i).getYear()){
                        array.add(students.get(i));
                    }
                }
            }
        }


        System.out.println(students.size());
        request.setAttribute("studenty", array);
        request.getRequestDispatcher("/search.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
