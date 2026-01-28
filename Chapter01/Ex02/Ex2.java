public class Ex2 {
    static <E> void printArray(E[] array) {
        System.out.println("Array elements:");
        for (E element : array) {
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        System.out.println("-Integer Array-");
        printArray(intArray);

        String[] strArray = { "Java", "Python", "Rust", "Lua" };
        System.out.println("-String Array-");
        printArray(strArray);
    }
}
