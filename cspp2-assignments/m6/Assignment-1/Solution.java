
import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : lalalal
 */

/**
 * Solution class.
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }


    /**
     * Determines if prime.
     *
     * @param      n number to check if it is a prime or not.
     *
     * @return     True if prime, False otherwise.
     */
    static boolean isPrime(final int n) {
        //int count = 0;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                //count++;
                return false;
                //break;
            }
        }
        return true;
    }


    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    // write your code here
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1 && !isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
