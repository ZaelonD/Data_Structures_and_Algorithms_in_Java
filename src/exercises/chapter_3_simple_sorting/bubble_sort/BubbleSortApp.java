package exercises.chapter_3_simple_sorting.bubble_sort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 10; // array size
        ArrayBub arr, arr1; // reference to array
        arr = new ArrayBub(maxSize); // create the array
        arr1 = new ArrayBub(maxSize); // create the array
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr1.insert(n);
        }
        arr.display(); // display items
        System.out.println();
        arr1.display(); // display items
        System.out.println();
        arr.bubbleSort(); // bubble sort them
        arr.display(); // display items
        System.out.println();
        arr1.oddEvenSort();
        arr1.display(); // display items
    }
}