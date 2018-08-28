

import java.util.Scanner;
/**
*Solution for finding power by recursion.
*/

public final class Solution {
    /**
    *default constructor.
    */
    private Solution() {

    }


    /**
    *Do not modify this main function.
    @param args commandlineargs
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }

    /**
    *Need to write the power function and print the output.
    @param a base
    @param e exponant
    @return result powered
    */
    public static long power(final long a, final int e) {
        if (e == 0) {
            return 1;
        }
        return a * power(a, e - 1);
    }
}
