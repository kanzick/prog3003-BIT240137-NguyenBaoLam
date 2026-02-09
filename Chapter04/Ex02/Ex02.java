import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Hanoi", "Ho Chi Minh", "Da Nang", "Hue");
        
        System.out.println("Danh sách trước khi sắp xếp:");
        System.out.println(cities);
        
        Collections.sort(cities, (a, b) -> Integer.compare(a.length(), b.length()));
        
        System.out.println("\nDanh sách sau khi sắp xếp (theo độ dài, từ ngắn đến dài):");
        System.out.println(cities);
        
        System.out.println("\nChi tiết:");
        for (String city : cities) {
            System.out.println(city + " - " + city.length() + " ký tự");
        }
    }
}
