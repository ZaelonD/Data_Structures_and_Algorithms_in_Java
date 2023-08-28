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

    public boolean isEmpty() {
        return first == null;
    }
}
