import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


class BagOfWords {

    String[] document1;
    String[] document2;
    String[] combined;

    BagOfWords(String[] doc1, String[] doc2) {
        this.document1 = doc1;
        this.document2 = doc2;
        this.combined = new String[doc1.length + doc2.length];

        int size = 0;
        for (String i : doc1) {
            combined[size++] = i;

        }

        for (String i : doc2) {
            combined[size++] = i;

        }

    }

    int count(String[] doc, String word) {
        int count = 0;
        for (String i : doc) {
            if (i.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }




    HashMap<String, Integer> computeSeqFrequency(String[] doc1, String[] doc2) {
        HashMap<String, Integer> seq = new HashMap<String, Integer>();
        for (String i : doc2) {
            int countt = this.count(doc1, i);
            if (!seq.containsKey(i.toLowerCase())) {
                seq.put(i.toLowerCase(), countt);
            }
        }

        //System.out.println(seq);
        return seq;
    }

    double euclideanNorm(HashMap<String, Integer> seq) {

        double en = 0;

        for (int i : seq.values()) {
            en += Math.pow(i, 2);
        }

        return Math.sqrt(en);
    }



    double dotProduct(HashMap<String, Integer> seq1, HashMap<String, Integer> seq2) {
        double result = 0;
        for (String key : seq1.keySet()) {
            result += seq1.get(key) * seq2.get(key);
        }

        return result;
    }


    double computeFrequency() {
        if (this.document1.length == 1 || this.document2.length == 1) {
            return 0.0;
        }
        HashMap<String, Integer> s1 = computeSeqFrequency(this.document1, this.combined);
        HashMap<String, Integer> s2 = computeSeqFrequency(this.document2, this.combined);

        return  dotProduct(s1, s2) / (euclideanNorm(s1) * euclideanNorm(s2));
    }



}


class Solution {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String inputfolder;

        try {
            inputfolder = scan.nextLine();
        } catch (Exception e) {
            System.out.println("empty directory");
            return;
        }
        
        File folder = new File(inputfolder);
        File[] listOfFiles = folder.listFiles();



        String[] docs = new String[listOfFiles.length];
        int i = 0;
        try {
            for (File f : listOfFiles) {
                docs[i++] = new String(Files.readAllBytes(Paths.get(f.toString())));
            }
        } catch (IOException e ) {

        }

        String tmp_header = "         " + "\t";
        for (File f : listOfFiles) {
            tmp_header += f.getName() + "\t";
        }

        System.out.println(tmp_header);

        double maxValue = 0;
        String resultt = "";


        int indxx = 0;
        int ii = 0;
        for (String inp : docs) {
            
            String[] s1 = inp.split(" ");

            System.out.print(listOfFiles[indxx++].getName() + "\t");
            int jj = 0;
            for (String j : docs) {
                String[] s2 = j.split(" ");
                BagOfWords bw = new BagOfWords(s1, s2);

                double result = bw.computeFrequency();
                if (maxValue < result && ii != jj) {
                        maxValue = result;
                        resultt = "Maximum similarity is between "
                                 + listOfFiles[ii].getName() + " and "
                                 + listOfFiles[jj].getName();
                    }
                System.out.print(Math.round(result * 100));
                System.out.print(" " + "\t");
                jj++;
            }
            System.out.println();
            ii++;
        }
        System.out.println(resultt);
    }
}






