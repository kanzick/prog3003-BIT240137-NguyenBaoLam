import java.util.function.Predicate;

public class Ex03 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("Kiểm tra số chẵn:");
        for (int num : numbers) {
            System.out.println(num + " là số " + (isEven.test(num) ? "chẵn" : "lẻ"));
        }
    }
}
