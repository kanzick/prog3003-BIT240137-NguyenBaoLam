class Test<T> {
    private T value;

    public void set(T t) {
        this.value = t;
    }

    public T get() {
        return value;
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Test<Integer> intTest = new Test<>();
        intTest.set(100);
        System.out.println("Integer value: " + intTest.get());

        Test<String> strTest = new Test<>();
        strTest.set("Generic");
        System.out.println("String value: " + strTest.get());
    }
}
