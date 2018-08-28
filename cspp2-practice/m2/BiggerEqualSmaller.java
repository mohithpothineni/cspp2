import java.util.Scanner;
/**
    *BiggerEqualSmaller class for assesing numbers.
*/
public final class BiggerEqualSmaller {

    /**
        *default constructor.
    */
    private BiggerEqualSmaller() {

    }


    /**
        *Do not modify this main function.
        @param args commandLineArgs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a > b) {
            System.out.println("Bigger");
        } else if (a == b) {
            System.out.println("Equal");
        } else if (a < c) {
            System.out.println("Smaller");
        }

    }

}
