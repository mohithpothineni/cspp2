
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)

    //properties

    /**
     * set declaration.
     */
    private int[] array;

    /**
     * size of the set.
     */
    private int size;

    //constructor

    /**
     * Constructs the object.
     */
    Set() {
        final int defaultsize = 10;
        array = new int[defaultsize];
        size = 0;
    }

    //methods

    /**
     * getter for size.
     *
     * @return   size of the set.
     */
    int size() {
        return this.size;
    }

    /**
     * checks if element in set or not.
     *
     * @param      item  The item to be checked.
     *
     * @return     true if present else false.
     */
    boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        int[] tmparray = new int[size];
        for (int i = 0; i < size; i++) {
            tmparray[i] = array[i];
        }
        return Arrays.toString(tmparray).replace("[", "{").replace("]", "}");
    }

    /**
     * resizes the set or increse the memory of set.
     */
    void resize() {
        final int factor = 2;
        int[] newarray = new int[factor * size];
        for (int i = 0; i < size; i++) {
            newarray[i] = array[i];
        }

        array = newarray;
    }

    /**
     * add element to the set.
     *
     * @param      item  The item to be added.
     */
    void add(final int item) {
        if (size == array.length) {
            resize();
        }
        if (!contains(item)) {
            array[size++] = item;
        }
    }

    /**
     * add elements to set if not present.
     *
     * @param      items  The items of int array.
     */
    void add(final int[] items) {
        for (int i : items) {
            if (!contains(i)) {
                add(i);
            }
        }
    }

    /**
     * intersection of to sets.
     *
     * @param      other  The Set other
     *
     * @return     intersection of two set elements
     * in an another set.
     */
    Set intersection(final Set other) {
        Set result = new Set();

        for (int i : this.array) {
            if (other.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * retain all from the items given.
     *
     * @param items int type elements array.
     *
     * @return Set with retained elements.
     */
    Set retainAll(final int[] items) {
        Set result = new Set();

        for (int i : this.array) {
            for (int j : items) {
                if (i == j) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    /**
     * cartesian product.
     *
     * @param      obj   The Set object
     *
     * @return     cartesian product of two sets.
     */
    int[][] cartesianProduct(final Set obj) {
        if (this.array.length == 0 || obj.array.length == 0) {
            return null;
        }

        int estimatedrows = this.size() * obj.size();

        int[][] result = new int[estimatedrows][2];


        for (int n = 0; n < this.size(); n++) {
            int k = 0;
            for (int i = 0; i < estimatedrows; i++) {
                result[i][0] = this.array[n];
                result[i][1] = obj.array[k++];
                if (k == obj.size()) {
                    k = 0;
                    n++;
                }
            }
        }

        return result;
    }

}


/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                if (s.cartesianProduct(t).length != 0) {
                    System.out.println(Arrays.deepToString(
                                           s.cartesianProduct(t)));
                } else {
                    System.out.println("null");
                }
                break;
            default:
                break;
            }
        }
    }
}
