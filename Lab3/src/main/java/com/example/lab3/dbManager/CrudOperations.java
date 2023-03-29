package com.example.lab3.dbManager;

import com.example.lab3.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudOperations
{
    public static ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            Connection connection = DbConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.student");
            ResultSet resultSet = statement.executeQuery();// executeUpdate(add,update,delete)

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                int year = resultSet.getInt("year");
                students.add(new Student(id, name, surname, age, year));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void addStudent(Student student) throws SQLException, SQLException {
        PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                "INSERT INTO public.student \n" +
                "(name, surname, age, year) \n" +
                "VALUES (?, ?, ?, ?)");
        statement.setString(1, student.getName());
        statement.setString(2,student.getSurname());
        statement.setInt(3,student.getAge());
        statement.setInt(4,student.getYear());

        int rows = statement.executeUpdate();
        statement.close();
    }

    public static Student getStudent (Long id){
        Student student = null;
        try{
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "SELECT * FROM public.student where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();// executeUpdate(add,update,delete)

            if (resultSet.next()){
                Long id_student = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                int year = resultSet.getInt("year");
                student = new Student(id_student, name, surname, age, year);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public static  void updateStudent (Student student){
        try {
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "UPDATE public.student SET\n" +
                    "name = ?, surname = ?, age = ?, year = ? \n" +
                    "WHERE id = ?;");
            statement.setString(1, student.getName());
            statement.setString(2,student.getSurname());
            statement.setInt(3,student.getAge());
            statement.setDouble(4,student.getYear());
            statement.setLong(5,student.getId());

            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteStudent (Long id){
        try{
            PreparedStatement statement = DbConnect.getConnection().prepareStatement(""+
                    "delete from public.student \n" +
                    "where id = ?");
            statement.setLong(1, id);

            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Student> searchStudent(String column, String value) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = DbConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.student WHERE "+column+" = ?;");
            statement.setString(1, "%" + value + "%");
            System.out.println(column+" "+value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                int year = resultSet.getInt("year");
                students.add(new Student(id, name, surname, age, year));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
