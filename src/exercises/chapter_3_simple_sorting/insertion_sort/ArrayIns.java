package exercises.chapter_3_simple_sorting.insertion_sort;

public class ArrayIns {
    private final long[] a; // ref to array a
    private int nElems; // number of data items

    // constructor
    public ArrayIns(int max) {
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

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) // out is dividing line
        {
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }
}