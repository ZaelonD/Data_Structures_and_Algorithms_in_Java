package exercises.chapter_4_stacks_and_queues.postfix;

public class StackX {
    private final int maxSize;
    private final int[] stackArray;
    private int top;

    //--------------------------------------------------------------
    public StackX(int size) // constructor
    {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    //--------------------------------------------------------------
    public void push(int j) // put item on top of stack
    {
        stackArray[++top] = j;
    }

    //--------------------------------------------------------------
    public int pop() // take item from top of stack
    {
        return stackArray[top--];
    }

    //--------------------------------------------------------------
    public int peek() // peek at top of stack
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1);
    }

    //--------------------------------------------------------------
    public int size() // return size
    {
        return top + 1;
    }

    //--------------------------------------------------------------
    public int peekN(int n) // peek at index n
    {
        return stackArray[n];
    }

    //--------------------------------------------------------------
    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack(bottom-- > top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println();
    }
//--------------------------------------------------------------
}