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


}
