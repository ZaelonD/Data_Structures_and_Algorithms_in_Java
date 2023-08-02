package exercises.chapter_4_stacks_and_queues.reversing_word;

public class Reverser {
    private final String input;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        StackX stackX = new StackX(input.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            stackX.push(input.charAt(i));
        }
        while (!stackX.isEmpty()) {
            stringBuilder.append(stackX.pop());
        }
        return stringBuilder.toString();
    }
}
