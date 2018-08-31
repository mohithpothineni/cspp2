
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
        int n = sc.nextInt();
        String tmp = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            //Write binaryToDecimal function
            System.out.println(res);
        }
    }

    /**
     * binary to decimal.
     *
     * @param      s     binary form.
     *
     * @return     decimal form in tring format.
     */
    public static String binaryToDecimal(final String s) {
        int count = 0;
        int base = s.length() - 1;
        for (char i : s.toCharArray()) {
            count += Math.pow(2, base) * Integer.parseInt("" + i);
            base--;
        }
        return "" + count;
    }

}
