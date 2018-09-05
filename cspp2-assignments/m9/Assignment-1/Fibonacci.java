
import java.util.Scanner;

/**
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 *
 */
public final class Fibonacci {

    /**
     * Constructs the object.
     */
    private Fibonacci() {

    }

    /**
     * method fib gives list of n fibnochi no's.
     *
     * @param      n  no of fibnochi nos.
     *
     * @return     List containing n fibnochi no's.
     */
    public static List fib(final int n) {
        // todo - complete this method
        List result = new List(n);
        for (int i = 1; i <= n; i++) {
            result.add(fibgen(i));
        }

        return result;
    }

    /**
     * generates n th fib number.
     *
     * @param      n     nth fib to get
     *
     * @return     nth fib number.
     */
    public static int fibgen(final int n) {
        if (n <= 2) {
            return n - 1;
        }

        return fibgen(n - 1) + fibgen(n - 2);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}
