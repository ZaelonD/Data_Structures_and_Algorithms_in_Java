package exercises.chapter_4_stacks_and_queues.stack_on_deque_implementation;

public class StackOnDequeApp {
    public static void main(String[] args) {
        StackOnDeque stack = new StackOnDeque(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
