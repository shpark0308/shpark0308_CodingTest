package ����;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class �߷�����_01_Node{
	int end, weight;
	public �߷�����_01_Node(int end, int weight) {
		this.end = end; this.weight = weight;
	}
}
public class �߷�����_01 {
	public static int N,M, start, end;
	public static boolean[] visited;
	public static ArrayList<ArrayList<�߷�����_01_Node>> array = new ArrayList<ArrayList<�߷�����_01_Node>>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);

		int max = Integer.MIN_VALUE;
		for (int i=0; i<N+1; i++) array.add(new ArrayList<�߷�����_01_Node>());
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]); int e = Integer.parseInt(str[1]); int w = Integer.parseInt(str[2]);
			array.get(s).add(new �߷�����_01_Node(e, w)); // ����� �׷���
			array.get(e).add(new �߷�����_01_Node(s, w));
			max = Math.max(max, w);
		}
		
		str = br.readLine().split(" ");
		start = Integer.parseInt(str[0]); end = Integer.parseInt(str[1]);

		/* �̺�Ž������ �ִ� �߷����� ã�� : (1 �� C �� 1,000,000,000) ������ ������ �ִ� �߷����� �̺�Ž������ ã�Ƴ� */
		int left = 0,right = max;
		while(left<=right) {
			int mid = (right+left/2);
			if (check(mid)) left=mid+1;
			else right = mid-1;
		}
		System.out.println(right);
		
	}
	public static boolean check(int target) {
		/* ���ͽ�Ʈ�� �˰��� ����� */
		Queue<Integer> queue = new PriorityQueue<>(); // ���ͽ�Ʈ�� �˰����� priority queue�� ����ؾ��Ѵ�.
		queue.add(start);
		visited = new boolean[N+1];
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if (visited[node]) continue;
			visited[node] = true;
			
			if (node == end) return true;
			
			for (int i=0; i<array.get(node).size();i++) {
				int temp = array.get(node).get(i).end;
				if (!visited[temp]&&target<=array.get(node).get(i).weight) {
					queue.add(temp);
				}
			}
		}
		return false;
	}

}
