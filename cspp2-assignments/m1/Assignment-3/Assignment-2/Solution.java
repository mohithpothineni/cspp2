import java.util.Scanner;
/**
    *Solution class for area of triangle.
*/
public final class Solution {
    /**
        *constant.
    */
    public static final double CONSTANT = 0.5;

    /**
        *default constructor.
    */
    private Solution() {

    }


    /**
        *Do not modify this main function.
        @param args commandLineArgs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }

    /**
        *Need to fill the areaOfTriangle function and print the output.
        @param b base.
        @param h height.
    */
    public static void areaOfTriangle(final int b, final int h) {
        System.out.println(CONSTANT * b * h);
    }
}
