import java.util.LinkedList;

public class Ex5 {
    public static void main(String[] args) {

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("1.After adding 10, 20, 30: " + queue);

        queue.addFirst(5);
        System.out.println("2.After adding 5 at the beginning: " + queue);

        queue.addLast(40);
        System.out.println("3.After adding 40 at the end: " + queue);

        int removedFirst = queue.removeFirst();
        System.out.println("4.Removed first element: " + removedFirst);
        System.out.println("5.After removing first element: " + queue);

        int removedLast = queue.removeLast();
        System.out.println("6.Removed last element: " + removedLast);
        System.out.println("7.Remaining list: " + queue);
    }
}
