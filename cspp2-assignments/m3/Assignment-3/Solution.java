
import java.util.Scanner;
/*
Program for gcd.
*/

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
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcdd = gcd(n1, n2);
        System.out.println(gcdd);
    }
    /*
    Need to write the gcd function and print the output.
    */

    /**
     * gcd.
     *
     * @param      n1    The n 1.
     * @param      n2    The n 2.
     *
     * @return     gcd.
     */
    public static int gcd(final int n1, final int n2) {
        int t = 0;

        if (n1 < n2) {
            t = n1;
        } else {
            t = n2;
        }

        int result = 1;

        for (int i = 1; i <= t; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                result = i;
            }
        }

        return result;

    }

}
