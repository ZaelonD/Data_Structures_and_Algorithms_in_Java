package exercises.chapter_4_stacks_and_queues.the_brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsApp {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            String input = getString();
            if (input.equals(""))
                break;
            BracketChecker br = new BracketChecker(input);
            br.check();
        }
    }

    public static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}