//Used Geeksforgeeks and Baeldung

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

class Graph {
	private int totalVertex;
	//adjMatrix[u][v] = 1 if there is an edge from u to v, otherwise 0
	private int[][] adjMatrix;
	//adjWeight[u][v] -- the weight of the edge from u to v if there is one
	private int[][] adjWeight;
	//if a node is settled (e.g., processed in the Dijkstra's algorithm)
	private Boolean[] ifSettled;
	public Graph() { totalVertex = 0; }
	public int getTotalVertex() { return totalVertex; }
	//load graph from standard input
	public void loadAdjMatrix() {
		Scanner in = new Scanner(System.in);
		totalVertex = in.nextInt();
		adjMatrix = new int[totalVertex][totalVertex];
		adjWeight = new int[totalVertex][totalVertex];
		ifSettled = new Boolean[totalVertex];
		int i, j;
		for(i = 0; i < totalVertex; i ++) {
			ifSettled[i] = false;
			for(j = 0; j < totalVertex; j ++) {
				adjMatrix[i][j] = adjWeight[i][j] = 0;
			}
		}
		int u, v;
		for(i = 0; i < totalVertex; i ++) {
			u = in.nextInt();
			int degree = in.nextInt();
			for(j = 0; j < degree; j ++) {
				v = in.nextInt(); 
				adjMatrix[u][v] = 1;
				adjWeight[u][v] = in.nextInt();
			}	
		}
		in.close();
	}
	//return weight of the edge from u to v if there is one
	public int getWeight(int u, int v) {
		return adjWeight[u][v];
	}
	//return neighbors of u as a LinkedList
	public LinkedList<Integer> getNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if(adjMatrix[u][v] == 1) tmp.add(v);
		}
		return tmp;
	}
	//return unsettled neighbors of u as a LinkedList
	public LinkedList<Integer> getUnsettledNeighbors(int u) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int v = 0; v < totalVertex; v ++) {
			if((adjMatrix[u][v] == 1) && (ifSettled[v] == false)) tmp.add(v);
		}
		return tmp;
	}
	//return the unsettled node that has the smallest dist
	public int getUnsettledNearest(int[] dist) {
		int md = Integer.MAX_VALUE;
		int mv = -1;
		int v;
		for(v = 0; v < totalVertex; v ++) {
			if((ifSettled[v] == false) && (dist[v] < md)) {
				md = dist[v];
				mv = v;
			}
		}
		return mv;
	}
	//implement the following	
	public int[] Dijkstra(int s) {
		

		int[] distance = new int[totalVertex];
		for(int i = 0;i<distance.length;i++)
		{ if(i == s)
			{ distance[i] = 0; }
			else
			{ distance[i]= Integer.MAX_VALUE; }
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while(queue.size()!= totalVertex)
		{
			int n = getUnsettledNearest(distance);
			ifSettled[n] = true;
			queue.add(n);
			LinkedList<Integer> neighbors = getUnsettledNeighbors(n);
			for(int current: neighbors)
			{
				if(distance[n] + getWeight(n,current) < distance[current])//if min distance is found, replace
				{
					distance[current] = getWeight(n,current) + distance[n];
				}
		}	
		}
		return distance;
	}
		
			

	}
}

public class DijkstraMain {
	public static void main(String[] argv) {
		long start = System.currentTimeMillis();;
		Graph g = new Graph();
		g.loadAdjMatrix();
		int[] dist = g.Dijkstra(0);
		for(int i = 0; i < g.getTotalVertex(); i ++) {
			System.out.println(i + " " + dist[i]);
		}
		long end = System.currentTimeMillis();;

	    System.out.println((end - start) + " ms");
	}
}
