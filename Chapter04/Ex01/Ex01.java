@FunctionalInterface
interface MathOperation {
    int compute(int a, int b);
}

public class Ex01 {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (a, b) -> a * b;

        MathOperation division = (a, b) -> a / b;

        int a = 20;
        int b = 10;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Phép Cộng: " + a + " + " + b + " = " + addition.compute(a, b));
        System.out.println("Phép Trừ: " + a + " - " + b + " = " + subtraction.compute(a, b));
        System.out.println("Phép Nhân: " + a + " * " + b + " = " + multiplication.compute(a, b));
        System.out.println("Phép Chia: " + a + " / " + b + " = " + division.compute(a, b));
    }
}
