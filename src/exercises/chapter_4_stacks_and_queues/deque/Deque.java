package exercises.chapter_4_stacks_and_queues.deque;

public class Deque {
    private final long[] dequeArray;
    private final int maxSize;
    private int front, rear;

    public Deque(int size) {
        this.maxSize = size;
        this.dequeArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public void insertLeft(long value) {
        if (!isFull()) {
            if (rear == maxSize - 1 && front != 0) {
                rear = -1;
                dequeArray[++rear] = value;
            } else
                shift(value);
        } else
            System.err.println("Can't insert the value " + value + "\nDeque is full");
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

    public void removeLeft() {
        if (!isEmpty()) {
            if (front == maxSize - 1)
                front = 0;
            else
                front++;
        } else
            System.err.println("Can't remove the value \nQueue is empty");
    }

    public void removeRight() {

    }

    public boolean isEmpty() {
        return rear + 1 == front || (front + maxSize - 1 == rear && isFull());
    }

    public boolean isFull() {
        return rear + 1 == front || front + maxSize - 1 == rear;
    }

    private void shift(long value) {
        for (int i = rear; i >= 0; i--)
            dequeArray[i + 1] = dequeArray[i];
        dequeArray[front] = value;
        rear++;
    }
}
