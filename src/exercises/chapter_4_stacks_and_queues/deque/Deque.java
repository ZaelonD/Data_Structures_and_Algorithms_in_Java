package exercises.chapter_4_stacks_and_queues.deque;

public class Deque {
    private final long[] dequeArray;
    private final int maxSize;
    private int front, rear;
    private int nElems;

    public Deque(int size) {
        this.maxSize = size;
        this.dequeArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nElems = 0;
    }

    public void insertLeft(long value) {
        if (!isFull()) {
            if (rear == maxSize - 1)
                rear = -1;
            shift(value);
        } else
            System.err.println("Can't insert the value " + value + "\nDeque is full");
    }

    public void removeLeft() {
        if (!isEmpty()) {
            front++;
            if (front == maxSize)
                front = 0;
            nElems--;
        } else
            System.err.println("Can't remove the value \nQueue is empty");
    }

    public void insertRight(long value) {
        if (isEmpty()) {
            dequeArray[rear++] = value;
            front++;
        } else if (isFull()) {
            dequeArray[++rear] = value;
        } else
            System.err.println("Can't insert the value " + value + "\nDeque is full");
    }

    public void removeRight() {

    }

    public long peekFront() {
        return dequeArray[front];
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public boolean isFull() {
        return maxSize == nElems;
    }

    private void shift(long value) {
        if (rear == -1 || rear < front) {
            dequeArray[++rear] = value;
        } else {
            for (int i = rear; i >= 0; i--)
                dequeArray[i + 1] = dequeArray[i];
            dequeArray[front] = value;
            rear++;
        }
        nElems++;
    }
}