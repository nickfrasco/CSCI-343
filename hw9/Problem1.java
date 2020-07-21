package hw9;

import java.util.*;

public class Problem1 {
	
	static int algorithm1(int[] x) {
		int max_value = Integer.MIN_VALUE;
		for(int i = 0; i < x.length - 1; i++) {
			for(int j = i + 1; j < x.length; j++) {
				if(x[j] - x[i] > max_value) {
					max_value = x[j] - x[i];
				}
			}
		}
		if (x.length < 2){ return 0; }
		return max_value;
	}
	
	static int algorithm2(int[] y) {
		if (y.length < 2) { return 0; }
		
		int min_Val = y[0];
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i < y.length; i++) {
			if(y[i] - min_Val > max) {
				max = y[i] - min_Val; }
			if (y[i] < min_Val) {
				min_Val = y[i]; }	
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] var = new int[Integer.parseInt(sc.nextLine())];
		for(int i = 0; i < var.length; i++) {
			var[i] = Integer.parseInt(sc.nextLine());
		}
		System.out.println(algorithm1(var));
		System.out.println(algorithm2(var));
	}
}
