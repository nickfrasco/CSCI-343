package hw1;

import java.util.Scanner;
import java.util.*;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;



public class Simulator {

	public static void main(String[] args) throws IOException {
		
		File file = new File("nums.txt");
		PrintWriter printWriter = new PrintWriter(file); 
		
		Random rnd = new Random(); 				//init random
		Scanner in = new Scanner(System.in);	// init scanner
		int num = in.nextInt();					// init num
		
		
		for (int i=1; i<=num;i++)	{
			if (in.hasNext())	{							
			int length = in.nextInt();	
			int[] newNumSet = new int [length] ; 
	    	
			
			System.out.println(length); 
			
			for (int j=0; j<length; j++) {
				int temp = rnd.nextInt(10000);
				newNumSet[j]=temp; }							

			for(int u=0; u<length; u++) {					
				System.out.print(newNumSet[u] + "  ");  }
			
			File file1 = new File("nums.txt");
			PrintWriter results = new PrintWriter(file1);
			
			
			//for (int num1 : newNumSet ) {
			//	printWriter.print(num1); }
			
			
			}
			printWriter.println();
			printWriter.close();
			//System.out.print(java.util.Arrays.toString(newNumSet)); 
			}
	}
		}
	

			
		
			
			
		
	

