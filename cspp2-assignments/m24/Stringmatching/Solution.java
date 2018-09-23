import java.util.Scanner;
import java.io.FileReader;
import java.io.File;

class StringMatching {


    public static String toText(File file) {
        String str = "";
        try {
            Scanner input = new Scanner(new FileReader(file));
            StringBuilder text = new StringBuilder();
            while (input.hasNext()) {
                text.append(input.next());
                text.append(" ");
            }
            input.close();
            str = text.toString();
        } catch (Exception e) {

        }
        return str;
    }

    public double compute(String docOne, String docTwo) {
        int lengthOne = docOne.length();
        int lengthTwo = docTwo.length();
        double totalLength = lengthOne + lengthTwo;
        int max = 0;
        double lcs = 0;
        final int hundred = 100;
        int[][] tmparray = new int[lengthOne][lengthTwo];
        for (int i = 0; i < lengthOne; i++) {
            for (int j = 0; j < lengthTwo; j++) {
                if (docOne.charAt(i) == docTwo.charAt(j)) {
                    if (i == 0 || j == 0) {
                        tmparray[i][j] = 1;
                    } else {
                        tmparray[i][j] = tmparray[i - 1][j - 1] + 1;
                    }
                    if (max < tmparray[i][j]) {
                        max = tmparray[i][j];
                    }
                }
            }
        }
        lcs = (((max * 2) / totalLength) * hundred);
        return lcs;
    }
}

public final class Solution {
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = null;
        try {
            input = scan.nextLine();    
        } catch (Exception e) {
            System.out.println("Empty Directory");
            return;
        }
        File files = new File(input);
        StringMatching obj = new StringMatching();
        File[] fileList = files.listFiles();
        int length = fileList.length;

        double maxValue = 0;
        final int hundred = 100;
        String result = "";

        double[][] fmatrix = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    fmatrix[i][j] = hundred;
                } else {
                    fmatrix[i][j] = obj.compute(
                                        obj.toText(fileList[i]), obj.toText(fileList[j]));
                    if (maxValue < fmatrix[i][j]) {
                        maxValue = fmatrix[i][j];
                        result = "Maximum similarity is between "
                                 + fileList[i].getName() + " and "
                                 + fileList[j].getName();
                    }
                }
            }
        }
        if (length != 0) {
            System.out.print("      \t");
        }

        for (int i = 0; i < length - 1; i++) {
            System.out.print("\t" + fileList[i].getName());
        }
        System.out.println();
        
        for (int i = 0; i < length; i++) {
            System.out.print(fileList[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(
                    String.format("%.1f", fmatrix[i][j]) + "\t\t");
            }
            System.out.println();
        }
        System.out.println(result);

    }
}

