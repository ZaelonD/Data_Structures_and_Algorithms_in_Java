package exercises.chapter_5_linked_lists.queue_on_first_last_list_implementation;

import exercises.chapter_5_linked_lists.priority_queue_on_sorted_list_implementation.PriorityQueue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(20);
        priorityQueue.insert(80);
        priorityQueue.insert(40);
        priorityQueue.remove();
        priorityQueue.insert(30);
        priorityQueue.insert(10);
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.peek() + "\t");
            priorityQueue.remove();
        }
    }
}
