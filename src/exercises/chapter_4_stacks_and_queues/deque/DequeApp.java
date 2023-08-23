package exercises.chapter_4_stacks_and_queues.deque;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertRight(5);
        deque.removeRight();
        deque.insertRight(6);

        while (!deque.isEmpty()) {
            System.out.print(deque.peekFront() + "\t");
            deque.removeLeft();
        }
    }
}
