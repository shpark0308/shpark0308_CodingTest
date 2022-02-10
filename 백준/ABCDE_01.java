package น้มุ;

import java.util.*;

public class ABCDE_01 {
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] visited;
	public static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		visited = new int[N];
		
		for (int i=0; i<N; i++) graph.add(new ArrayList<Integer>());
		
		for (int i=0; i<M; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			graph.get(a).add(b); graph.get(b).add(a);
		}
		
		for (int i=0; i<N; i++) {
			int[] visited = new int[N];
			dfs(visited, 5, i);
		}
		System.out.println(answer);
	}
	public static void dfs(int visited[], int index,int current) {
		if (index==0) {
			answer = 1;
			return;
		}
		if (answer==1) return;
		for (int i=0; i<graph.get(current).size(); i++) {
			if (visited[graph.get(current).get(i)]==0) {
				visited[graph.get(current).get(i)]=1;
				dfs(visited, index-1, graph.get(current).get(i));
				visited[graph.get(current).get(i)]=0;
			}
		}
	}
	
	
}
