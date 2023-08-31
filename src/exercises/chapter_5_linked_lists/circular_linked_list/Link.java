package exercises.chapter_5_linked_lists.circular_linked_list;

public class Link {
    public long data;
    public Link next;

    public Link(long data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
