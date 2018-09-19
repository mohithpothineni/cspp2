
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for social network.
 */
class SocialNetwork {

    /**
     * treemap key,value ==> user,followers.
     */
    private TreeMap<String, LinkedHashSet<String>> graph;

    /**
     * Constructs the object.
     */
    SocialNetwork() {
        graph = new TreeMap<String, LinkedHashSet<String>>();
    }

    /**
     * Adds an user.
     *
     * @param      namee  The namee
     */
    void addUser(final String namee) {
        if (!graph.containsKey(namee)) {
            LinkedHashSet<String> connection = new LinkedHashSet<String>();
            graph.put(namee, connection);
        }
    }

    /**
     * Adds a connection to user.
     *
     * @param      usernamee  The usernamee
     * @param      otheruser  The otheruser
     * @param      flag       The flag
     */
    void addConnectionToUser(final String usernamee,
        final String otheruser, final boolean flag) {
        if ((graph.containsKey(otheruser)
                && graph.containsKey(usernamee)) || flag) {
            LinkedHashSet<String> connectionn = graph.get(usernamee);
            connectionn.add(otheruser);
            graph.put(usernamee, connectionn);
        } else {
            System.out.println("Not a user in Network");
        }

    }

    /**
     * Adds a connection to user.
     *
     * @param      usernamee   The usernamee
     * @param      otherusers  The otherusers
     * @param      flag        The flag
     */
    void addConnectionToUser(final String usernamee, final String[] otherusers,
                             final boolean flag) {
        for (String user : otherusers) {
            this.addConnectionToUser(usernamee, user, flag);
        }

    }

    /**
     * Gets the common connections.
     *
     * @param      s1    The key1.
     * @param      s2    The key2.
     *
     * @return     The common connections.
     */
    ArrayList<String> getCommonConnections(final String s1, final String s2) {
        ArrayList<String> result = new ArrayList<String>();
        LinkedHashSet<String> connectionn1 = graph.get(s1);
        LinkedHashSet<String> connectionn2 = graph.get(s2);

        if (connectionn1 != null && connectionn2 != null) {
            for (String i : connectionn1) {
                if (connectionn2.contains(i)) {
                    result.add(i);
                }
            }

            return result;
        }


        return null;
    }

    /**
     * Gets the connections.
     *
     * @param      s1    The key
     *
     * @return     The connections.
     */
    ArrayList getConnections(final String s1) {
        LinkedHashSet<String> connectionn1 = graph.get(s1);
        if (connectionn1 != null) {
            return new ArrayList<>(Arrays.asList(connectionn1.toArray()));
        }
        return null;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return graph.toString().replace("=", ": ")
               .replace("{", "").replace("}", "");
    }


}


/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * main function.
     *
     * @param      args  The commandline arguments
     */
    public static void main(final String[] args) {
        SocialNetwork sn = new SocialNetwork();
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.replace("is connected to", "isconnectedto")
                              .replace(", ", ",").replace(".", "").split(" ");
            if (tokens.length > 1) {
                if (tokens[1].equals("isconnectedto")) {
                    String tmp = tokens[0];
                    tokens[0] = tokens[1];
                    tokens[1] = tmp;
                }
            }
            switch (tokens[0]) {
            case "isconnectedto":
                String[] tokens2 = tokens[2].split(",");
                sn.addUser(tokens[1]);
                sn.addConnectionToUser(tokens[1], tokens2, true);
                break;
            case "addConnections":
                sn.addConnectionToUser(tokens[1], tokens[2], false);
                break;
            case "getConnections":
                ArrayList al = sn.getConnections(tokens[1]);
                if (al != null) {
                    System.out.println(al);
                } else {
                    System.out.println("Not a user in Network");
                }
                break;
            case "Network":
                System.out.println(sn);
                break;
            case "CommonConnections":
                System.out.println(
                    sn.getCommonConnections(tokens[1], tokens[2]));
                break;
            default:
                break;
            }
        }
    }
}


