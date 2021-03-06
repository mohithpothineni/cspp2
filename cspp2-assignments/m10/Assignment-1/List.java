

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * List class.
 */
public final class List {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */

    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /**
     * array to store int's.
     */
    private int[] array;

    /**
     * array size.
     */
    private int size;

    /**
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
    public List() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        final int sizeofarray = 10;
        array = new int[sizeofarray];
        size = 0;

    }

    /**
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing).
     * @param item item to be added.
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        array[size++] = item;
    }

    /**
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *@return tthe size of array.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /**
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(2) would remove the item 2
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing).
     *
     *@param index index starting from 0 given to be removed.
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.

        if (index >= size || index <= -1) {
            System.out.println("Invalid Position Exception");
        } else if (index == array.length - 1) {
            array[index] = 0;
            size--;
        } else {
            array[index] = array[index + 1];

            for (int i = index + 1; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            array[array.length - 1] = 0;
            size--;
            //System.out.println(Arrays.toString(array));
        }


    }

    /**
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     *
     *@param index index strating from 0.
     *
     *@return element if valid position else -1.
     */
    public int get(final int index) {
        // Replace the code below to write the code for get

        if (index < size && index >= 0) {
            return array[index];
        }
        return -1;
    }

    /**
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     *
     *@return array in string format.
     *
     */
    public String toString() {
        // Replace the code below
        int[] tmparray = new int[size];
        for (int i = 0; i < size; i++) {
            tmparray[i] = array[i];
        }

        return Arrays.toString(tmparray).replace(" ", "");
    }

    /**
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false.
     *
     *@param item element to be checked.
     *
     *@return true if present else false.
     *
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     *@param item element for which index is required.
     *
     *@return index of the element if present
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        if (size == array.length || array.length - size < items.length) {
            int[] tmp = new int[array.length + array.length];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            for (int i = 0; i < items.length; i++) {
                tmp[i + size] = items[i];
            }

            array = tmp;

        } else {
            for (int i = 0; i < items.length; i++) {
                array[i + size] = items[i];
            }
        }

        size += items.length;


    }

    /*
       Inserts the specified element at the specified index
    by moving all the elements to the right.
       The method returns void (nothing)
    */

    /**
     * adds element at specified index.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
        if (index <= -1) {
            System.out.println("Negative Index Exception");
            return;
        }
        int tmp = array[index];
        for (int i = index; i < size + 1; i++) {
            int tmp2 = array[i + 1];
            array[i + 1] = tmp;
            tmp = tmp2;

        }
        array[index] = item;
        size++;
    }

    /* Returns the count of occurances of a given item in the list*/

    /**
     * count/frequency of an element.
     *
     * @param      item  The item
     *
     * @return     count of the element.
     */
    public int count(final int item) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                c++;
            }
        }
        return c;
    }

    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

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
            case "add":
                if ((tokens.length) == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.parseInt(tokens[1]));
                    } else {
                        if (t.length > 1) {
                            l.add(Integer.parseInt(t[0]),
                                  Integer.parseInt(t[1]));
                        }
                    }
                }
                break;
            case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
            case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
            case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
            case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            default:
                break;
            }
        }
    }
}
