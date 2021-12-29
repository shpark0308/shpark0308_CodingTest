package ����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class �ټ����_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// ��
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[] indegree = new int[N+1];
		for (int i=0; i<N+1; i++) graph.add(new ArrayList<Integer>());
		for (int i=0; i<M; i++) {
			int start = sc.nextInt(); // ���İ��谡 ��Ȯ�ϸ� -> ��������
			int end = sc.nextInt();
			graph.get(start).add(end);
			indegree[end]++; // 3���� ���µ� ��� �뼱�� ���ľ� �ϴ°�
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
