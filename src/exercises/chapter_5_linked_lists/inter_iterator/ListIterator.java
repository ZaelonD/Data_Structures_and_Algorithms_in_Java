package exercises.chapter_5_linked_lists.inter_iterator;

import exercises.chapter_5_linked_lists.first_last_list.Link;

public class ListIterator {
    private Link current;
    private Link previous;
    private LinkList list;

    public ListIterator(LinkList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long data) {
        Link newLink = new Link(data);
        if (!list.isEmpty()) {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        } else {
            list.setFirst(newLink);
            current = newLink;
        }
    }

    public void insertBefore(long data) {
        Link newLink = new Link(data);
        if (!list.isEmpty()) {
            if (previous != null) {
                previous.next = newLink;
                newLink.next = previous.next;
                current = newLink;
            } else {
                newLink.next = list.getFirst();
                list.setFirst(newLink);
                reset();
            }
        }
    }

    public long deleteCurrent() {
        long temp = current.dData;
        if (!list.isEmpty()) {
            if (previous != null) {
                previous.next = current.next;
                if (atEnd())
                    reset();
                else
                    current = current.next;
            } else {
                list.setFirst(current.next);
                reset();
            }
        } else
            System.err.println("Can't remove\nList is empty!");
        return temp;
    }

    public boolean atEnd() {
        return current.next == null;
    }
}
