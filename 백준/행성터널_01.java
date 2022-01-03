package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class 행성터널_01_Node implements Comparable<행성터널_01_Node> {
	int to, weight;
	public 행성터널_01_Node(int to, int weight) {
		this.to = to; this.weight = weight;
	}
	
	@Override
	public int compareTo(행성터널_01_Node o) {
		return this.weight<o.weight?-1:1;
	}
}
public class 행성터널_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<int[]> array = new ArrayList<int[]>(); // 행성정보 입력하기
		for (int i=0; i<N; i++) array.add(new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()});
		ArrayList<ArrayList<행성터널_01_Node>> Arr = new ArrayList<ArrayList<행성터널_01_Node>>();
		for (int i=0; i<N; i++) Arr.add(new ArrayList<행성터널_01_Node>());
		/* 먼저 배열을 만들어주기 */
		for (int a=0; a<N-1; a++) {
			for (int b=a+1; b<N; b++) {
				int cost = Math.min(Math.abs(array.get(a)[0]-array.get(b)[0]), Math.min(Math.abs(array.get(a)[1] - array.get(b)[1]), Math.abs(array.get(a)[2] - array.get(b)[2])));
				Arr.get(a).add(new 행성터널_01_Node(b, cost));
				Arr.get(b).add(new 행성터널_01_Node(a, cost));
			}
		}
		
		/* 프림알고리즘 */
		int[] visited = new int[N];
		Queue<행성터널_01_Node> queue = new PriorityQueue<행성터널_01_Node>();
		queue.add(new 행성터널_01_Node(0, 0));
		int count = 0;
		while(!queue.isEmpty()) {
			행성터널_01_Node node = queue.poll();
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
