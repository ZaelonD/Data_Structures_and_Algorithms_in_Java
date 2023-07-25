package exercises.chapter_2_arrays.order;

public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        OrdArray arr; // reference to array
        arr = new OrdArray(maxSize); // create the array
        long[] arr1 = new long[]{34, 12, 87}; // create the array
        for (int i = 0; i < 10; i++) {
            arr.insert((long) (Math.random() * 100));
        }
        arr.display(); // display items
        System.out.println();
        for (long l : arr1) {
            System.out.print(l + " ");
        }
        System.out.println();
        arr.merge(arr1);
        arr.display(); // display items again
    }
}