package lab1;

import java.util.Scanner;
import java.util.*;

public class RandomDNA {

	public static void main(String[] args) {
		String string = "";
		Scanner in = new Scanner(System.in);
		int Length = in.nextInt();
		
		
		for(int l = 1; l<=Length; l++) {
			Random rnd = new Random();
			int t = rnd.nextInt(4);
			char[] selections = {'A', 'T', 'C', 'G'}; //made a char[] for ease of use 
			string = string + selections[t]; //making char selections
		}
		
		System.out.println(string);
		
	}
}

