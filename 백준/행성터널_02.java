package 백준;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
class 행성터널_02_Node{
	int num, x, y, z;
	public 행성터널_02_Node(int num, int x, int y, int z) {
		this.num = num; this.x = x; this.y = y; this.z = z;
	}
}
class 행성터널_02_Edge implements Comparable<행성터널_02_Edge>{
	int from, to, cost;
	public 행성터널_02_Edge(int from, int to, int cost) {
		this.from = from; this.to = to; this.cost = cost;
	}
	@Override
	public int compareTo(행성터널_02_Edge o) {
		return this.cost<o.cost?-1:1;
	}
	
}
public class 행성터널_02 {
	public static int[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* Math.min(|xA-xB|, |yA-yB|, |zA-zB|) */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<행성터널_02_Node> planet = new ArrayList<행성터널_02_Node>();
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			planet.add(new 행성터널_02_Node(i, Integer.parseInt(str[0]) , Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}
		PriorityQueue<행성터널_02_Edge> edge = new PriorityQueue<행성터널_02_Edge>();
		
		Collections.sort(planet, (o1,o2) -> o1.x-o2.x);
		for (int i=0; i<planet.size()-1; i++) {
			int weight = planet.get(i+1).x - planet.get(i).x;
			edge.add(new 행성터널_02_Edge(planet.get(i).num, planet.get(i+1).num, weight));
		}
		
		Collections.sort(planet, (o1,o2) -> o1.y-o2.y);
		for (int i=0; i<planet.size()-1; i++) {
			int weight = planet.get(i+1).y - planet.get(i).y;
			edge.add(new 행성터널_02_Edge(planet.get(i).num, planet.get(i+1).num, weight));
		}
		
		Collections.sort(planet, (o1,o2) -> o1.z-o2.z);
		for (int i=0; i<planet.size()-1; i++) {
			int weight = planet.get(i+1).z - planet.get(i).z;
			edge.add(new 행성터널_02_Edge(planet.get(i).num, planet.get(i+1).num, weight));
		}
		
		visited = new int[N];
		int total_cost = 0;
		for (int i=0; i<N; i++) visited[i]=i;
		
		while(!edge.isEmpty()) { // edge 가 전부 돌때까지
			행성터널_02_Edge e = edge.poll();
			if (find(e.from)!=find(e.to)) { // cycle을 이루지 않는다면
				total_cost+=e.cost;
				union(e.from, e.to);
			}
		}
		System.out.println(total_cost);
		
	}
	
	public static int find(int num) {
		if (visited[num]==num) return num;
		return visited[num] = find(visited[num]);
	}
	public static void union(int start, int end) {
		start = find(start);
		end = find(end);
		if (start!=end) visited[start] = end;// 왜 end 가 먼저와야하는지
	}
	
	

}
