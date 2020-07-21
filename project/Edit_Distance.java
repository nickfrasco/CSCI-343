package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Edit_Distance {

	public static String x, y;
	public static int[][] table;
	public static int editdis;
	Scanner sc = new Scanner(System.in), fileIn;
    public static String fileName;
	
	
	 public static String ReadFile() throws FileNotFoundException {

	        boolean first = true;

	        try (Scanner sc = new Scanner(new File(fileName))) {
	            while (sc.hasNextLine()) {
	                String line = sc.nextLine().trim();
	                if (line.charAt(0) == '>') {
	                    if (first)
	                        first = false;
	                    else
	                        return null;
	                    return line.substring(1);
	                } else {
	                    return line;
	                }
	            }
	        }
			return null;
	    }

	//Constructs the edit distance table
	public static void Edit_Distance() {
		int gapX, gapY, sub;
		table = new int[x.length() + 1][y.length() + 1];

		//Initialize the boundary values
		table[0][0] = 0;
		for (int i = 1; i <= x.length(); i++)
			table[i][0] = table[i - 1][0] + 2;
		for (int j = 1; j <= y.length(); j++)
			table[0][j] = table[0][j - 1] + 2;

		//Build the table
		for (int i = 1; i <= x.length(); i++) {
			for (int j = 1; j <= y.length(); j++) {
				//Cost if no gap inserted
				if (x.charAt(i - 1) == y.charAt(j - 1))
					sub = table[i - 1][j - 1];		
				else
					sub = table[i - 1][j - 1] + 1;
				gapX = table[i][j - 1] + 2;							//Cost if insert gap in x
				gapY = table[i - 1][j] + 2;							//Cost if insert gap in y
				//Find the minimum of the 3 costs
				table[i][j] = Math.min(Math.min(gapX, gapY), sub);
			}
		}
		editdis = table[x.length()][y.length()];					//Get edit distance
	}

	//Trace back table and construct new sequences
	public static void TraceBack() {
		StringBuilder sbX = new StringBuilder(x), sbY = new StringBuilder(y);
		int i = x.length(), j = y.length();

		//Iterate until back at origin [0,0]
		while (i != 0 && j != 0) {
			if (table[i][j] == table[i][j - 1] + 2) {				//left 1
				sbX.insert(i, '-');
				j--;
			}
			else if (table[i][j] == table[i - 1][j] + 2) { 			//up 1
				sbY.insert(j, '-');
				i--;
			}
			else {													// diagonally
				i--;
				j--;
			}
			if (i == 0 && j > 0) {									//down 1
				sbX.insert(0, '-');
				i++;
			}	
			else if (i > 0 && j == 0) {  							//right 1
				sbY.insert(0, '-');
				j++;
			}
		}
		x = sbX.toString();
		y = sbY.toString();
	}

	public static void printAlign() {
		int cost;
		
      for (int i =0; i < x.length(); i++) {
      	if (x.charAt(i) == y.charAt(i))
      		cost = 0;
      	else {
      		if (x.charAt(i) != '-' && y.charAt(i) != '-')
      			cost = 1;
      		else
      			cost = 2;
      	}
	      System.out.println(x.charAt(i)+" "+y.charAt(i)+" "+cost);
   	}
	}

	public static void main(String args[]) {
	  Scanner sc = new Scanner(System.in), fileIn;
      //String fileName;
        
      try {
         System.out.print("Enter input file name: ");
         fileName = sc.next();
         fileIn = new Scanner(new FileInputStream(new File(fileName)));
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found!");
         return;
      }
      
      ///////////////////////////// make sure its readable
      x = fileIn.nextLine();
      y = fileIn.nextLine();
     //////////////////////////////
      
      
      Edit_Distance();
      TraceBack();

      System.out.println("Edit Distance = " + editdis);
      //System.out.print("Print alignment? (y/n): ");
     // if(sc.next().charAt(0) == 'y')
     // 	printAlign();
	}

    public int getEditDistance(String x, String y){
        this.x =x;
        this.y = y;
        Edit_Distance();
        TraceBack();
        return editdis;
    }
}
