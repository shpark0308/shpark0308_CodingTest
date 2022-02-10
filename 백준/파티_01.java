package 백준;

import java.util.*;
import java.io.*;

class 파티_01_Node implements Comparable<파티_01_Node>{
	int end, cost;
	public 파티_01_Node(int end, int cost) {
		this.end = end; this.cost = cost;
	}
	
	@Override
	public int compareTo(파티_01_Node node) {
		return this.cost<node.cost?-1:1;
	}

}


public class 파티_01 {
	public static int N, M, K;
	public static ArrayList<ArrayList<파티_01_Node>> graph = new ArrayList<ArrayList<파티_01_Node>>();
	public static int[][] DP;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); K = Integer.parseInt(str[2]);
		for (int i=0; i<=N; i++) graph.add(new ArrayList<파티_01_Node>());
		
		for (int i=0; i<M;i++) {
			str = br.readLine().split(" ");
			graph.get(Integer.parseInt(str[0])).add(new 파티_01_Node(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}
		
		DP = new int[N+1][N+1];
		for (int i=1; i<=N; i++) Arrays.fill(DP[i], Integer.MAX_VALUE);
		
		Queue<파티_01_Node> queue = new PriorityQueue<파티_01_Node>();
		queue.add(new 파티_01_Node(K, 0)); DP[K][K] = 0;
		
		for (int a=1; a<=N; a++) dijkstra(a);
		
		System.out.println("+++++++++++++++++++++++");
		for (int a=1; a<=N; a++) {
			if (a==K) continue;
			int sum = DP[a][K]+DP[K][a];
			max = Math.max(max, sum);
		}
		if (max==Integer.MAX_VALUE) max = 0;
		System.out.println(max);
		
	}
	public static void dijkstra(int K) {
		Queue<파티_01_Node> queue = new PriorityQueue<파티_01_Node>();
		queue.add(new 파티_01_Node(K, 0)); DP[K][K] = 0;
		
		while(!queue.isEmpty()) { /* 일단 가는것만 해보기 */
			파티_01_Node node = queue.poll();
			for (int i=0; i<graph.get(node.end).size();i++) {
				if (DP[K][graph.get(node.end).get(i).end]>DP[K][node.end]+graph.get(node.end).get(i).cost) {
					DP[K][graph.get(node.end).get(i).end] = DP[K][node.end]+graph.get(node.end).get(i).cost;
					queue.add(graph.get(node.end).get(i));
				}
			}
			Iterator<파티_01_Node> iter = queue.iterator();
			while(iter.hasNext()) {
				파티_01_Node nn = iter.next();
				System.out.print(nn.end+","+nn.cost+"  / ");
			}
			System.out.println();
			System.out.println(Arrays.toString(DP[K]));
			System.out.println("***********************");
		}
	}

}
