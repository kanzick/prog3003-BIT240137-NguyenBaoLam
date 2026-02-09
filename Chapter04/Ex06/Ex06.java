import java.util.*;

public class Ex06 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        int result = numbers.stream()
                           .filter(n -> n % 2 == 0)
                           .map(n -> n * n)
                           .mapToInt(Integer::intValue)
                           .sum();
        
        System.out.println("Danh sách: " + numbers);
        System.out.println("Các số chẵn: 2, 4, 6");
        System.out.println("Bình phương: 2²=4, 4²=16, 6²=36");
        System.out.println("Tổng: " + result);
    }
}
