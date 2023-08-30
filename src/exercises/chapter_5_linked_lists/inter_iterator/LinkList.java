package exercises.chapter_5_linked_lists.inter_iterator;

import exercises.chapter_5_linked_lists.first_last_list.Link;

public class LinkList {
    private Link first;

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        if (!isEmpty()) {
            Link current = first;
            System.out.print("List (first-->last): ");
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
        } else
            System.err.println("No items to display\nList is empty!");
        System.out.println();
    }
}