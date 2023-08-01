package graph;
import java.util.*;
public class hashPath {
	
	static class Edge {
		int src;
		int dest;
		int wt;
		
		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
	
	static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0 ; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		//0 -vertex
		graph[0].add(new Edge(0, 1, 5));
		
		//1 -vertex
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));
		
		//2 -vetex
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 2));
		
		// 3-vertex
		graph[3].add(new Edge(3, 2, 1));
		graph[3].add(new Edge(3, 1, 3));
		
		//4 -vertex
		graph[4].add(new Edge(4, 2, 2));
	}
	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) { //O(V + E)
		if (src == dest)
			return true;
		
		vis[src] = true;
		for (int i = 0; i < graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			//e.dest = neighbour
			if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*
		 * 				(5)
		 * 			0---------1
		 * 					 / \
		 * 				(1) /   \(3)
		 * 				   2----3
		 * 			       | (1)
		 * 			  (2)  |
		 * 				   4
		 */
		int V = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V]; //null => empty arraylist
		createGraph(graph);
		System.out.println(hasPath(graph, 0, 4, new boolean[V]));
	}
}