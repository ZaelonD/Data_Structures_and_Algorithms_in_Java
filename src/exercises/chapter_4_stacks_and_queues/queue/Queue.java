package exercises.chapter_4_stacks_and_queues.queue;

public class Queue {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        front = 0;
        rear = -1;
        nItems = 0;
        queArray = new long[maxSize];
    }

    public void insert(long value) {
        if (!isFull()) {
            if (rear == maxSize - 1)
                rear = -1;
            queArray[++rear] = value;
            nItems++;
        } else
            System.err.println("Can't insert the value " + value + "\nQueue is full");
    }

    public long remove() {
        if (!isEmpty()) {
            long temp = queArray[front++];
            if (front == maxSize)
                front = 0;
            nItems--;
            return temp;
        } else {
            System.err.println("Can't remove the value\nQueue is empty");
        }
        return -1;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int getSize() {
        return nItems;
    }

    public void display() {
        if (!isEmpty()) {
            int i = 0;
            if (rear < front) {
                for (i = front; i != maxSize; i++)
                    System.out.print(queArray[i] + "\t");
                for (i = 0; i < rear; i++)
                    System.out.print(queArray[i] + "\t");
            } else
                for (i = front; i <= rear; i++)
                    System.out.print(queArray[i] + "\t");
        } else
            System.out.println("Queue is empty");
    }
}