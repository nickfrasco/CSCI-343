package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LCS {

    /* Main Method */
    public static void main(String[] args) {

        List<Pair> global_PairList;
        if (args.length != 0 && args[0] != null && args[0].length() != 0) {
            LCS objLCS = new LCS();
            global_PairList = objLCS.readFromFile(args[0]);

            if (!global_PairList.isEmpty()) {
                Long runningTime = objLCS.initiateLCSCalculation(global_PairList);

                objLCS.writeToFile(global_PairList, runningTime);

                System.out.println("\nPlease check ANSWERS.TXT file.");
            } else {
                System.out.println("\nNo Input Provided");
            }
        } else {
            System.out.println("\nPlease specify an input file !\n");
            return; }
    }

     //Description: Reads the input from the input file and then makes a 'Pair' of successive input strings.
    
    private List<Pair> readFromFile(String fileName) {
    	new Scanner(System.in);
    	File inputFile = new File(fileName);
        List<Pair> pairLists = new ArrayList<>();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(inputFile));
            String readLine;
            String nextLine;
            
            
            
            while ((readLine = buffReader.readLine()) != null) {
                nextLine = buffReader.readLine();
                if (nextLine != null && readLine.length() != 0) {
                	if (readLine.startsWith(">") || nextLine.startsWith(">")) {
                		readLine = nextLine;
                		nextLine = buffReader.readLine();}
                    Pair pair = new Pair(readLine, nextLine);
                    pairLists.add(pair);
                }
            }

            buffReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairLists;
    }
    
      //Measures the performance of the algorithm.
    private long initiateLCSCalculation(List<Pair> pairsList) {
        long startTime = System.currentTimeMillis();

        for (Pair tempPair : pairsList) {
            doLCS(tempPair);
        }
        return (System.currentTimeMillis() - startTime); }

   
     // Performs the actual LCS calculation on a Pair The LCS and LCS Length are stored in the pair itself.
    private static void doLCS(Pair tempPair) {
        String input1 = tempPair.input2;
        String input2 = tempPair.input1;
        int m = input1.length();
        int n = input2.length();
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            L[i][0] = 0;
        }

        for (int j = 0; j < n; j++) {
            L[0][j] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input1.charAt(i) == input2.charAt(j)) {
                    L[i + 1][j + 1] = L[i][j] + 1;
                } else {
                    L[i + 1][j + 1] = Math.max(L[i][j + 1], L[i + 1][j]);
                }
            }
        }
        
        int lcs_len = L[m][n];
        int idx = lcs_len;
        char[] lcs = new char[lcs_len];

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                lcs[idx - 1] = input1.charAt(i - 1);
                i--;
                j--;
                idx--;
            } else {
                if (L[i - 1][j] > L[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        tempPair.strLCS = new String(lcs);
        tempPair.lengthLCS = lcs_len;
    }
   
    //Writes the Input Strings
    private void writeToFile(List<Pair> pairList, Long runningTime) {
        BufferedWriter buffWrite;
        FileWriter fWriter = null;

        try {
            File fileName = new File("medianOutput.txt");			//change for median and small txt

            if (!fileName.exists()) {
                fileName.createNewFile();
            }

            fWriter = new FileWriter(fileName);

            buffWrite = new BufferedWriter(fWriter);

            for (Pair tempPair : pairList) {
                buffWrite.write(tempPair.toString());
            }

            buffWrite.write("\n\nRunning Time is:\t\t" + runningTime + " ms");

            buffWrite.close();
        } catch (IOException ex) {
            System.out.println("\n\t\t** There is an ERROR in ANSWER.TXT file creation **\n\nError Trace is >:\n\n");
            ex.printStackTrace();
        }
    }

    private class Pair {
        private String input1;
        private String input2;
        private String strLCS;
        private int lengthLCS;

        private Pair(String input1, String input2) {
            this.input1 = input1;
            this.input2 = input2;
            strLCS = null;
            lengthLCS = 0;
        }

        @Override
        public String toString() {
            String outString = "Length of LCS is:\t" + lengthLCS;
            return  outString;
        }
    }
}
