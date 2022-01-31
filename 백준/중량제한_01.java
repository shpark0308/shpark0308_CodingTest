package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class 중량제한_01 {
	// 시간 초과
	public static int N,M, start, end;
	public static boolean[] visited;
	public static ArrayList<ArrayList<중량제한_01_Node>> array = new ArrayList<ArrayList<중량제한_01_Node>>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;
		for (int i=0; i<N+1; i++) array.add(new ArrayList<중량제한_01_Node>());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken()); int w = Integer.parseInt(st.nextToken());
			array.get(s).add(new 중량제한_01_Node(e, w)); // 양방향 그래프
			array.get(e).add(new 중량제한_01_Node(s, w));
			max = Math.max(max, w);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());

		/* 이분탐색으로 최대 중량값을 찾기 : (1 ≤ C ≤ 1,000,000,000) 임으로 적절한 최대 중량값을 이분탐색으로 찾아냄 */
		int left = 0,right = max;
		while(left<=right) {
			int mid = (right+left/2);
			if (check(mid)) left=mid+1;
			else right = mid-1;
		}
		System.out.println(right);
		
	}
	public static boolean check(int target) {
		/* 다익스트라 알고리즘 만들기 */
		Queue<Integer> queue = new LinkedList<>(); // 다익스트라 알고리즘은 priority queue를 사용해야한다.
		queue.add(start);
		visited = new boolean[N+1];
		
		while(!queue.isEmpty()) {
			int node = queue.poll();

			
			if (node == end) return true;
			
			for (int i=0; i<array.get(node).size();i++) {
				if (!visited[array.get(node).get(i).end]&&target<=array.get(node).get(i).weight) {
					queue.add(array.get(node).get(i).end);
					visited[array.get(node).get(i).end] = true;
				}
			}
		}
		return false;
	}
	public static class 중량제한_01_Node{
		int end, weight;
		public 중량제한_01_Node(int end, int weight) {
			this.end = end; this.weight = weight;
		}
	}

}
