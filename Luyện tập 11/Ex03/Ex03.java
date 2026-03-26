package com.ex03;

import java.util.*;
import java.util.stream.*;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class Ex03 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "An", 900),
                new Employee(2, "Binh", 1200),
                new Employee(3, "Cuong", 1500),
                new Employee(4, "Dung", 800)
        );

        List<String> names = employees.stream()
                .filter(e -> e.getSalary() > 1000)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
