import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
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
			if(!seq.containsKey(i.toLowerCase())) {
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
		HashMap<String, Integer> s1 = computeSeqFrequency(this.document1, this.combined);
		HashMap<String, Integer> s2 = computeSeqFrequency(this.document2, this.combined);
		
		return 	dotProduct(s1,s2) / (euclideanNorm(s1) * euclideanNorm(s2));
	}
	
	
	
}



class StringMatching {
	
	String[] doc1;
	String[] doc2;
	
	
	StringMatching(String[] document1, String[] document2) {
		this.doc1 = document1;
		this.doc2 = document2;
	}
	
	double compute() {
		
		double lcs = 0;
        int count = 0;
		for (String i : this.doc1) {
			Pattern p = Pattern.compile(i,Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(Arrays.toString(this.doc2).replace("[","").replace("]","").replace(",",""));
			
			while (m.find()) {
                count++;
				if (lcs < i.length()){
                    lcs = i.length();
                }
			}
			
		}
		
		double length = Arrays.toString(this.doc1).replace("[","").replace("]","").replace(",","").length() +
						Arrays.toString(this.doc2).replace("[","").replace("]","").replace(",","").length();
		
		return lcs * count * 100 / length;
	}
	
	
}


class Solution {
	
	public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
        	String inputfolder = scan.nextLine();
            
            File folder = new File(inputfolder);
            File[] listOfFiles = folder.listFiles();
            
            if (listOfFiles.length == 0) {
                System.out.println("empty directory");
                return;
            }
            
            String[] docs = new String[listOfFiles.length];
        	int i = 0;
            try {
            	for (File f : listOfFiles) {
            		docs[i++] = new String(Files.readAllBytes(Paths.get(f.toString())));
            	}
            } catch (IOException e ) {
            	
            }
            
            /*
            ArrayList<String> tmpp2 = new ArrayList<String>();
        	tmpp2.add("");
        	*/
            
            
            for (String inp : docs) {
            	/*inp = inp.replaceAll("[^a-zA-Z0-9_ ]", " ");
            	*/
                String[] s1 = inp.split(" ");
            	/*
            	ArrayList<String> tmpp = new ArrayList<String>(Arrays.asList(s1));
            	tmpp.removeAll(tmpp2);
            	
            	s1 = (String[]) tmpp.toArray(new String[0]); 
            	
            	System.out.println(Arrays.toString(s1));
            	*/
            	for (String j : docs) {
            		/*j = j.replaceAll("[^a-zA-Z0-9_ ]", " ");
                	*/
                    
                	String[] s2 = j.split(" ");
                	/*
                	tmpp = new ArrayList<String>(Arrays.asList(s2));
           
                	tmpp.removeAll(tmpp2);
                	
                	s2 = (String[]) tmpp.toArray(new String[0]); 
                	*/
            		BagOfWords bw = new BagOfWords(s1,s2);
            		
            		double result = bw.computeFrequency();
            		System.out.print(Math.round(result * 100));
                    System.out.print(" " + "\t");
            	}
                System.out.println();
            }
            
            
            return;
        }
	}
}





