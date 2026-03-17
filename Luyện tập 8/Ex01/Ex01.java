package com.ex01;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class Ex01 {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    searchStudentByName();
                    break;
                case 4:
                    deleteStudentById();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
        System.out.println("1. Add new student");
        System.out.println("2. Show all students");
        System.out.println("3. Search student by name");
        System.out.println("4. Delete student by ID");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(sc.nextLine());

        students.add(new Student(id, name, gpa));
        System.out.println("Student added successfully!");
    }

    private static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("List of students:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudentByName() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    private static void deleteStudentById() {
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine();
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}
