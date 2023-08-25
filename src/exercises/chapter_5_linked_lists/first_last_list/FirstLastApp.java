package exercises.chapter_5_linked_lists.first_last_list;

public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList(); // display the list
        theList.deleteFirst(); // delete the first two items
        theList.deleteFirst();
        theList.displayList(); // display again
    }
}
