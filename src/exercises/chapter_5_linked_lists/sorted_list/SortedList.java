package exercises.chapter_5_linked_lists.sorted_list;

import exercises.chapter_5_linked_lists.first_last_list.Link;

public class SortedList {
    private Link first;

    public void insert(long key) {
        if (!isEmpty()) {
            Link newLink = new Link(key);
            Link current = first;
            Link previous = null;
            while (current != null && key > current.dData) {
                previous = current;
                current = current.next;
            }
            if (previous == null)
                first = newLink;
            else
                previous.next = newLink;
            newLink.next = current;
        } else {
            first = new Link(key);
        }
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public long peek() {
        return first.dData;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
