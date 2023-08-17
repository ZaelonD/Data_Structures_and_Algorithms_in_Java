package exercises.chapter_4_stacks_and_queues.postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString(); // read a string from kbd
            if (input.equals("")) // quit if [Enter]
                break;
            // make a parser
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse(); // do the evaluation
            System.out.println("Evaluates to " + output);
        } // end while
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
