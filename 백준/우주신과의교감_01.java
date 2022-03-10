package 백준;

import java.util.*;
import java.io.*;
import java.awt.*;

class Space implements Comparable<Space>{
	int end;
	double cost;
	public Space(int end, double cost) {
		this.end = end; this.cost = cost;
	}
	
	@Override
	public int compareTo(Space o) {
		return (int)this.cost-(int)o.cost;
	}
}


public class 우주신과의교감_01 {
	public static ArrayList<ArrayList<Space>> graph = new ArrayList<ArrayList<Space>>();
	public static int N, M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		
		Point[] node = new Point[N];
		for (int i=0; i<N; i++) {
			node[i] = new Point(sc.nextInt(), sc.nextInt());
			graph.add(new ArrayList<Space>());
		}
		
		/* 각 노드끼리의 cost 구하기 */
		for (int a=0; a<N; a++) {
			for (int b=(a+1); b<N; b++) {
				int temp = (node[a].x-node[b].x)*(node[a].x-node[b].x)+(node[a].y-node[b].y)*(node[a].y-node[b].y);
				double cost = Math.sqrt(temp);
				graph.get(a).add(new Space(b, cost));
				graph.get(b).add(new Space(a, cost));
			}
		}
		
		Queue<Space> queue = new PriorityQueue<Space>();
		boolean[] visited = new boolean[N];
		double sum = 0;
		
		for (int i=0; i<M; i++) {
			int start = sc.nextInt()-1, end = sc.nextInt()-1;
			queue.add(new Space(start, 0));
			//visited[start] = true;
			queue.add(new Space(end, 0));
			//visited[end] = true; 
		}
		
		while(!queue.isEmpty()) {
			Space space = queue.poll();
			if (visited[space.end]) continue;
			visited[space.end] = true;
			sum+=space.cost;
			
			for (int i=0; i<graph.get(space.end).size();i++) {
				Space temp = graph.get(space.end).get(i);
				if (!visited[temp.end]) {
					queue.add(temp);
				}
			}
		}
		double answer = Math.round(sum*100) / 100.0;
		System.out.println(answer);
		
		
		
		
		

	}

}
