import java.util.HashSet;

public class Ex6 {
    public static void main(String[] args) {

        int[] array = { 5, 2, 9, 2, 5, 8, 1 };

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int num : array) {
            uniqueNumbers.add(num);
        }

        System.out.println("\nUnique elements from HashSet:");
        System.out.println(uniqueNumbers);

        /*
         * Giải thích: HashSet không giữ thứ tự của các phần tử.
         * HashSet sử dụng hash function để lưu trữ phần tử, vì vậy thứ tự
         * in ra phụ thuộc vào giá trị hash của mỗi phần tử, không phải
         * thứ tự ban đầu trong mảng. Điều này khác với ArrayList
         * hoặc LinkedHashSet (cái sau sẽ giữ thứ tự chèn).
         * Ưu điểm của HashSet là tốc độ tìm kiếm nhanh nhưng mất mát
         * thứ tự của phần tử.
         */
    }
}
