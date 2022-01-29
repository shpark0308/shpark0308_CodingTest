package 삼성_SDS_알고리즘특강_입과시험;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node1 implements Comparable<Node1>{
	int end, cost;
	public Node1(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node1 o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
}
public class Pro6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		PriorityQueue<Node1> queue = new PriorityQueue<Node1>();
		
		for (int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int mincase = Integer.MAX_VALUE;
			int mincount=0;
			System.out.println("N : "+N);
			
			ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
			for (int v=0; v<N+1; v++) graph.add(new ArrayList<Node1>());
			for (int e=0; e<(N-1); e++) { // 연결리스트 만들기
				int s = sc.nextInt();
				int en = sc.nextInt();
				int c = sc.nextInt();
				
				graph.get(s).add(new Node1(en, c));
				graph.get(en).add(new Node1(s, c));
			}
			
			for (int start = 1; start<=N; start++) { //i<=N
				//System.out.println("-----------------------------");
				boolean[] visited = new boolean[N+1];
				int[] distance = new int[N+1];
				for (int v=0; v<N+1; v++) distance[v] = 100001;
				
				distance[start]=0; // 여기서부터 시작
				queue.add(new Node1(start, 0));
				while(!queue.isEmpty()) {
					Node1 node = queue.poll();
					int index = node.end;
					if (!visited[index]) {
						visited[index] = true;
						for (Node1 node1 : graph.get(index)) {
							if (distance[node1.end] > distance[index]+node1.cost) {
								distance[node1.end] = distance[index]+node1.cost;
								queue.add(new Node1(node1.end, distance[node1.end]));
							}
						}
					}
				}
				int sum=0;
				for (int k=1; k<N+1; k++) sum+=distance[k];
				
				if (sum<mincase) {
					mincase = sum;
					mincount = 1;
				}
				else if (sum==mincase) mincount++;
				queue.clear();
				
			}
			System.out.println("#"+i+" "+mincount+" "+mincase);
		}


	}

}
