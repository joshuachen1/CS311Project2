import java.util.ArrayList;
import java.util.Scanner;

/**
 * NDFADriver.java
 * @author Joshua Chen
 * Date Created: Oct 16, 2018
 */

public class NDFADriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        NDFA ndfa = new NDFA();

        String[] path1 = {"start", "0", "start"};
        String[] path2 = {"start", "1", "start"};
        String[] path3 = {"start", "0", "near"};
        String[] path4 = {"near", "1", "end"};

        ndfa.addTransitions(path1);
        ndfa.addTransitions(path2);
        ndfa.addTransitions(path3);
        ndfa.addTransitions(path4);

        // List of possible current states
        ArrayList<String> possibleCurrentState = new ArrayList<>();

        // Start state = start
        possibleCurrentState.add("start");

        System.out.println("Start state = " + possibleCurrentState.get(0));

        while (true) {
            int input = scan.nextInt();

            System.out.print("Input = " + input + "; ");

            // Pass in list of possible current states, and the input character
            possibleCurrentState = ndfa.showPossibleTransitions(possibleCurrentState, input);
        }
    }
}
