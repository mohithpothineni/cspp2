/**
 * Class for Pattern example.
 */

/**
 * Class for Pattern.
 */
public final class Pattern {

    /**
     * constant number.
     */
    static final int CONSTANT = 5;

    /**
     * default constructor.
     */
    private Pattern() {

    }

    /**
     * main method.
     * @param args commandlineargs
     */
    public static void main(final String[] args) {
        for (int i = 1; i <= CONSTANT; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
