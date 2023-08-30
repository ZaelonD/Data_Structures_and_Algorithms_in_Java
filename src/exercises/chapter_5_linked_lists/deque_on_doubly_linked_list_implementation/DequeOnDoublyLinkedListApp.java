package exercises.chapter_5_linked_lists.deque_on_doubly_linked_list_implementation;

public class DequeOnDoublyLinkedListApp {
    public static void main(String[] args) {
        Deque dequeue = new Deque();

        dequeue.insertLeft(10);
        dequeue.insertRight(20);
        dequeue.insertLeft(30);
        dequeue.insertRight(40);
        dequeue.insertLeft(50);
        dequeue.insertRight(60);
        dequeue.insertLeft(70);
        dequeue.insertRight(80);
        dequeue.insertLeft(90);
        dequeue.insertRight(100);

        while (!dequeue.isEmpty()) {
            System.out.print(dequeue.peekFront() + "\t");
            dequeue.removeLeft();
        }
    }
}
