package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class 중량제한_02_Node{
	int end, weight;
	public 중량제한_02_Node(int end,int weight) {
		this.end = end; this.weight = weight;
	}
}

public class 중량제한_02 {
	public static int N,M, start, end;
	public static ArrayList<ArrayList<중량제한_02_Node>> arraylist = new ArrayList<ArrayList<중량제한_02_Node>>();
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		for (int i=0; i<=N; i++) arraylist.add(new ArrayList<중량제한_02_Node>());
		int max = Integer.MIN_VALUE;
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			
			arraylist.get(s).add(new 중량제한_02_Node(e,w));
			arraylist.get(e).add(new 중량제한_02_Node(s,w));
			
			max = Math.max(max, w);
		}
		
		str = br.readLine().split(" ");
		start = Integer.parseInt(str[0]);
		end = Integer.parseInt(str[1]);
		
		int left = 0, right = max;
		
		while(left<=right) {
			int mid = (left+right)/2;
			visited = new boolean[N+1];
			
			if (check(mid)) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);

	}
	
	public static boolean check(int target) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			if (node == end) return true;
			
			for (int i=0; i<arraylist.get(node).size();i++) {
				if (!visited[arraylist.get(node).get(i).end]&&target<=arraylist.get(node).get(i).weight) {
					visited[arraylist.get(node).get(i).end] = true;
					queue.add(arraylist.get(node).get(i).end);
				}
			}
		}
		return false;
	}

}
