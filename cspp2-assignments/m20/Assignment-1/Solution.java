


import java.util.Scanner;

/**
 * Class for question.
 */
class Question {

    /**
     * question text.
     */
    private String questiontext;

    /**
     * cjhoices for the question.
     */
    private String[] choices;

    /**
     * correct answer for question.
     */
    private int correctAnswer;

    /**
     * max mark for correct responce.
     */
    private int maxMarks;

    /**
     * penalty for wrong answer.
     */
    private int penalty;

    /**
     * responce from participant.
     */
    private String response;

    /**
     * Constructs the object.
     */
    Question() {

    }

    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctAnswer1,
             final int maxMarks1, final int penalty1) {
        this.questiontext =  question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
    }

    /**
     * evaluates the responce.
     *
     * @param      choice  The choice
     *
     * @return     true if correct else false.
     */
    public boolean evaluateResponse(final String choice) {
        return this.getCorrectAnswer().equals(choice);
    }

    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return this.choices[this.correctAnswer - 1];
    }

    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }

    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }

    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }

    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }

    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }

    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = this.getQuestionText()
        + "(" + this.getMaxMarks() + ")" + "\n";

        for (int i = 0; i < this.choices.length - 1; i++) {
            s += this.choices[i] + "\t";
        }

        s += this.choices[this.choices.length - 1] + "\n";

        return s;
    }
}

/**
 * Class for quiz.
 */
class Quiz {

    /**
     * default size for question array.
     */
    private final int onehundred = 100;

    /**
     * questions array.
     */
    private Question[] questions;

    /**
     * size for question array.
     */
    private int size;

    /**
     * Constructs the object.
     */
    Quiz() {
        this.questions = new Question[this.onehundred];
    }

    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        this.questions[size++] = q;
    }

    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return this.questions[index];
    }

    /**
     * Shows the report.
     *
     * @return     String represention of result.
     */
    public String showReport() {
        int score = 0;

        String s = "";


        for (int i = 0; i < this.size; i++) {
            s += questions[i].getQuestionText() + "\n";
            if (questions[i].evaluateResponse(questions[i].getResponse())) {
                s += " Correct answer! - Marks Awarded: "
                + questions[i].getMaxMarks() + "\n";
                score += questions[i].getMaxMarks();
            } else {
                s += " Wrong Answer! - Penalty: "
                + questions[i].getPenalty() + "\n";
                score += questions[i].getPenalty();
            }


        }

        s += "Total Score: " + score;

        return s;
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
        // leave this blank
    }

    /**
     * flag for error checking.
     */
    private static boolean noprobInLoadque = true;

    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }

    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class

        if (q <= 0) {
            noprobInLoadque = false;
            System.out.println("Quiz does not have questions");
            return;
        }


        try {


            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] tokens = line.split(":");

                if (tokens[0].equals("")) {
                    System.out.println("Error! Malformed question");
                    noprobInLoadque = false;
                    return;
                }

                final int minlength = 17;

                if (tokens[1].length() < minlength) {
                    System.out.println(tokens[0]
                        + " does not have enough answer choices");
                    noprobInLoadque = false;
                    return;
                }

                final int maxchoiceno = 4;

                if (Integer.parseInt(tokens[2]) > maxchoiceno) {
                    System.out.println("Error! Correct answer choice number "
                        + "is out of range for question text " + (i + 1));
                    noprobInLoadque = false;
                    return;
                }

                final int minmarknum = 0;

                final int marksindex = 3;

                if (Integer.parseInt(tokens[marksindex]) < minmarknum) {
                    System.out.println("Invalid max marks for " + tokens[i]);
                    noprobInLoadque = false;
                    return;
                }

                final int maxpenalty = 0;

                final int penaltyindex = 4;

                if (Integer.parseInt(tokens[penaltyindex]) > maxpenalty) {
                    System.out.println("Invalid penalty for " + tokens[i]);
                    noprobInLoadque = false;
                    return;
                }



                quiz.addQuestion(new Question(tokens[0], tokens[1].split(","),
                Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[marksindex]),
                Integer.parseInt(tokens[penaltyindex])));
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! Malformed question");
            noprobInLoadque = false;
            return;
        }

        System.out.println(q + " are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object

        if (!noprobInLoadque) {
            return;
        }

        for (int i = 0; i < q; i++) {

            Question que = quiz.getQuestion(i);
            System.out.println(que);

            String line = scan.nextLine();
            que.setResponse(line);

        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.

        if (!noprobInLoadque) {
            return;
        }

        System.out.println(quiz.showReport());
    }
}


