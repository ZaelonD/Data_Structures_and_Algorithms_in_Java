package exercises.chapter_4_stacks_and_queues.priority_queue;

public class PriorityQ {
    private final int maxSize;
    private final long[] queArray;
    private int nItems;


    public PriorityQ(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    // insert item
    public void insert(long item) {
        int j;
        // if no items,
        if (isEmpty())
            queArray[nItems++] = item; // insert at 0
            // if items,
        else {
            // start at end,
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) // if new item larger,
                    queArray[j + 1] = queArray[j]; // shift upward
                else // if smaller,
                    break; // done shifting
            } // end for
            queArray[j + 1] = item; // insert it
            nItems++;
        }
    }

    // remove minimum item
    public long remove() {
        return queArray[--nItems];
    }

    // peek at minimum item
    public long peekMin() {
        return queArray[nItems - 1];
    }

    // true if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // true if the queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
