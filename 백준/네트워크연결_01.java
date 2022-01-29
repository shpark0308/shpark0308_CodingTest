package ����;

import java.io.*;
import java.util.*;

class ��Ʈ��ũ����_01_Node implements Comparable<��Ʈ��ũ����_01_Node>{
	int start, end, cost;
	public ��Ʈ��ũ����_01_Node(int start, int end, int cost) {
		this.start = start; this.end = end; this.cost = cost;
	}
	@Override
	public int compareTo(��Ʈ��ũ����_01_Node o) {
		return this.cost<o.cost?-1:1;
	}
}

public class ��Ʈ��ũ����_01 {
	public static int[] parents;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		
		Queue<��Ʈ��ũ����_01_Node> edge = new PriorityQueue<��Ʈ��ũ����_01_Node>(); // edge
		
		for (int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			edge.add(new ��Ʈ��ũ����_01_Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}
		
		parents = new int[N+1];
		for (int i=0; i<=N; i++) parents[i] = i;
		
		int total = 0; int index=0;
		while(!edge.isEmpty()) {
			��Ʈ��ũ����_01_Node node = edge.poll();
			int numA = find(node.start);
			int numB = find(node.end);
			if (numA!=numB) {
				parents[numA] = numB;
				total+=node.cost;
			}
		}
		System.out.println(total);

	}
	public static int find(int num) { /* find �Լ� */
		if (parents[num] == num) return num;
		return parents[num] = find(parents[num]);
	}
	

}
