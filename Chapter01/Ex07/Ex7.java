import java.util.TreeSet;

public class Ex7 {
    public static void main(String[] args) {

        TreeSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");

        System.out.println("TreeSet elements (sorted in alphabetical order):");
        System.out.println(names);
        System.out.println();

        String firstElement = names.first();
        System.out.println("First element (smallest): " + firstElement);

        String lastElement = names.last();
        System.out.println("Last element (largest): " + lastElement);

    }
}
