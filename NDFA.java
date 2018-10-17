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

    public ArrayList<String> showPossibleTransitions(ArrayList<String> state, int input) {

        // List of all possible end states
        ArrayList<String> nextStates = new ArrayList<>();

        // for i in possibleCurrentState:
        for (int i = 0; i < state.size(); i++) {

            // Set of all possible paths from a given state
            ArrayList<Path> possibleTransitions = transitions.get(state.get(i));

            // If there is a path for this state
            if (possibleTransitions != null) {

                // Iterate through each possible path from a given state
                for (int j = 0; j < possibleTransitions.size(); j++) {

                    // If the input matches the input character needed for path and does not already exist in the list
                    if (possibleTransitions.get(j).input == input) {
                        // If the end state does not exist in the list nextStates, then
                        if (!nextStates.contains(possibleTransitions.get(j).end)) {
                            nextStates.add(possibleTransitions.get(j).end);
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
}

