package com.mycompany.ex01;

import java.util.ArrayList;
import java.util.List;

public class Bai01 {

    public static void main(String[] args) {
        StudentManager<Student> studentManager = new StudentManager<>();

        studentManager.add(new Student("BIT240123", "Nguyen Bao Lam", 1.5));
        studentManager.add(new Student("BIT240456", "Nguyen Long Nguyen", 3.0));
        studentManager.add(new Student("BIT240678", "Ngan Thai Thuong", 2.5));

        for (Student student : studentManager.getAll()) {
            System.out.println(student);
        }
    }
}

class Student {

    private String id;
    private String name;
    private Double gpa;

    public Student(String id, String name, Double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', gpa=" + gpa + "}";
    }
}

class StudentManager<T> {

    private final List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public List<T> getAll() {
        return data;
    }
}
