package exercises.chapter_3_simple_sorting.bubble_sort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 10; // array size
        ArrayBub arr; // reference to array
        arr = new ArrayBub(maxSize); // create the array
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
        arr.display(); // display items
        System.out.println();
        arr.bubbleSort(); // bubble sort them
        arr.display(); // Повторный вывод
    }
}