public class Ex01 {
    public static void main(String[] args) {
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();

        WorkerRunnable workerRunnable = new WorkerRunnable();
        Thread thread = new Thread(workerRunnable);
        thread.start();
    }
}

class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy…");
    }
}

class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable đang chạy…");
    }
}
