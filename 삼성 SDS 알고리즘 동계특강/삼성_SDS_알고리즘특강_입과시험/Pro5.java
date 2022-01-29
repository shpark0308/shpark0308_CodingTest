package 삼성_SDS_알고리즘특강_입과시험;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
	int end, cost;
	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
}
public class Pro5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int mincase = Integer.MAX_VALUE;
			int mincount=0;
			System.out.println("N : "+N);
			
			ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
			for (int v=0; v<N+1; v++) graph.add(new ArrayList<Node>());
			for (int e=0; e<(N-1); e++) { // 연결리스트 만들기
				int s = sc.nextInt();
				int en = sc.nextInt();
				int c = sc.nextInt();
				if (i==9||i==10)System.out.println(s+" "+en+" "+c+" ");
				
				graph.get(s).add(new Node(en, c));
				graph.get(en).add(new Node(s, c));
			}
			
			for (int start = 1; start<=N; start++) { //i<=N
				//System.out.println("-----------------------------");
				boolean[] visited = new boolean[N+1];
				int[] distance = new int[N+1];
				for (int v=0; v<N+1; v++) distance[v] = 100001;
				
				distance[start]=0; // 여기서부터 시작
				
				for (int p=0; p<N; p++) {
					int val = 100001;
					int index = start;
					
					for (int q=1; q<N+1; q++) {
						if (!visited[q]&&distance[q]<val) {
							val = distance[q];
							index = q;
						}
					}
					//System.out.println("index = "+index);
					visited[index] = true;
					
					for (int q=0; q<graph.get(index).size();q++) {
						Node node = graph.get(index).get(q);
						//System.out.println(">> Node.index : "+node.end);
						if (distance[node.end] > distance[index]+node.cost) {
							distance[node.end] = distance[index]+node.cost;
						}
					}
					//System.out.println(Arrays.toString(distance));
				}
				int sum=0;
				for (int k=1; k<N+1; k++) sum+=distance[k];
				
				if (sum<mincase) {
					mincase = sum;
					mincount = 1;
				}
				else if (sum==mincase) mincount++;
				
			}
			System.out.println("#"+i+" "+mincount+" "+mincase);
		}


	}

}
