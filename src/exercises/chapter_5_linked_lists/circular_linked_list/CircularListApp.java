package exercises.chapter_5_linked_lists.circular_linked_list;

public class CircularListApp {
    public static void main(String[] args) {
        CircularList circularList = new CircularList();
        circularList.insert(10);
        circularList.insert(20);
        circularList.insert(30);
        circularList.insert(40);
        circularList.insert(50);
        circularList.insert(60);
        circularList.displayList();
        System.out.println(circularList.find(50));
        circularList.remove(10);
        circularList.displayList();
    }
}