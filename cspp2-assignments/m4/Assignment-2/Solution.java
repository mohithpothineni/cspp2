
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
        String a1size = sc.nextLine();
        String[][] a1 = new String[Integer.parseInt(a1size.split(" ")[0])]
                        [Integer.parseInt(a1size.split(" ")[0])];

        for (int i = 0; i < Integer.parseInt(a1size.split(" ")[0]); i++) {
            String l = sc.nextLine();
            String[] t = l.split(" ");
            a1[i] = t;
        }

        String a2size = sc.nextLine();
        String[][] a2 = new String[Integer.parseInt(a2size.split(" ")[0])]
                        [Integer.parseInt(a2size.split(" ")[0])];

        for (int i = 0; i < Integer.parseInt(a2size.split(" ")[0]); i++) {
            String l = sc.nextLine();
            String[] t = l.split(" ");
            a2[i] = t;
        }

        if (a1size.equals(a2size)) {
            int[][] result = new int[Integer.parseInt(a1size.split(" ")[0])]
            [Integer.parseInt(a1size.split(" ")[0])];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = Integer.parseInt(a1[i][j])
                    + Integer.parseInt(a2[i][j]);
                    if (j != result[i].length - 1) {
                        System.out.print(result[i][j] + " ");
                    } else {
                         System.out.print(result[i][j]);
                    }
                }
                System.out.println();
            }

        } else {
            System.out.println("not possible");
        }



    }
}
