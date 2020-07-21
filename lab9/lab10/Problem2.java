package lab10;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 dynPro = new Problem2();
	}
	public int min_Num(int x,int y,int z) {
		if(x <= y && x <= z) { return x; }
		if(y <= x && y <= z) { return y; }
		else { return z; }	
	}
	public Problem2() {
		Scanner sc = new Scanner(System.in);
		String string_one = sc.next();
		String string_two = sc.next();
		System.out.println(finalDist(string_one, string_two));
	}
	
	public int finalDist(String string_one, String string_two) {
		int k = string_one.length();					//take first length
		int j = string_two.length();					//take second
		int[][] distance = new int[k+1][j+1];		//put into 
		
		for(int i=0; i <= j; i++) {
			distance[i][0] = 0;
		}
		for(int n = 0; n <= j; n++) {
			distance[0][n] = 0;
		}
		for(int i = 1; i <= k; i++) {
			for(int x = 1; x <= j; x++) {
				int g = 0;
				if (string_one.charAt(i-1) != string_two.charAt(x-1))
					g = 1;
					distance[i][x] = g + min_Num(distance[i-1][x-1], 
									g + distance[i-1][x], 
									g + distance[i][x-1]);
			}
		}
		return distance[k][j] - 1;
	}
}

