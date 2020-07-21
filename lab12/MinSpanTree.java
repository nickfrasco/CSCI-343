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
		int v;
		for(i = 0; i < totalVertex; i ++) {
			for(j = 0; j < totalVertex; j ++) {
				v = in.nextInt(); 
				//if (v>0) 
				//{
				//adjWeight[i][j] = 1;
				//}
				adjWeight[i][j] = v;
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
		int[] dist = new int[totalVertex];
		for(int i = 0;i<dist.length;i++)
		{ 
			if(i == s) 
			{ dist[i] = 0; }									//make equal 0
			else
			{ dist[i] = Integer.MAX_VALUE; }					//max value
		}
		LinkedList<Integer> list = new LinkedList<Integer>();	//init queue
		while (list.size()!= totalVertex) {
			int x = getUnsettledNearest(dist);
			//System.out.println(x);
			ifSettled[x] = true;
			list.add(x);
			//System.out.println(list);
			LinkedList<Integer> neighbor_list = getUnsettledNeighbors(x);
			for (Integer current_num : neighbor_list)
			{
				if(getWeight(x,current_num) < dist[current_num])
				{
					dist[current_num] = getWeight(x,current_num);
				}
				}
		}
		return dist;
	}	
	}

public class MinSpanTree {
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
