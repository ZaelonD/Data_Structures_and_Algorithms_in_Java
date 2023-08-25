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

    public Link find(int key) {
        Link current = first;
        if (!isEmpty())
            while (current.iData != key) {
                if (current.next == null)
                    return null;
                else
                    current = current.next;
            }
        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
