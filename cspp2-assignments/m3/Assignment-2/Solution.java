
import java.util.Scanner;
    /*
    Do not modify this main function.
    */

    /**
     * Solution class.
     */

public final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/

    /**
     * constant.
     */
    static final int DIVIDOR = 10;

    /**
     * finder.
     */
    static final int FIND = 7;

    /**
     * Constructs the object.
     */
    private Solution() {

    }


    /**
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int j = i;

            while (j > 0) {
                if (j % DIVIDOR == FIND) {
                    sum += 1;
                }

                j /= DIVIDOR;
            }
        }
        System.out.println(sum);

    }
}
