import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * NDFADriver.java
 * @author Joshua Chen
 * Date Created: Oct 16, 2018
 */

public class NDFADriver {
    public static void main(String[] args) {

        NDFA ndfa = new NDFA();

        String[] path1 = {"start", "0", "start"};
        String[] path2 = {"start", "1", "start"};
        String[] path3 = {"start", "0", "near"};
        String[] path4 = {"near", "1", "end"};

        ndfa.addTransitions(path1);
        ndfa.addTransitions(path2);
        ndfa.addTransitions(path3);
        ndfa.addTransitions(path4);

        ArrayList<String> current = new ArrayList<>();
        current.add("start");

        int[] inputs = {1,0,1,1,0,1};

        System.out.println("Start state: " + current.get(0));

        current = ndfa.showPossibleTransitions2(current.get(0), inputs);

        System.out.println("Stop state(s) = " + current);

    }
}
