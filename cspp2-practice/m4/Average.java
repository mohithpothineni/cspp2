import java.util.Scanner;
/**
 * Average
 */

/**
 * Average class.
 */
public final class Average {

    /**
     * constant.
     */
    static final int CONSTANT = 6;

    /**
     * default constructor.
     */
    private Average() {

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

        int denom = n.length;

        float count = 0;

        for (String i : n) {
            count += Integer.parseInt(i);
        }

        System.out.println(count / denom);

    }

}
