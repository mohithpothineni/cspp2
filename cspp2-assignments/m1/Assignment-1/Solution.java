import java.util.Scanner;

/**
    * Solution class.
*/
public final class Solution {

    /**
        *default constructor.
    */
    private Solution() {

    }

    /**
        *@param args commandLineArguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String rollnum = sc.next();
        System.out.println("Name :" + name + " , Roll Number :" + rollnum);
    }

}
