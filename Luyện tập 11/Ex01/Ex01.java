package com.ex01;

public class Ex01 {

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);

        String[] strArray = {"Java", "NetBeans", "Generic", "Method"};
        printArray(strArray);
    }
}
