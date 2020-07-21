package hw2;


import java.util.Scanner;

public class GreatestCommonDivisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int One = sc.nextInt();
		int Two = sc.nextInt();

		int x = Math.max(One, Two);
		int y = Math.min(One, Two);

		while (x%y!=0) {
			int z = x%y;
			x=y;
			y=z;
		}
		System.out.println(y);
	}

}