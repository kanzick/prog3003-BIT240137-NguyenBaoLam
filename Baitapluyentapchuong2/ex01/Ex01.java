package com.mycompany.ex01;

import java.util.TreeSet;

public class Ex01 {

    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");

        System.out.println("Sorted name list: " + names);
        System.out.println("First element (smallest): " + names.first());
        System.out.println("Last element (largest): " + names.last());
    }
}
