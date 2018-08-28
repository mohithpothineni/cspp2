
import java.util.Scanner;
/**
 * Solution for quadratic equation.
 */
public final class Solution {
    /**
     * constant a.
     */
    public static final int CONSTANT = 4;

    /**
     * default constructor.
     */
    private Solution() {

    }

    /**
    *Do not modify this main function.
    *@param args commandlineargs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }

    /**
    Need to write the rootsOfQuadraticEquation function and print the output.
    @param a acoefficient
    @param b bcoefficient
    @param c ccoefficient
    */
    public static void
        rootsOfQuadraticEquation(final int a, final int b, final int c) {
        double delta = (b * b) - (CONSTANT * a * c);
        if (delta < 0) {
            System.out.println("no real roots");
        } else {
            System.out.print((-b + Math.sqrt(delta)) / (2 * a) + " ");
            System.out.println((-b - Math.sqrt(delta)) / (2 * a));
        }
    }
}
