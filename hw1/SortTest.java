package hw1;
import java.io.File;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;


//bubble sort - algorithm taken from geeksforgeeks -
//Had a bit of help with this from my brother!
public class SortTest {
	
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		File IN = new File("nums.txt");					// take in file
		Scanner in = new Scanner(IN);					//init scanner 
		
		int Sets = Integer.parseInt(in.nextLine());		//make Sets
		
		for (int i=0; i<Sets; i++) {					//init for loop using sets
			int k = Integer.parseInt(in.nextLine()); 	//parse w in
			String[] Nums = in.nextLine().split(" ");	// split up output - make it look pretty
			
			int[] arg = new int[Nums.length];			// make the arg to use in for loop
			
			for (int xy=0; xy<Nums.length; xy++) 
			arg[xy] = Integer.parseInt(Nums[xy]);
			
			
			short startTime = (short) System.currentTimeMillis();
			
			
			// alg Taken from geeksforgeeks
			for (int j=0; j<k-1; j++) {
				for (int x=0; x<k-j-1; x++) {
					if (arg[x] > arg[x+1]) 
					{ int temp = arg[x];
						arg[x] = arg[x+1];
						arg[x+1] = temp; } } } } }

}

//I chose bubble sort because it is the one I am not as good with so I wante dthe practice
// I also wanted to see how efficient it would be


