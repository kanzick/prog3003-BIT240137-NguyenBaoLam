import java.util.function.Supplier;
import java.util.function.Consumer;

public class Ex05 {
    public static void main(String[] args) {
        Supplier<Double> randomNumber = () -> Math.random() * 100;
        
        Consumer<Double> printLuckyNumber = num -> System.out.println("Số may mắn: " + String.format("%.1f", num));
        
        System.out.println("== 5 số may mắn ==");
        for (int i = 0; i < 5; i++) {
            Double luckyNum = randomNumber.get();
            printLuckyNumber.accept(luckyNum);
        }
    }
}
