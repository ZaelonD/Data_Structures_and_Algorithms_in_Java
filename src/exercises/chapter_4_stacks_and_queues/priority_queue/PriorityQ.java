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
        if (!isFull())
            queArray[nItems++] = item;
        else
            System.err.println("Can't insert the value " + item + "\nDeque is full");
    }

    // remove minimum item
    public long remove() {
        long minVal = peekMin();
        if (!isEmpty()) {
            int i;
            for (i = 0; i < nItems; i++) {
                if (minVal == queArray[i])
                    break;
            }
            for (int j = i; j < nItems - 1; j++) {
                queArray[j] = queArray[j + 1];
            }
            nItems--;
        }
        return minVal;
    }

    // peek at minimum item
    public long peekMin() {
        long min = queArray[0];
        if (!isEmpty()) {
            for (int i = 1; i < nItems; i++) {
                if (queArray[i] < min)
                    min = queArray[i];
            }
        } else
            System.err.println("Can't peek.\nDeque is full");
        return min;
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