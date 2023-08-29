package exercises.chapter_5_linked_lists.list_insertion_sort;

import exercises.chapter_5_linked_lists.first_last_list.Link;

public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public SortedList(Link[] linkArr) {
        for (Link link : linkArr) {
            insert(link);
        }
    }

    public void insert(Link k) {
        if (!isEmpty()) {
            Link current = first;
            Link previous = null;
            while (current != null && current.dData < k.dData) {
                previous = current;
                current = current.next;
            }
            if (previous == null)
                first = k;
            else
                previous.next = k;
            k.next = current;
        } else {
            first = k;
        }

    }

    public boolean isEmpty() {
        return first == null;
    }
}
