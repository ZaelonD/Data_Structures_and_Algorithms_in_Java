package exercises.chapter_5_linked_lists.priority_queue_on_sorted_list_implementation;

import exercises.chapter_5_linked_lists.first_last_list.Link;
import exercises.chapter_5_linked_lists.sorted_list.SortedList;

public class PriorityQueue {
    private final SortedList list;

    public PriorityQueue() {
        this.list = new SortedList();
    }

    public void insert(long data) {
        list.insert(data);
    }

    public Link remove() {
        return list.remove();
    }

    public long peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
