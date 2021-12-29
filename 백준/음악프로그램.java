package 백준;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 음악프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[] indegree = new int[N+1];
		for (int i=0; i<N+1; i++) graph.add(new ArrayList<Integer>());
		for (int i=0; i<M; i++) {
			int n = sc.nextInt();
			int start = sc.nextInt();
			for (int a=1; a<n; a++) {
				int end = sc.nextInt();
				graph.get(start).add(end);
				indegree[end]++;
				start = end;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		for (int i=1; i<N+1; i++) {
			if (indegree[i]==0) queue.add(i);
		}
		while(!queue.isEmpty()) { // 과연 이게 될까 의문
			int num = queue.poll();
			for (int i=0; i<graph.get(num).size(); i++) {
				int temp = graph.get(num).get(i);
				indegree[temp]--;
				if (indegree[temp]==0) queue.add(temp);
			}
			result.add(num);
		}
		if (result.size()!=N) System.out.println(0);
		else {
			while(!result.isEmpty()) {
				System.out.println(result.poll());
			}
		}
		
		
	}

}
