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
        Link first = current.next;
        while (first != current) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data + " ");
        System.out.println();
    }

    public boolean isEmpty() {
        return current == null;
    }
}
