
/**
 * Concatinate.java
 */
import java.util.Scanner;

/**
 * Class for Concatinate.
 */
public final class Concatinate {

    /**
     * Constructs the object.
     */
    private Concatinate() {

    }


    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(helloName(sc.nextLine()));
    }

    /**
     * greeting.
     *
     * @param      s     string name.
     *
     * @return     greeting + name.
     */
    public static String helloName(final String s) {
        return "Hello " + s + "!";
    }

}
