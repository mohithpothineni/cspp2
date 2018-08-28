import java.util.Scanner;

/**
    * DegreesToFahrenheit class producing Fahrenheit from Degrees.
*/
public final class Solution {
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
    private Solution() {

    }


    /**
    Do not modify this main function.
    @param args commandLineArgs
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }

    /**
    Need to fill the calculateFromDegreesToFarenheit
    function and print the output
    of fahrenheit.
    @param degreesCelsius degree.
    */
    public static void
            calculateFromDegreesToFarenheit(final double degreesCelsius) {
        System.out.println((degreesCelsius * A / B) + C);
    }



}

