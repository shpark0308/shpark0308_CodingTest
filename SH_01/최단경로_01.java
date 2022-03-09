
import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int end, cost;
	public Node(int end, int cost) {
		this.end = end; this.cost = cost;
	}
	@Override
	public int compareTo(Node o){
		return this.cost - o.cost;
	}
	
}

public class 최단경로_01 {
	public static int V, E, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] DP;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		V = Integer.parseInt(str[0]); E = Integer.parseInt(str[1]);
		
		start = Integer.parseInt(br.readLine());
		
		for (int i=0; i<=V; i++) graph.add(new ArrayList<Node>());
		
		for (int i=0; i<E; i++) {
			str = br.readLine().split(" ");
			graph.get(Integer.parseInt(str[0])).add(new Node(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}
		
		Dijkstra();
		for (int i=1; i<=V; i++) {
			if (DP[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(DP[i]);
		}
	}
	
	public static void Dijkstra() {
		DP = new int[V+1]; visited = new boolean[V+1];
		Arrays.fill(DP, Integer.MAX_VALUE);
		
		Queue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
		DP[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (visited[node.end]) continue;
			visited[node.end] = true;
			
			for (int i=0; i<graph.get(node.end).size(); i++) {
				Node temp = graph.get(node.end).get(i);
				if (!visited[temp.end]&&DP[temp.end]>DP[node.end]+temp.cost) {
					DP[temp.end] = DP[node.end]+temp.cost;
					queue.add(new Node(temp.end, DP[temp.end]));
				}
			}
		}
	}

}
