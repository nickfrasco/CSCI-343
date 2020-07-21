package lab10;

//template code, C343, 2019
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

class Graph {
	private int totalVertex;
	private LinkedList<LinkedList<Integer>> adjList;
	//adjacency list of edges
	public Graph() { totalVertex = 0; }
	public void loadAdjList() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjList = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < totalVertex; i ++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			int idx1 = in.nextInt() - 1;
			int degree = in.nextInt();
			//System.out.println("mark idx1 = " + idx1 + " degree = " + degree);
			for(int j = 0; j < degree; j ++) {
				int idx2 = in.nextInt() - 1;
				tmp.add(idx2);
			}	
			adjList.add(tmp);
		}
		in.close();
	}
	public void printAdjMatrix() {
		int[][] adjMatrix = new int[totalVertex][totalVertex];
		
		//complete the following
		System.out.println("Adjancency Matrix: ");
		
		for (int i = 0; i < adjList.size(); i++) {
			for (int x = 0; x < adjList.get(i).size(); x++) {
				adjMatrix[i][adjList.get(i).get(x)] = 1;
			}
		}
		for (int i = 0; i < totalVertex; i++) {
			String print = "";
			
			for (int x = 0; x < totalVertex; x++) {
				//System.out.println("i: " + i + " x: " + x);
				print += adjMatrix[i][x];
				if (x < totalVertex - 1) {
					print += " "; }
			}
			
			System.out.println(print);
		}
		
	}
}

//change class name GraphRepresentation to Main() for submission to AIZU
public class GraphRepresentation {
	public static void main(String argv[]) {
		long start = System.currentTimeMillis();;
		Graph g = new Graph();
		g.loadAdjList();
		g.printAdjMatrix();
	    long end = System.currentTimeMillis();;

	    System.out.println((end - start) + " ms");
	}
}