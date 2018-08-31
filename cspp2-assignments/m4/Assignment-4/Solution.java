
/**
 * Solution.
 */
import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }


    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseString(s));
    }

    /**
     * binary to decimal.
     *
     * @param      s     actual.
     *
     * @return     reversed.
     */
    public static String reverseString(final String s) {
        String rs = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rs += s.charAt(i);
        }
        return rs;
    }

}
