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
        if (!isEmpty()) {
            System.out.print("List (first-->last): ");
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
        } else
            System.err.println("No items to display\nList is empty!");
        System.out.println();
    }

    public void displayBackward() {
        if (!isEmpty()) {
            System.out.print("List (last-->first): ");
            Link current = last;
            while (current != null) {
                current.displayLink();
                current = current.previous;
            }
        } else
            System.out.println("No items to display\nList is empty!");
        System.out.println();
    }

    public Link deleteFirst() {
        Link temp = first;
        if (!isEmpty()) {
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first.next.previous = null;
                first = first.next;
            }
        } else
            System.err.println("Can't remove\nList is empty!");
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
