
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus implements Comparable<Bus>{
	int end;
	long cost;
	public Bus(int end, long cost) {
		this.end = end; this.cost = cost;
	}
	
	@Override
	public int compareTo(Bus o) {
		return this.cost < o.cost?-1:1;
	}
}

public class 최소비용구하기2_01 {
	public static int n,m;
	public static ArrayList<ArrayList<Bus>> graph = new ArrayList<ArrayList<Bus>>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for (int i=0; i<=n; i++) graph.add(new ArrayList<Bus>());
		
		for (int i=0; i<m; i++) {
			String[] str = br.readLine().split(" ");
			graph.get(Integer.parseInt(str[0])).add(new Bus(Integer.parseInt(str[1]), Long.parseLong(str[2])));
		}
		
		String[] str = br.readLine().split(" ");
		Dijkstra(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		
		

	}
	
	public static void Dijkstra (int start, int end) {
		
		long[] DP = new long[n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(DP, Integer.MAX_VALUE);

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<=n; i++) list.add(new ArrayList<Integer>(Arrays.asList(i)));
		
		
		Queue<Bus> queue = new PriorityQueue<Bus>();
		queue.add(new Bus(start, 0));
		
		/* 초기 상태를 어떻게 해야할지 */
		DP[start] = 0;
		
		while(!queue.isEmpty()) {
			Bus bus = queue.poll();
			System.out.println(">> "+Arrays.toString(DP));
			
			if (visited[bus.end]) continue;
			visited[bus.end] = true;
			
			for (int i=0; i<graph.get(bus.end).size();i++) {
				Bus temp = graph.get(bus.end).get(i);
				if (DP[temp.end]>DP[bus.end]+temp.cost) {
					DP[temp.end] = DP[bus.end]+temp.cost;
					list.get(temp.end).clear();
					list.get(temp.end).addAll(list.get(bus.end));
					list.get(temp.end).add(temp.end);
					queue.add(temp);
					queue.add(new Bus(temp.end, DP[temp.end]));
				}
			}
			System.out.println(list);
			
		}
		System.out.println(DP[end]);
		System.out.println(list.get(end).size());
		for (Integer num : list.get(end)) System.out.print(num+" ");
	}

}
