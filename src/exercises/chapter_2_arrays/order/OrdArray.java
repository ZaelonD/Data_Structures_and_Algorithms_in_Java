package exercises.chapter_2_arrays.order;

public class OrdArray {
    private final long[] a; // ref to array a
    private int nElems; // number of data items

    // constructor
    public OrdArray(int max) {
        a = new long[max]; // create array
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn; // found it
            else if (lowerBound > upperBound)
                return nElems; // can’t find it
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it’s in upper half
                else
                    upperBound = curIn - 1; // it’s in lower half
            }
        }
    }

    // put element into array
    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value) {
                break;
            } else if (lowerBound > upperBound) {
                if (value >= a[curIn]) {
                    if (a[curIn] == 0 && nElems == 0) {
                        curIn = 0;
                    } else {
                        curIn++;
                    }
                }
                break;
            } else {
                if (a[curIn] < value) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
        for (int k = nElems; k > curIn; k--) // move bigger ones up
            a[k] = a[k - 1];
        a[curIn] = value; // insert it
        nElems++; // increment size
    }

    public void delete(long value) {
        int j = find(value);
        if (j == nElems) // can’t find it
        {
            System.out.println("Element not found");
        } else {
            for (int k = j; k < nElems; k++) // move bigger ones down
                a[k] = a[k + 1];
            nElems--; // decrement size
        }
    }

    // displays array contents
    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
    }
}
