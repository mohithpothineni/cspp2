import java.util.Scanner;

/**
    * QuotientRemainder class producing quotient and remainder.
*/
public final class QuotientRemainder {

    /**
        *default constructor.
    */
    private QuotientRemainder() {

    }

    /**
        *@param args commandLineArguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("quotient is " + a / b + " remainder is " + a % b);
    }
}
