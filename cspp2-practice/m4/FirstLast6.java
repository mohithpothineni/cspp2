import java.util.Scanner;
/**
 * FirstLast6
 */

/**
 * FirstLast6 class.
 */
public final class FirstLast6 {

    /**
     * constant.
     */
    static final int CONSTANT = 6;

    /**
     * default constructor.
     */
    private FirstLast6() {

    }

    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] n = s.split(" ");

        if (Integer.parseInt(n[0]) == CONSTANT
            || Integer.parseInt(n[n.length - 1]) == CONSTANT) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }





    }

}
