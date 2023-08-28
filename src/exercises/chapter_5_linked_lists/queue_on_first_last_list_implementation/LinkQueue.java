package exercises.chapter_5_linked_lists.queue_on_first_last_list_implementation;

import exercises.chapter_5_linked_lists.first_last_list.FirstLastList;

public class LinkQueue {
    private final FirstLastList firstLastList;

    public LinkQueue() {
        firstLastList = new FirstLastList();
    }

    public void insert(long value) {
        firstLastList.insertLast(value);
    }

    public long remove() {
        return firstLastList.deleteFirst();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        firstLastList.displayList();
    }
}
