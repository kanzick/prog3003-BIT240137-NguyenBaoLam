import java.util.TreeMap;

public class Ex9 {
    public static void main(String[] args) {

        TreeMap<String, Double> products = new TreeMap<>();

        products.put("Laptop", 1500.0);
        products.put("Mouse", 25.0);
        products.put("Keyboard", 50.0);

        System.out.println("All products (sorted alphabetically by name):");
        for (String productName : products.keySet()) {
            System.out.println(productName + ": $" + products.get(productName));
        }
        System.out.println();

        TreeMap<String, Double> productsInRange = (TreeMap<String, Double>) products.subMap("K", "N");

        System.out.println("Products with names from K to M (using subMap):");
        for (String productName : productsInRange.keySet()) {
            System.out.println(productName + ": $" + productsInRange.get(productName));
        }
    }
}
