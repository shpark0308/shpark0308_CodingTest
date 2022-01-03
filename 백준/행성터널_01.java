package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class �༺�ͳ�_01_Node implements Comparable<�༺�ͳ�_01_Node> {
	int to, weight;
	public �༺�ͳ�_01_Node(int to, int weight) {
		this.to = to; this.weight = weight;
	}
	
	@Override
	public int compareTo(�༺�ͳ�_01_Node o) {
		return this.weight<o.weight?-1:1;
	}
}
public class �༺�ͳ�_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<int[]> array = new ArrayList<int[]>(); // �༺���� �Է��ϱ�
		for (int i=0; i<N; i++) array.add(new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()});
		ArrayList<ArrayList<�༺�ͳ�_01_Node>> Arr = new ArrayList<ArrayList<�༺�ͳ�_01_Node>>();
		for (int i=0; i<N; i++) Arr.add(new ArrayList<�༺�ͳ�_01_Node>());
		/* ���� �迭�� ������ֱ� */
		for (int a=0; a<N-1; a++) {
			for (int b=a+1; b<N; b++) {
				int cost = Math.min(Math.abs(array.get(a)[0]-array.get(b)[0]), Math.min(Math.abs(array.get(a)[1] - array.get(b)[1]), Math.abs(array.get(a)[2] - array.get(b)[2])));
				Arr.get(a).add(new �༺�ͳ�_01_Node(b, cost));
				Arr.get(b).add(new �༺�ͳ�_01_Node(a, cost));
			}
		}
		
		/* �����˰��� */
		int[] visited = new int[N];
		Queue<�༺�ͳ�_01_Node> queue = new PriorityQueue<�༺�ͳ�_01_Node>();
		queue.add(new �༺�ͳ�_01_Node(0, 0));
		int count = 0;
		while(!queue.isEmpty()) {
			�༺�ͳ�_01_Node node = queue.poll();
			int num = node.to;
			if (visited[num]==1) continue;
			count+=node.weight;
			visited[num]=1;
			for (int i=0; i<Arr.get(num).size();i++) {
				if (visited[Arr.get(num).get(i).to]==0) {
					queue.add(Arr.get(num).get(i));
				}
			}
			
		}
		System.out.println(count);
	}
	
}
