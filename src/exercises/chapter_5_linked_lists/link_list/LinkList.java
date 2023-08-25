package exercises.chapter_5_linked_lists.link_list;

public class LinkList {
    private Link first;

    public void insertFirst(int Data, double dData) {
        Link newLink = new Link(Data, dData);
        newLink.next = first;
        first = newLink;
    }


    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
