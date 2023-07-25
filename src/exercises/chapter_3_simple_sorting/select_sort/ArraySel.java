package exercises.chapter_3_simple_sorting.select_sort;

public class ArraySel {
    private final long[] a; // ref to array a
    private int nElems; // number of data items

    // constructor
    public ArraySel(int max) {
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

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) // outer loop
        {
            min = out; // minimum
            for (in = out + 1; in < nElems; in++) // inner loop
                if (a[in] < a[min]) // if min greater,
                    min = in; // we have a new min
            swap(out, min); // swap them
        } // end for(out)
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
