interface Pair<K, V> {
    K getKey();

    V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

public class Ex3 {
    public static void main(String[] args) {

        Pair<String, Integer> pair1 = new OrderedPair<>("MSSV", 10170);
        System.out.println("Pair 1 - Key: " + pair1.getKey() + ", Value: " + pair1.getValue());

        Pair<String, String> pair2 = new OrderedPair<>("HoTen", "Nguyen Thi Hoa");
        System.out.println("Pair 2 - Key: " + pair2.getKey() + ", Value: " + pair2.getValue());
    }
}
