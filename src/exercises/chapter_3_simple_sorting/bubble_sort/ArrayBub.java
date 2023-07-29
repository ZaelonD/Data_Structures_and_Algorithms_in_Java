package exercises.chapter_3_simple_sorting.bubble_sort;

public class ArrayBub {
    private final long[] a; // ref to array a
    private int nElems; // number of data items

    // constructor
    public ArrayBub(int max) {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    // put element into array
    public void insert(long value) {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    // displays array contents
    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
    }

    public void bubbleSort() {
        int right, left, in;
        for (right = nElems - 1, left = 0; right > left + 1; right--, left++) {
            for (in = 0; in < right; in++) // inner loop (forward)
                if (a[in] > a[in + 1]) // right of order?
                    swap(in, in + 1); // swap them
            for (in = right - 1; in > left; in--)
                if (a[in] < a[in - 1]) // left of order?
                    swap(in, in - 1); // swap them
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}