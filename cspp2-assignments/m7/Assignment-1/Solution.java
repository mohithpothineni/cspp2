
/**
 * Solution program.
 */

import java.util.Scanner;



/**
 * Class for input validator.
 */
class InputValidator {
    //properties

    /**
     * variable to store user input.
     */
    private String data;

    /**
     * length of the string.
     */
    private final int length = 6;

    /**
     * Constructs the object.
     *
     * @param      inp   The input string
     */
    InputValidator(final String inp) {
        data = inp;
    }

    /**
     * validates the user input.
     *
     * @return  true if user input is valid else false
     */
    boolean validateData() {
        return data.length() >= length;
    }

}


/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main method.
     * @param args commandlineargs.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }

}
