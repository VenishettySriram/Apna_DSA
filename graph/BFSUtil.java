package graph;
import java.util.*;
public class BFSUtil {

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
	
	public static void bfs(ArrayList<Edge>[] graph) { //O(V+E)
		boolean vis[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i])
				bfsUtil(graph, vis);
		}
	}

	public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) { //O(V+E)
		Queue<Integer> q = new LinkedList<>();
		q.add(0); // source = 0
		while (!q.isEmpty()) {
			int curr = q.remove();
			if (!vis[curr]) { //vist curr
				System.out.print(curr + " ");
				vis[curr] = true;
				for (int i = 0; i < graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
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
		bfs(graph);
	}

}
