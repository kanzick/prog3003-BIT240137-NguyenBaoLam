import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Ex03 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> Arrays.asList(1, 2, 5, 3, 100))
            .thenApply(list -> list.stream()
                .filter(x -> x % 2 != 0)
                .sorted()
                .collect(Collectors.toList()))
            .thenApply(filtered -> "Kết quả là: " + filtered.toString())
            .thenAccept(System.out::println)
            .join();
    }
}
