package exercises.chapter_4_stacks_and_queues.queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5); // queue holds 5 items
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.display();
    }
}
