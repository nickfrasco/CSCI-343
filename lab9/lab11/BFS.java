package lab11;

import java.util.Scanner;

public class BFS {
	
static Scanner sc = new Scanner(System.in);

static int[] x;
static int a = 1;
static int b = 1;

public static void main(String[] args) {
	int n = sc.nextInt();
	int[][] gr = new int[n+1][n];
	int[] d = new int[n+1];
	x = new int[n+1];

	for(int i = 0;i < n;i++) {
		int one = sc.nextInt();
		int two = sc.nextInt();
		d[one] = -1;
		for(int j = 0;j < two;j++) {
			gr[one][j] = sc.nextInt();
		}
	}
	d[1] = 0;
	x[0] = 1;

	func(gr,d);

	for(int i = 1;i <= n;i++) {
		System.out.println(i + " " + d[i]);
	}
}

static void func(int[][] mat,int[] var) {
	for(a = 0;a < b;a++) {
		
		int e = x[a];
		
		for(int i = 0;i < mat[e].length;i++) {
			int f = mat[e][i];
			if(var[f] == -1) {
				//System.out.println(d)
				var[f] = var[e] + 1;
				x[b++] = f;
			}
		}
	}
}
}
