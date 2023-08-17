package exercises.chapter_4_stacks_and_queues.deque;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(1);
        deque.insertLeft(0);
        deque.insertLeft(0);

        while (!deque.isEmpty()) {
            deque.removeLeft();
        }
//        deque.insertRight(3);
//        deque.insertRight(4);
    }
}
