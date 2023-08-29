package exercises.chapter_5_linked_lists.doubly_linked_list;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public void insertFirst(long data) {
        if (!isEmpty()) {
            Link newLink = new Link(data);
            first.previous = newLink;
            newLink.next = first;
            first = newLink;
        } else
            first = last = new Link(data);
    }

    public void insertLast(long data) {
        if (!isEmpty()) {
            Link newLink = new Link(data);
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        } else
            first = last = new Link(data);
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
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
