import java.util.Scanner;

/**
    * DegreesToFahrenheit class producing Fahrenheit from Degrees.
*/
public final class DegreesToFahrenheit {
    /**
    * constant A.
    */
    public static final int A = 9;
    /**
    * constant B.
    */
    public static final int B = 5;
    /**
    * constant C.
    */
    public static final int C = 32;
    /**
        *default constructor.
    */
    private DegreesToFahrenheit() {

    }

    /**
        *@param args commandLineArguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int degree = sc.nextInt();
        System.out.println(degree + " Degree is "
                          + ((degree * A / B) + C) + " Fahrenheit");
    }
}
