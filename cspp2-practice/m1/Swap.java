import java.util.Scanner;

/**
    * Swap class for swapping two numbers.
*/
public final class Swap {

    /**
        *default constructor.
    */
    private Swap() {

    }

    /**
        *@param args commandLineArguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a is " + a + " b is " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println("a is " + a + " b is " + b);
    }
}
