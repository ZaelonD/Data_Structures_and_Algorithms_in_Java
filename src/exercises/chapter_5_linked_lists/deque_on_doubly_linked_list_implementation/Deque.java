package exercises.chapter_5_linked_lists.deque_on_doubly_linked_list_implementation;

import exercises.chapter_5_linked_lists.doubly_linked_list.DoublyLinkedList;

public class Deque {
    private final DoublyLinkedList list;

    public Deque() {
        this.list = new DoublyLinkedList();
    }

    public void insertLeft(long data) {
        list.insertFirst(data);
    }

    public void insertRight(long data) {
        list.insertLast(data);
    }

    public void removeLeft() {
        list.deleteFirst();
    }

    public void removeRight() {
        list.deleteLast();
    }

    public long peekFront() {
        return list.peekFirst();
    }

    public long peekRear() {
        return list.peekLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
