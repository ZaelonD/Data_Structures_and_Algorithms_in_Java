package exercises.chapter_5_linked_lists.stack_on_link_list_implementation;

public class LinkStack {
    private final LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(long value) {
        linkList.insertFirst(value);
    }

    public long pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        linkList.displayList();
    }
}
