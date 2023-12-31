package exercises.chapter_5_linked_lists.circular_linked_list;

public class CircularList {
    private Link current;

    public void insert(long data) {
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

    public Link find(long data) {
        if (!isEmpty()) {
            Link desiredLink = current.next;
            while (desiredLink.data != data) {
                if (desiredLink == current) {
                    return null;
                }
                desiredLink = desiredLink.next;
            }
            return desiredLink;
        }
        return null;
    }

    public Link remove(long data) {
        if (!isEmpty()) {
            Link cur = current.next, prev = current;
            while (cur.data != data) {
                if (cur == current) {
                    return null;
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return current == null;
    }
}
