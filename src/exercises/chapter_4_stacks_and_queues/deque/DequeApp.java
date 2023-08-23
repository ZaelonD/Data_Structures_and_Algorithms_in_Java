package exercises.chapter_4_stacks_and_queues.deque;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(1);
        deque.insertLeft(0);
        deque.removeLeft();
        deque.insertLeft(5);
        deque.insertLeft(6);
        deque.removeLeft();
        deque.insertLeft(4);

        while (!deque.isEmpty()) {
            System.out.print(deque.peekFront() + "\t");
            deque.removeLeft();
        }
    }
}
