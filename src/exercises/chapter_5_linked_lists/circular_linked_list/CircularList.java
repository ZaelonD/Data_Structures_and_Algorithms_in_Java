package exercises.chapter_5_linked_lists.circular_linked_list;

public class CircularList {
    private Link current;

    public void insert(int data) {
        Link newLink = new Link(data);
        if (!isEmpty()) {
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        } else {
            current = newLink;
            current.next = newLink;
        }
    }

    public void displayList() {
        System.out.println("first --> last");
        Link cur = current.next;
        while (cur != current) {
            cur.displayLink();
            cur = cur.next;
        }
        cur.displayLink();
        System.out.println();
    }

    public boolean isEmpty() {
        return current == null;
    }
}
