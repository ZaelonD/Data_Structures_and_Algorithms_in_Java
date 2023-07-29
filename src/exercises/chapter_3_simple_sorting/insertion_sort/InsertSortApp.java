package exercises.chapter_3_simple_sorting.insertion_sort;

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 10; // array size
        ArrayIns arr; // reference to array
        arr = new ArrayIns(maxSize); // create the array
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
        arr.display(); // display items
        System.out.println();
        arr.insertionSort(); // insertion-sort them
        arr.display(); // display them again
        System.out.println("\nMedian: " + arr.median());
    }
}