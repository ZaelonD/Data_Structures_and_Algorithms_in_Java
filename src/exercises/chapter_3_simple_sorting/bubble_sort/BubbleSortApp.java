package exercises.chapter_3_simple_sorting.bubble_sort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayBub arr; // reference to array
        arr = new ArrayBub(maxSize); // create the array
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
        arr.bubbleSort(); // bubble sort them
        arr.display(); // Повторный вывод
    }
}