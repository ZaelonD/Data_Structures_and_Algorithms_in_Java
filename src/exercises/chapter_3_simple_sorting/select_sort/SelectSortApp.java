package exercises.chapter_3_simple_sorting.select_sort;

public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArraySel arr; // reference to array
        arr = new ArraySel(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        System.out.println();
        arr.selectionSort(); // selection-sort them
        arr.display(); // display them again
    }
}
