package com.ex01;

import java.util.HashMap;

public class Ex01 {

    public static void main(String[] args) {
        HashMap<Integer, String> nhanVien = new HashMap<>();

        nhanVien.put(101, "Anna");
        nhanVien.put(102, "Peter");
        nhanVien.put(103, "Mary");

        String tenNV = nhanVien.get(102);
        System.out.println("Tên nhân viên có ID 102: " + tenNV);

        if (!nhanVien.containsKey(105)) {
            nhanVien.put(105, "Unknown");
            System.out.println("ID 105 chưa tồn tại, đã thêm: (105, Unknown)");
        }

        System.out.println("Danh sách nhân viên:");
        for (Integer id : nhanVien.keySet()) {
            System.out.println("ID: " + id + ", Tên: " + nhanVien.get(id));
        }
    }
}
