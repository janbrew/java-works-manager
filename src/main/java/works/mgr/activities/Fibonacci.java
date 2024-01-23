package works.mgr.activities;

import java.util.ArrayList;

public class Fibonacci {
    public static StringBuilder fibonacci(String input) {
        int firstTerm = 1;
        int secondTerm = 1;
        int nextTerm = 0;
        int iterator = 0;
        int fiboNum = Integer.parseInt(input);

        int counting = 1;

        StringBuilder message = new StringBuilder("The sequence is: \n");
        ArrayList<Integer> terms = new ArrayList<>();

        for (; iterator < fiboNum; iterator++) {
            terms.add(iterator, firstTerm);

            nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

        for (int term: terms) {
            message.append("[ " + String.format("%,d", term) + " ]");
            if (terms.indexOf(term) != terms.size() - 1) {
                if (counting == 15) {
                    message.append(" -");
                }
                else {
                    message.append(" -> ");
                }
            }
            if (terms.size() > 15) {
                counting++;
                if (counting == 16) {
                    message.append("\n->");
                    counting = 1;
                }
            }
        }

        return message;
    }
}
