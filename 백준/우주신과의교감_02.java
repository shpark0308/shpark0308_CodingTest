package 백준;

import java.util.*;
import java.io.*;
import java.awt.*;

class Edge implements Comparable<Edge>{
	int x, y;
	double cost;
	public Edge(int x, int y, double cost) {
		this.x = x; this.y = y; this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost<o.cost?-1:1;
	}
}

public class 우주신과의교감_02 {
	public static int N, M;
	public static int[] parents;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 크루스칼 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		
		Point[] node = new Point[N];
		for (int i=0; i<N; i++) node[i] = new Point(sc.nextInt(), sc.nextInt());
		
		/* edge */
		
		Queue<Edge> queue = new PriorityQueue<Edge>();
		
		for (int a=0; a<N; a++) {
			for (int b=(a+1); b<N;b++) {
				double cost = Math.sqrt(Math.pow(node[a].x-node[b].x, 2)+Math.pow(node[a].y-node[b].y, 2));
				queue.add(new Edge(a+1, b+1, cost));
			}
		}
		
		/* union-find */
		parents = new int[N+1];
		for (int i=0; i<=N; i++) parents[i] = i;
		
		Point[] edge = new Point[M];
		for (int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (find(a)!=find(b)) {
				parents[find(b)] = find(a);
			}
		}
		
		
		double sum = 0;
		/* 순회하기 */
		while(!queue.isEmpty()) {
			Edge temp = queue.poll();
			
			int parent_a = find(temp.x);
			int parent_b = find(temp.y);
			
			if (parent_a!=parent_b) {
				parents[parent_b] = parent_a;
				sum+=temp.cost;
			}
		}
		System.out.println(String.format("%.2f", sum));

	}
	
	public static int find(int num) {
		if (parents[num]==num) return parents[num];
		return parents[num]=find(parents[num]);
	}
	

}
