package com.mycompany.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bai02 {

    public static void main(String[] args) {
        StudentManager<Student> studentManager = new StudentManager<>();
        studentManager.add(new Student("BIT240123", "Nguyen Bao Lam", 1.5));
        studentManager.add(new Student("BIT240456", "Nguyen Long Nguyen", 3.0));
        studentManager.add(new Student("BIT240678", "Ngan Thai Thuong", 2.5));

        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                        return calculateAverageGpa(studentManager.getAll());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Luong bi ngat khi dang tinh GPA.", e);
                    }
                }, executor)
                .thenAccept(avg -> System.out.println("Diem trung binh GPA cua he thong la: " + avg))
                .exceptionally(ex -> {
                    System.out.println("Co loi xay ra khi tinh GPA: " + ex.getMessage());
                    return null;
                })
                .whenComplete((result, ex) -> executor.shutdown());

        System.out.println("He thong dang xu ly GPA bat dong bo...");
    }

    public static double calculateAverageGpa(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Danh sach sinh vien rong.");
        }

        double total = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student != null && student.getGpa() != null) {
                total += student.getGpa();
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("Khong co GPA de tinh!");
        }

        return total / count;
    }

    static class Student {

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

    static class StudentManager<T> {

        private final List<T> data = new ArrayList<>();

        public void add(T item) {
            data.add(item);
        }

        public List<T> getAll() {
            return data;
        }
    }
}
