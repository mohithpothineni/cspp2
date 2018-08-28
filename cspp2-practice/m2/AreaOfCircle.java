import java.util.Scanner;
/**
    *AreaOfCircle class for area of circle.
*/
public final class AreaOfCircle {

    /**
        *default constructor.
    */
    private AreaOfCircle() {

    }


    /**
        *Do not modify this main function.
        @param args commandLineArgs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int radius = scan.nextInt();
        area(radius);
    }

    /**
        *Need to fill the area function and print the output.
        @param r radius.
    */
    public static void area(final int r) {
        System.out.println(pi() * r * r);
    }

    /**
        @return pi value of pi.
    */
    public static double pi() {
        return Math.PI;
    }
}
