package exercises.chapter_4_stacks_and_queues.the_brackets;

import exercises.chapter_4_stacks_and_queues.reversing_word.StackX;

public class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        StackX stackX = new StackX(input.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stackX.push(ch);
                    break;
                case '}':
                case ')':
                case ']':
                    if (!stackX.isEmpty()) {
                        char chx = stackX.pop();
                        if ((ch == '}' && chx != '{')
                                || (ch == ')' && chx != '(')
                                || (ch == ']' && chx != '['))
                            System.out.println("Error: " + ch + " at " + i);
                    } else
                        System.out.println("Error: " + ch + " at " + i);
                    break;
                default:
                    break;
            }
        }
        if (!stackX.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}
