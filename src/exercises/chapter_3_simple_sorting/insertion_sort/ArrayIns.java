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

    public void delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) // look for it
            if (value == a[j])
                break;
        if (j == nElems) {
            System.out.println("Element not found");
        } else {
            for (int k = j; k < nElems - 1; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--; // decrement size
        }
    }

    // displays array contents
    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
    }

    public void insertionSort() {
        int in, out, comp = 0, perm = 0;
        for (out = 1; out < nElems; out++) // out is dividing line
        {
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (a[in - 1] >= temp) // until one is smaller,
            {
                if (a[in - 1] == temp)
                    temp = -1;

                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
                comp++;
                perm++;
                if (in == 0)
                    break;
            }
            a[in] = temp; // insert marked item
            perm++;
        }
        for (int i = 0; i < nElems; i++)
            if (a[0] == -1)
                delete(-1);
            else
                break;
        System.out.println("Comparisons: " + comp + "\tPermutations: " + perm);
    }

    public long median() {
        return nElems % 2 == 0 ? (a[nElems / 2] + a[(nElems - 1) / 2]) / 2 : a[nElems / 2];
    }

    public void noDups() {
        long[] temp = new long[nElems];
        int j = 0, k = 0;
        for (int i = 0; i < nElems - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j++] = a[i];
            } else {
                k++;
            }
        }
        temp[j] = a[nElems - 1];
        nElems -= k;
        if (nElems >= 0) System.arraycopy(temp, 0, a, 0, nElems);
    }
}