package com.ex03;

class WorkerThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread đang chạy...");
    }
}

class WorkerRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable đang chạy...");
    }
}

public class Ex03 {

    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread();
        t1.start();

        Thread t2 = new Thread(new WorkerRunnable());
        t2.start();
    }
}
