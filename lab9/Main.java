import java.util.Scanner;

public class Main {
	
private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
	int n = sc.nextInt();
	String a,b;

	for(int i = 0;i < n;i++) {
	a = sc.next();
	b = sc.next();
	
	int[][] c = new int[a.length()+1][b.length()+1];
	
	for (int j = 1;j <= a.length();j++) {
		
		for (int k = 1;k <= b.length();k++) {
			
			if (a.charAt(j-1) == b.charAt(k-1)) {
				c[j][k] = c[j-1][k-1] + 1;
			}
			
			else {
				c[j][k] = Math.max(c[j-1][k], c[j][k-1]);
			}
		}
	}
	System.out.println(c[a.length()][b.length()]);
	}
}
}