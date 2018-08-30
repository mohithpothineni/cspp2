
/**
 * Solution.java
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
        int n = sc.nextInt();
        int[] nums = new int[n];
        int temp = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > temp) {
                temp = nums[i];
            }
        }

        System.out.println(temp);

    }
}
