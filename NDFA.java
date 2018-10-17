import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * NDFA.java
 * @author Joshua Chen
 * Date Created: Oct 16, 2018
 */

public class NDFA {

    private Map<String, ArrayList<Path>> transitions;

    public NDFA() {
        this.transitions = new HashMap<>();
    }

    public void addTransitions(String[] inputPath) {

        String key = inputPath[0];

        // If key exists
        if (transitions.containsKey(key)){
            ArrayList<Path> temp = transitions.get(key);
            temp.add(new Path(Integer.parseInt(inputPath[1]), inputPath[2]));
            transitions.replace(key, temp);
        }
        // If key does not exist
        else {
            ArrayList<Path> temp = new ArrayList<>();
            temp.add(new Path(Integer.parseInt(inputPath[1]), inputPath[2]));
            transitions.put(key, temp);
        }
    }

    public ArrayList<String> showPossibleTransitions(ArrayList<String> possibleCurrentStates, int input) {

        // List of all possible end states
        ArrayList<String> nextStates = new ArrayList<>();

        for (int i = 0; i < possibleCurrentStates.size(); i++) {

            ArrayList<Path> possiblePathsFromCurrentState = transitions.get(possibleCurrentStates.get(i));

            // If there is a path for this state
            if (possiblePathsFromCurrentState != null) {

                // Iterate through each possible path from a given state
                for (int j = 0; j < possiblePathsFromCurrentState.size(); j++) {

                    // If the input matches the input character needed for path and does not already exist in the list
                    if (possiblePathsFromCurrentState.get(j).input == input) {
                        // If the end state does not exist in the list nextStates, then
                        if (!nextStates.contains(possiblePathsFromCurrentState.get(j).end)) {
                            nextStates.add(possiblePathsFromCurrentState.get(j).end);
                        }
                    }
                }
            }
        }

        Collections.sort(nextStates);
        System.out.print("new possible states: ");
        System.out.print(nextStates + "\n");
        return nextStates;
    }

    public ArrayList<String> showPossibleTransitions2(String currentState, int[] inputs) {

        ArrayList<String> currentStates = new ArrayList<>();

        currentStates.add(currentState);

        // For each input character
        for (int i = 0; i < inputs.length; i++) {

            ArrayList<String> nextStates = new ArrayList<>();

            // For each possible current states
            for (int j = 0; j < currentStates.size(); j++) {

                ArrayList<Path> possiblePathsFromCurrentState = transitions.get(currentStates.get(j));

                // If there is a path for this state
                if (possiblePathsFromCurrentState != null) {

                    // Iterate through each possible path from a given state
                    for (int k = 0; k < possiblePathsFromCurrentState.size(); k++) {

                        // If the input matches the input character needed for path and does not already exist in the list
                        if (possiblePathsFromCurrentState.get(k).input == inputs[i]) {
                            // If the end state does not exist in the list nextStates, then
                            if (!nextStates.contains(possiblePathsFromCurrentState.get(k).end)) {
                                nextStates.add(possiblePathsFromCurrentState.get(k).end);
                            }
                        }
                    }
                }
            }
            Collections.sort(nextStates);
            System.out.print("\tInput = " + inputs[i] + "; ");
            System.out.print("new possible states: ");
            System.out.print(nextStates + "\n");
            currentStates = nextStates;
        }
        return currentStates;
    }
}

