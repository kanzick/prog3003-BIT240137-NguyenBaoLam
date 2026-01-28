import java.util.HashMap;

public class Ex8 {
    public static void main(String[] args) {

        HashMap<Integer, String> employees = new HashMap<>();

        employees.put(101, "Anna");
        employees.put(102, "Peter");
        employees.put(103, "Mary");

        System.out.println("Initial employee list:");
        System.out.println(employees);
        System.out.println();

        String nameOfId102 = employees.get(102);
        System.out.println("Employee with ID 102: " + nameOfId102);
        System.out.println();

        if (employees.containsKey(105)) {
            System.out.println("ID 105 already exists: " + employees.get(105));
        } else {
            System.out.println("ID 105 does not exist. Adding (105, 'Unknown')...");
            employees.put(105, "Unknown");
        }

        System.out.println();
        System.out.println("Final employee list:");
        System.out.println(employees);
    }
}
