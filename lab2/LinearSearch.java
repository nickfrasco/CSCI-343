package lab2;
import java.util.*;

public class LinearSearch {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
			int number = 0;
			int answer = 0;
			int count = 0; 
			int q = 0;
			int x = 0; 
			
			int[] Y = new int[10001];
			
			number = in.nextInt();
			for (int i = 0; i < number; i++){
				Y[i] = in.nextInt(); }
			
			q = in.nextInt();
			
			for (int i = 0; i < q; i++){
				x = in.nextInt();
				Y[number] = x;
				
				count = 0;
				while (Y[count] != x) {
					count ++; }
				
				if (count < number){
					answer ++; }
			}
			
			System.out.println(answer);
	}

}
