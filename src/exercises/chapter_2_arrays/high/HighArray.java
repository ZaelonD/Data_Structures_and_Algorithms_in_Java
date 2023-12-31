package exercises.chapter_2_arrays.high;

public class HighArray {
    private final long[] a; // ref to array a
    private int nElems; // number of data items

    // constructor
    public HighArray(int max) {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    public boolean find(long searchKey) { // find specified value
        int j;
        for (j = 0; j < nElems; j++) // for each element,
            if (a[j] == searchKey) // found item?
                break; // exit loop before end
        return j != nElems; // yes, can’t find it
    }

    // put element into array
    public void insert(long value) {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public void delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) // look for it
            if (value == a[j])
                break;
        if (j == nElems) {
            System.out.println("Element not found");
        } else {
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--; // decrement size
        }
    }

    // displays array contents
    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
    }

    // maximum search method -> maximum removal method
    public long removeMax() {
        if (nElems == 0)
            return -1;
        long max = a[0];
        for (int i = 1; i < nElems; i++)
            if (a[i] > max)
                max = a[i];
        delete(max);
        return max;
    }

    // method remove all duplicates
    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            for (int j = 0; j < nElems; j++) {
                if (i == j)
                    continue;
                if (a[i] == a[j]) {
                    a[j] = -1;
                    delete(-1);
                }
            }
        }
    }
}