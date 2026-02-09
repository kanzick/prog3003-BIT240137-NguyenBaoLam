import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex04 {
    public static void main(String[] args) {
        List<String> currencies = Arrays.asList("$10", "$20", "$50");

        Function<String, Integer> parseAmount = str -> Integer.parseInt(str.substring(1));

        List<Integer> amounts = currencies.stream()
                .map(parseAmount)
                .collect(Collectors.toList());

        System.out.println("Danh sách tiền tệ: " + currencies);
        System.out.println("Danh sách số nguyên: " + amounts);
    }
}
