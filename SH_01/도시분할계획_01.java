
import java.io.*;
import java.util.*;

class ���ú��Ұ�ȹ_01_Node implements Comparable<���ú��Ұ�ȹ_01_Node>{
	int end, cost;
	public ���ú��Ұ�ȹ_01_Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(���ú��Ұ�ȹ_01_Node o) {
		// TODO Auto-generated method stub
		return this.cost<o.cost?-1:1;
	}
	
	
}

public class ���ú��Ұ�ȹ_01 {
	public static int N, M;
	public static ArrayList<ArrayList<���ú��Ұ�ȹ_01_Node>> graph = new ArrayList<ArrayList<���ú��Ұ�ȹ_01_Node>>();
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		
		for (int i=0; i<=N; i++) graph.add(new ArrayList<���ú��Ұ�ȹ_01_Node>());
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			graph.get(Integer.parseInt(str[0])).add(new ���ú��Ұ�ȹ_01_Node(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
			graph.get(Integer.parseInt(str[1])).add(new ���ú��Ұ�ȹ_01_Node(Integer.parseInt(str[0]), Integer.parseInt(str[2])));
		}
		
		
		Queue<���ú��Ұ�ȹ_01_Node> queue = new PriorityQueue<���ú��Ұ�ȹ_01_Node>();
		queue.add(new ���ú��Ұ�ȹ_01_Node(1, 0));
		
		int totalcost = 0, maxcost = 0;
		boolean[] visited = new boolean[N+1];
		while(!queue.isEmpty()) {
			���ú��Ұ�ȹ_01_Node node =queue.poll();
			if (visited[node.end]) continue;
			
			visited[node.end] = true;
			totalcost+=node.cost;
			maxcost = Math.max(node.cost, maxcost);
			for (int i=0; i<graph.get(node.end).size(); i++) {
				���ú��Ұ�ȹ_01_Node temp = graph.get(node.end).get(i);
				if (!visited[temp.end]) {
					queue.add(temp);
					
				}
			}
		}
		System.out.println(totalcost-maxcost);
		
	}

}
