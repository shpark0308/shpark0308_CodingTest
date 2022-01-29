package ����;

import java.io.*;
import java.util.*;

class �ּҽ��д�Ʈ��_Node implements Comparable<�ּҽ��д�Ʈ��_Node>{
	int end, cost;
	public �ּҽ��д�Ʈ��_Node(int end, int cost) {
		this.end = end; this.cost = cost;
	}
	@Override
	public int compareTo(�ּҽ��д�Ʈ��_Node o) {
		return this.cost<o.cost?-1:1;
	}

}

public class �ּҽ��д�Ʈ��_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int V = Integer.parseInt(str[0]), E = Integer.parseInt(str[1]);

		/* �׷��� ���� */
		ArrayList<ArrayList<�ּҽ��д�Ʈ��_Node>> graph = new ArrayList<ArrayList<�ּҽ��д�Ʈ��_Node>>();
		for (int i=0; i<=V; i++) graph.add(new ArrayList<�ּҽ��д�Ʈ��_Node>());
		for (int i=0; i<E; i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]), e = Integer.parseInt(str[1]), c = Integer.parseInt(str[2]);
			graph.get(s).add(new �ּҽ��д�Ʈ��_Node(e, c));
			graph.get(e).add(new �ּҽ��д�Ʈ��_Node(s, c));
		}
		
		PriorityQueue<�ּҽ��д�Ʈ��_Node> queue = new PriorityQueue<�ּҽ��д�Ʈ��_Node>();
		queue.add(new �ּҽ��д�Ʈ��_Node(1, 0));
		
		int[] visited = new int[V+1];
		int total = 0;
		while(!queue.isEmpty()) {
			�ּҽ��д�Ʈ��_Node node = queue.poll();
			if (visited[node.end]==1) continue;
			visited[node.end]=1;
			total+=node.cost;
			for (int i=0; i<graph.get(node.end).size();i++) {
				if (visited[graph.get(node.end).get(i).end]==0) { // �湮���� �ʾҴٸ�
					queue.add(graph.get(node.end).get(i));
				}
			}
		}
		System.out.println(total);
		
		
		
		
	}
	

}
