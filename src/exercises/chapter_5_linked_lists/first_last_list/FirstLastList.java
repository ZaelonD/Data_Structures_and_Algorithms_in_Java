package exercises.chapter_5_linked_lists.first_last_list;

public class FirstLastList {
    private Link first;
    private Link last;

    public void insertFirst(long dData) {
        Link newLink = new Link(dData);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
