/**
 * Class for looping example.
 */

/**
 * Class for convertto while loop.
 */
public final class ConverttoWhileLoop {
    /**
     * constant num.
     */
    static final int CONSTANT = 10;

    /**
     * default constructor.
     */
    private ConverttoWhileLoop() {

    }

    /**
     * main method.
     * @param args commandlineargs
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= CONSTANT) {
            System.out.println(i);
            i += 2;
        }

        System.out.println("GoodBye!");
    }

}
