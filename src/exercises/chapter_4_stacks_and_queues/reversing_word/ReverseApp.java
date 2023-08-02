package exercises.chapter_4_stacks_and_queues.reversing_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            Reverser reverser = new Reverser(getString());
            System.out.println("Reversed: " + reverser.doRev());
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
