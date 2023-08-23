package exercises.chapter_4_stacks_and_queues.stack_on_deque_implementation;

import exercises.chapter_4_stacks_and_queues.deque.Deque;

public class StackOnDeque {
    private final Deque deque;

    public StackOnDeque(int maxSize) {
        this.deque = new Deque(maxSize);
    }

    public void push(long value) {
        deque.insertRight(value);
    }

    public void pop() {
        deque.removeRight();
    }

    public long peek() {
        return deque.peekRear();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
