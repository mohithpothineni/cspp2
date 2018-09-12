import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 * Class for patron.
 */
class Patron {
    /**
     * name of person.
     */
    private String name;

    /**
     * phonenum of person.
     */
    private String phonenum;

    /**
     * time of booking.
     */
    private String bookingtime;

    /**
     * name of movie.
     */
    private String moviename;

    /**
     * Constructs the object.
     *
     * @param      namee      The namee
     * @param      phonenumm  The phonenumm
     */
    Patron(final String namee, final String phonenumm) {
        this.name = namee;
        this.phonenum = phonenumm;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return phonenum + " " + moviename + " " + bookingtime;
    }

    /**
     * Gets the name of person.
     *
     * @return     The name.
     */
    String getName() {
        return this.name;
    }

    /**
     * Sets the name of person.
     *
     * @param      nameinp  The nameinp
     */
    void setName(final String nameinp) {
        this.name = nameinp;
    }

    /**
     * Gets the phonenum of person.
     *
     * @return     phonenum.
     */
    String getPhonenum() {
        return this.phonenum;
    }

    /**
     * Sets the phonenum of person.
     *
     * @param      phonenuminp  The nameinp
     */
    void setPhonenum(final String phonenuminp) {
        this.phonenum = phonenuminp;
    }

    /**
     * Gets the bookingtime.
     *
     * @return     bookingtime.
     */
    String getBookingtime() {
        return this.bookingtime;
    }

    /**
     * Sets the bookingtime.
     *
     * @param      bookingtimeinp  The bookingtime
     */
    void setBookingtime(final String bookingtimeinp) {
        this.bookingtime = bookingtimeinp;
    }

//moviename

    /**
     * Gets the moviename.
     *
     * @return     moviename.
     */
    String getMoviename() {
        return this.moviename;
    }

    /**
     * Sets the moviename.
     *
     * @param      movienameinp  The moviename
     */
    void setMoviename(final String movienameinp) {
        this.moviename = movienameinp;
    }



}

/**
 * Class for show.
 */
class Show {

    /**
     * name of movie.
     */
    private String movie;

    /**
     * datetime of show.
     */
    private String showdatetime;

    /**
     * seatnos for the talkie.
     */
    private String[] seatnos;

    /**
     * Constructs the object.
     *
     * @param      moviee         The moviee
     * @param      showdatetimee  The showdatetimee
     * @param      seatnoss       The seatnoss
     */
    Show(final String moviee, final String showdatetimee,
         final String[] seatnoss) {
        this.movie = moviee;
        this.showdatetime = showdatetimee;
        this.seatnos = seatnoss;
    }

    /**
     * Gets the movie.
     *
     * @return     The movie.
     */
    String getMovie() {
        return this.movie;
    }

    /**
     * Sets the movie.
     *
     * @param      nameofmovie  The nameofmovie
     */
    void setMovie(final String nameofmovie) {
        this.movie = nameofmovie;
    }

    /**
     * Gets the showdatetime.
     *
     * @return     The showdatetime.
     */
    String getShowdatetime() {
        return this.showdatetime;
    }

    /**
     * Sets the showdatetime.
     *
     * @param      datetimeinp  The datetimeinp
     */
    void setShowdatetime(final String datetimeinp) {
        this.showdatetime = datetimeinp;
    }






    /**
     * Determines if it has tickets.
     *
     * @param      ticketsinp  The ticketsinp
     *
     * @return     True if has tickets, False otherwise.
     */
    public boolean hasTickets(final String[] ticketsinp) {
        int count = 0;
        for (String i : ticketsinp) {
            for (String j : seatnos) {
                if (i.equals(j)) {
                    count++;
                    break;
                }
            }
        }

        return count != 0;
    }

    /**
     * clears the booked tickets with.
     * N/A.
     *
     * @param      booked  The booked.
     */
    public void book(final String[] booked) {
        for (String b : booked) {
            for (int i = 0; i < seatnos.length; i++) {
                if (b.equals(seatnos[i])) {
                    seatnos[i] = "N/A";
                    break;
                }
            }
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movie + "," + showdatetime;
    }

    /**
     * similar to toString.
     *
     * @return     different representation.
     */
    public String represent() {
        return movie + "," + showdatetime + ","
               + Arrays.toString(seatnos).replace(" ", "");
    }

}

/**
 * Class for book your show.
 */
class BookYourShow {

    /**
     * to store the talkies info.
     */
    private ArrayList<Show> shows = new ArrayList<Show>();

    /**
     * to store the bookings details.
     */
    private ArrayList<Patron> bookers = new ArrayList<Patron>();

    /**
     * Adds a show.
     *
     * @param      moviee         The moviee
     * @param      showdatetimee  The showdatetimee
     * @param      seatnoss       The seatnoss
     */
    public void addAShow(final String moviee, final String showdatetimee,
                         final String[] seatnoss) {
        Show showw = new Show(moviee, showdatetimee, seatnoss);
        shows.add(showw);
    }

    /**
     * Gets a show.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     *
     * @return     info about show.
     */
    public String getAShow(final String moviename, final String datetime) {
        for (Show s : shows) {
            if (s.getMovie().equals(moviename)
                    && s.getShowdatetime().equals(datetime)) {
                return s.toString();
            }
        }

        return "No show";
    }

    /**
     * book the show.
     *
     * @param      username   The username
     * @param      moviename  The moviename
     * @param      mobileno   The mobileno
     * @param      datetime   The datetime
     * @param      seatnos    The seatnos
     */
    public void bookAShow(final String username, final String moviename,
                          final String mobileno, final String datetime,
                          final String[] seatnos) {
        boolean flag = false;
        boolean dateflag = false;
        Show selected = null;
        int count = 0;


        for (Show s : shows) {
            if (s.getMovie().equals(moviename)
                    && s.hasTickets(seatnos)
                    && s.getShowdatetime().equals(datetime)) {
                selected = s;
                flag = true;
                dateflag = false;
                break;
            } else if (!s.getMovie().equals(moviename)) {
                count++;
            } else if (!s.getShowdatetime().equals(datetime)) {
                dateflag = true;
            }
        }

        if (flag) {
            Patron booker = new Patron(username, mobileno);
            bookers.add(booker);
            booker.setBookingtime(datetime);
            booker.setMoviename(moviename);
            selected.book(seatnos);
        }

        if (count == shows.size() || dateflag) {
            System.out.println("No show");
        }


    }

    /**
     * ticket info.
     *
     * @param      movienaam  The movienaam
     * @param      timings    The timings
     * @param      mobilenum  The mobilenum
     *
     * @return     represents the ticket details.
     */
    public String printTicket(final String movienaam,
                              final String timings, final String mobilenum) {
        //System.out.println(movienaam + " " + timings + " " + mobilenum);
        for (Patron p : bookers) {
            //System.out.println(p);
            if (p.getMoviename().equals(movienaam)
                    && p.getBookingtime().equals(timings)
                    && p.getPhonenum().equals(mobilenum)) {
                return p.toString();
            }
        }
        return "Invalid";
    }

    /**
     * Shows all info about shows.
     */
    public void showAll() {
        for (Show s : shows) {
            System.out.println(s.represent());
        }
    }

}

/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            //System.out.println(Arrays.toString(check));
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(check[1], tokens[1], seats);
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                //System.out.println(Arrays.toString(tokens));
                //System.out.println(Arrays.toString(seats));
                final int tmp = 3;
                bys.bookAShow(tokens[2], check[1],
                              tokens[tmp], tokens[1], seats);
                break;
            case "get":
                System.out.println(bys.getAShow(check[1], tokens[1]));
                break;
            case "print":
                //String movienaam, String timings, String mobilenum
                //System.out.println(Arrays.toString(tokens));
                System.out.println(bys.printTicket(check[1],
                                                   tokens[1], tokens[2]));
                break;
            case "showAll":
                bys.showAll();
                break;
            default:
                break;

            }
        }
    }
}


