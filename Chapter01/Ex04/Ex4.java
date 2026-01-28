import java.util.ArrayList;

public class Ex4 {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Initial list: " + fruits);

        fruits.add(1, "Mango");
        System.out.println("> After adding Mango at index 1: " + fruits);

        int bananaIndex = fruits.indexOf("Banana");
        if (bananaIndex != -1) {
            fruits.set(bananaIndex, "Grapes");
        }
        System.out.println("> After replacing Banana with Grapes: " + fruits);

        boolean containsApple = fruits.contains("Apple");
        System.out.println("> Does the list contain 'Apple'? " + containsApple);
    }
}
