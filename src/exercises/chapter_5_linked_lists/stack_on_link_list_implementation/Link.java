package exercises.chapter_5_linked_lists.stack_on_link_list_implementation;

public class Link {
    public long dData;
    public Link next;

    public Link(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
