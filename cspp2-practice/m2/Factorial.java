import java.util.Scanner;
/**
    *Factorial class for assesing numbers.
*/
public final class Factorial {

    /**
        *default constructor.
    */
    private Factorial() {

    }


    /**
        *Do not modify this main function.
        @param args commandLineArgs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factorial(n));
    }

    /**
        *factorial.
        @param n number
        @return num factorial
    */
    public static int factorial(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
