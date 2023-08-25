package exercises.chapter_5_linked_lists.stack_on_link_list_implementation;

public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        stack.push(20);
        stack.push(40);
        stack.displayStack();
        stack.push(60);
        stack.push(80);
        stack.displayStack();
        stack.pop();
        stack.pop();
        stack.displayStack();
    }
}