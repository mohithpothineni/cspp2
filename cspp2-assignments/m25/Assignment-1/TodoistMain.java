
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
  * write your code below this comment
  */

/**
 * Class for Task.
 */
class Task {
    /**
     * title of task.
     */
    private String title;

    /**
     * getter for title.
     *
     * @return     title of task.
     */
    String gettitle() {
        return this.title;
    }

    /**
     * name of person.
     */
    private String nameofperson;

    /**
     * getter for name of person.
     *
     * @return     returns name of person.
     */
    String getnameofperson() {
        return this.nameofperson;
    }

    /**
     * time for task.
     */
    private int minutes;

    /**
     * getter func for time.
     *
     * @return    time for the task.
     */
    int getminutes() {
        return this.minutes;
    }

    /**
     * important or not.
     */
    private boolean importance;

    /**
     * getter for importance flag.
     *
     * @return     the importance of task or not.
     */
    boolean getimportance() {
        return this.importance;
    }

    /**
     * urgent or not.
     */
    private boolean urgency;

    /**
     * getter for urgency.
     *
     * @return     urgency flag.
     */
    boolean geturgency() {
        return this.urgency;
    }

    /**
     * status of the task at current.
     */
    private String taskstatus;

    /**
     * getter for taskstatus.
     *
     * @return     current task status.
     */
    String gettaskstatus() {
        return this.taskstatus;
    }



    /**
     * Constructs the object.
     */
    Task() {

    }

    /**
     * Constructs the object.
     *
     * @param      titlee          The titlee
     * @param      assignedTo      The assigned to
     * @param      timeToComplete  The time to complete
     * @param      important       The important
     * @param      urgent          The urgent
     * @param      status          The status
     * @throws     Exception       parent exception
     */
    Task(final String titlee, final String assignedTo,
         final int timeToComplete, final boolean important,
         final boolean urgent, final String status) throws Exception {

        if (titlee.equals("")) {
            System.out.println("Title not provided");
            throw new Exception();
        }
        this.title = titlee;
        this.nameofperson = assignedTo;

        if (timeToComplete < 0) {
            System.out.println("Invalid timeToComplete " + timeToComplete);
            throw new Exception();
        }
        this.minutes = timeToComplete;
        this.importance = important;
        this.urgency = urgent;
        if (!status.equals("todo") && !status.equals("done")) {
            System.out.println("Invalid status " + status);
            throw new Exception();
        }
        this.taskstatus = status;


    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String imp;
        if (this.importance) {
            imp = "Important";
        } else {
            imp = "Not Important";
        }

        String urg;
        if (this.urgency) {
            urg = "Urgent";
        } else {
            urg = "Not Urgent";
        }

        return this.title + ", " + this.nameofperson + ", "
               + this.minutes + ", "
               + imp + ", " + urg + ", " + this.taskstatus;
    }



}

/**
 * Class for todoist.
 */
class Todoist {

    /**
     * arraylist for tasks.
     */
    private ArrayList<Task> tasks;

    /**
     * Constructs the object.
     */
    Todoist() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Adds a task.
     *
     * @param      giventask  The giventask
     */
    void addTask(final Task giventask) {
        tasks.add(giventask);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String result = "";
        for (Task t : tasks) {
            result += t.toString() + "\n";
        }
        return result;
    }

    /**
     * helper func for getNextTask.
     *
     * @param      name  The name
     * @param      impp  The importance
     * @param      urgg  The urgency
     *
     * @return     Task object.
     */
    Task helper(final String name, final boolean impp, final boolean urgg) {
        for (Task t : tasks) {
            if (t.getnameofperson().equals(name) && t.getimportance() == impp
                    && t.geturgency() == urgg
                    && t.gettaskstatus().equals("todo")) {
                return t;
            }
        }

        return null;
    }



    /**
     * Gets the next task.
     *
     * @param      nameeofperson  The nameeofperson
     *
     * @return     The next task.
     */
    Task getNextTask(final String nameeofperson) {
        Task result = helper(nameeofperson, true, false);
        if (result != null) {
            return result;
        }

        return helper(nameeofperson, true, true);

    }

    /**
     * helper func for get next.
     *
     * @param      name       The name
     * @param      impp       The impp
     * @param      urgg       The urgg
     * @param      nooftasks  The nooftasks
     *
     * @return     { description_of_the_return_value }
     */
    Task[] helper(final String name, final boolean impp,
                  final boolean urgg, final int nooftasks) {
        Task[] result = new Task[nooftasks];
        int i = 0;

        for (Task t : tasks) {
            if (t.getnameofperson().equals(name)
                    && t.getimportance() == impp
                    && t.geturgency() == urgg
                    && t.gettaskstatus().equals("todo")) {
                result[i++] = t;
                if (i == nooftasks) {
                    break;
                }
            }
        }

        return result;
    }



    /**
     * Gets the next task.
     *
     * @param      nameeofperson  The nameeofperson
     * @param      nooftasks      The nooftasks
     *
     * @return     The next task.
     */
    Task[] getNextTask(final String nameeofperson, final int nooftasks) {
        Task[] result = helper(nameeofperson, true, false, nooftasks);
        if (result[0] != null) {
            return result;
        }

        return helper(nameeofperson, true, true, nooftasks);
    }

    /**
     * computes time for tasks to be done.
     *
     * @return     time int required for task completion.
     */
    int totalTime4Completion() {
        int result = 0;
        for (Task t : tasks) {
            if (t.gettaskstatus().equals("todo")) {
                result += t.getminutes();
            }
        }

        return result;
    }





}






/**
 * Class for todoist main.
 */
public final class TodoistMain {

    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.print(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];

        //to avaoid magic number error in checkstyle.
        final int indx = 3;
        final int indx2 = 4;


        int timeToComplete = Integer.parseInt(tokens[indx]);
        boolean important = tokens[indx2].equals("y");

        //to avaoid magic number error in checkstyle.
        final int indxx = 5;
        final int indxx2 = 6;

        boolean urgent = tokens[indxx].equals("y");
        String status = tokens[indxx2];
        return new Task(
                   title, assignedTo,
                   timeToComplete,
                   important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}




