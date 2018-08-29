/**
 * Class for SumOfNNumbers example.
 */

import java.util.Scanner;

/**
 * Class for SumOfNNumbers.
 */
public final class SumOfNNumbers {

    /**
     * default constructor.
     */
    private SumOfNNumbers() {

    }

    /**
     * main method.
     * @param args commandlineargs
     */
    public static void main(final String[] args) {
        int sum = 0, i = 0;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while (i <= n) {
            sum += i;
            i += 1;
        }

        System.out.println(sum);
    }

}
