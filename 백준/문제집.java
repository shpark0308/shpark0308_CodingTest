package 백준;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 문제집 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N+1; i++) graph.add(new ArrayList<Integer>());
		int[] indegree = new int[N+1];
		for (int a=0; a<M; a++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph.get(start).add(end);
			indegree[end]++;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i=1; i<indegree.length; i++) {
			if (indegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for (int i=0; i<graph.get(num).size();i++) {
				int temp = graph.get(num).get(i);
				indegree[temp]-=1;
				if (indegree[temp]==0) queue.add(temp);
			}
			System.out.print(num+" ");
		}

	}

}
