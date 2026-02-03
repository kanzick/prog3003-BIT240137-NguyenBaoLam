import java.util.concurrent.CompletableFuture;

public class Ex04 {
    public static void main(String[] args) {
        CompletableFuture<Void> checkAvailability = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Kiểm tra tính khả dụng của sản phẩm hoàn thành.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> payment = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1500);
                System.out.println("Thanh toán hoàn thành.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> shipping = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Vận chuyển đơn hàng hoàn thành.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(checkAvailability, payment, shipping);
        allTasks.thenRun(() -> System.out.println("Tất cả tác vụ xử lý đơn hàng đã hoàn thành.")).join();
    }
}
