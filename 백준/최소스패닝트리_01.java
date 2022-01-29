package 백준;

import java.io.*;
import java.util.*;

class 최소스패닝트리_Node implements Comparable<최소스패닝트리_Node>{
	int end, cost;
	public 최소스패닝트리_Node(int end, int cost) {
		this.end = end; this.cost = cost;
	}
	@Override
	public int compareTo(최소스패닝트리_Node o) {
		return this.cost<o.cost?-1:1;
	}

}

public class 최소스패닝트리_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int V = Integer.parseInt(str[0]), E = Integer.parseInt(str[1]);

		/* 그래프 형성 */
		ArrayList<ArrayList<최소스패닝트리_Node>> graph = new ArrayList<ArrayList<최소스패닝트리_Node>>();
		for (int i=0; i<=V; i++) graph.add(new ArrayList<최소스패닝트리_Node>());
		for (int i=0; i<E; i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]), e = Integer.parseInt(str[1]), c = Integer.parseInt(str[2]);
			graph.get(s).add(new 최소스패닝트리_Node(e, c));
			graph.get(e).add(new 최소스패닝트리_Node(s, c));
		}
		
		PriorityQueue<최소스패닝트리_Node> queue = new PriorityQueue<최소스패닝트리_Node>();
		queue.add(new 최소스패닝트리_Node(1, 0));
		
		int[] visited = new int[V+1];
		int total = 0;
		while(!queue.isEmpty()) {
			최소스패닝트리_Node node = queue.poll();
			if (visited[node.end]==1) continue;
			visited[node.end]=1;
			total+=node.cost;
			for (int i=0; i<graph.get(node.end).size();i++) {
				if (visited[graph.get(node.end).get(i).end]==0) { // 방문하지 않았다면
					queue.add(graph.get(node.end).get(i));
				}
			}
		}
		System.out.println(total);
		
		
		
		
	}
	

}
