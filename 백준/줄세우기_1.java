package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 비교
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[] indegree = new int[N+1];
		for (int i=0; i<N+1; i++) graph.add(new ArrayList<Integer>());
		for (int i=0; i<M; i++) {
			int start = sc.nextInt(); // 선후관계가 명확하면 -> 위상정렬
			int end = sc.nextInt();
			graph.get(start).add(end);
			indegree[end]++; // 3까지 가는데 몇개의 노선을 거쳐야 하는가
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i=1; i<N+1; i++) {
			if (indegree[i]==0) queue.add(i);
		}
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for (int i=0; i<graph.get(num).size();i++) {
				int temp = graph.get(num).get(i);
				indegree[temp]--;
				if (indegree[temp]==0) queue.add(temp);
			}
			System.out.print(num+" ");
				
		}

	}

}
