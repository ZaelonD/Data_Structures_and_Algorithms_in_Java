package exercises.chapter_4_stacks_and_queues.queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5); // queue holds 5 items
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.display();
//        theQueue.remove(); // remove 3 items
//        theQueue.remove(); // (10, 20, 30)
//        theQueue.remove();
//        theQueue.insert(50); // insert 4 more items
//        theQueue.insert(60); // (wraps around)
//        theQueue.insert(70);
//        theQueue.insert(80);
//        while (!theQueue.isEmpty()) // remove and display
//        {
//            long n = theQueue.remove(); // (40, 50, 60, 70, 80)
//            System.out.print(n);
//            System.out.print(" ");
//        }
//        System.out.println();
    }
}
