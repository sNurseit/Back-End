package com.example.lab3;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private int year;

    public Student(){

    }
    public Student(Long id, String name, String surname, int age, int year) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.year = year;
    }

    public Student(String name, String surname, int age, int year) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", year=" + year +
                '}';
    }
}
