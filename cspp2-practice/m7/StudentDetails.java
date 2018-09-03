
/**
 * StudentDetails program.
 */

/**
 * StudentDetails class.
 */
public final class StudentDetails {

    /**
     * Constructs the object.
     */
    private StudentDetails() {

    }

    /**
     *  main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        //for clearing the magic number error
        final double s1sub1 = 7.5;
        final double s1sub2 = 7.0;
        final double s1sub3 = 8.0;
        final double s2sub1 = 8.5;
        final double s2sub2 = 6.0;
        final double s2sub3 = 7.5;
        final double s3sub1 = 7.5;
        final double s3sub2 = 8.0;
        final double s3sub3 = 9.0;


        Student s1 = new Student("Sangay", "IT201985001",
            s1sub1, s1sub2, s1sub3);
        Student s2 = new Student("Bidhya", "IT201985003",
            s2sub1, s2sub2, s2sub3);
        Student s3 = new Student("Kelzang", "IT201985065",
            s3sub1, s3sub2, s3sub3);

        Student[] s = {s1, s2, s3};

        for (Student i : s) {
            System.out.printf("%.1f\n", i.getGPA());
        }

    }

}

/**
 * Student class.
 */
final class Student {
    /**
     * name and rollcall.
     */
    private final String namestd, rollnostd;

    /**
     * subject marks.
     */
    private final double sub1, sub2, sub3;

    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      rollno  The rollno
     * @param      score1  The score 1
     * @param      score2  The score 2
     * @param      score3  The score 3
     */
    Student(final String name, final String rollno, final double score1,
        final double score2, final double score3) {
        namestd = name;
        rollnostd = rollno;
        sub1 = score1;
        sub2 = score2;
        sub3 = score3;
    }

    /**
     * Gets the gpa.
     *
     * @return     The gpa.
     */
    public float getGPA() {
        final int dividor = 3;
        return (float) (sub1 + sub2 + sub3) / dividor;
    }

}
