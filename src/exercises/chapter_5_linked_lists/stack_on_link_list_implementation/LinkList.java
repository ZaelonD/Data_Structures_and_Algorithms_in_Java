package exercises.chapter_5_linked_lists.stack_on_link_list_implementation;

public class LinkList {
    private Link first;

    public void insertFirst(long dData) {
        Link newLink = new Link(dData);
        newLink.next = first;
        first = newLink;
    }

    public long deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return first == null;
    }
}