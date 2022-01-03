package 소프티어;

import java.awt.Point;
import java.io.*;
import java.util.*;


public class 인증평가2차_기출_01 {
	public static int N;
	public static int[] go_X = {-1, 1, 0, 0};
	public static int[] go_Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] DP = new int[2*N][N];
		String[] str;
		for (int a=0; a<2*N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<N; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		int[][] Arr = new int[N][N];
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<N; b++) Arr[a][b] = Integer.parseInt(str[b]);
		}
		
		similarCollection(Arr, DP);

	}
	/* 일단 이것을 해보기 */
	public static void similarCollection(int[][] Arr, int[][] DP) {
		ArrayList<ArrayList<Point>> arr = new ArrayList<ArrayList<Point>>();
		int[][] visited = new int[N][N];
		
		while(true) {
			Point point = check(visited);
			if (point==null) break;
			ArrayList<Point> ar = new ArrayList<Point>();
			Queue<Point> queue = new LinkedList<Point>();
			int num_target = Arr[point.x][point.y];
			queue.add(point);
			
			while(!queue.isEmpty()) {
				Point pp = queue.poll();
				int cx = pp.x;
				int cy = pp.y;
				if (visited[cx][cy]==1) continue;
				ar.add(new Point(cx, cy));
				visited[cx][cy]=1;
				for (int i=0; i<4; i++) {
					int nx = cx+go_X[i];
					int ny = cy+go_Y[i];
					if (nx<0||nx>=N||ny<0||ny>=N) continue;
					if (visited[nx][ny]!=0) continue; // visited[nx][ny]==1
					if (Arr[nx][ny]==num_target) {
						queue.add(new Point(nx, ny));
					}
				}
			}
			System.out.println(">> "+ar);
			clearAndfill(Arr, DP, ar); // 차를 사라지고 직사각형 계산하기
			arr.add(ar);
		}
		
	}
		
	public static Point check(int[][] visited) {
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				if (visited[a][b]==0) return new Point(a,b);
			}
		}
		return null;
	}
	
	public static void clearAndfill(int[][] Arr, int[][] DP, ArrayList<Point> arr) {
		System.out.println("===================================");
		int count = 0;
		count+=arr.size(); // arr 같은 색상인 arraylist
		/* 이렇게 하는 것이 맞는건지 잘 모르겠음 */
		int min_x = arr.get(0).x; int min_y = arr.get(0).y;
		int max_x = arr.get(0).x; int max_y = arr.get(0).y;
		
		HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<Integer,ArrayList<Integer>>();

		for (int i=0; i<arr.size(); i++) {
			Point point = arr.get(i);
			if (point.x<min_x) min_x = point.x;
			else if (point.x>max_x) max_x = point.x;
			if (point.y<min_y) min_y = point.y;
			else if (point.y>max_y) max_y = point.y;
			if (!hashmap.containsKey(point.y)) hashmap.put(point.y, new ArrayList<Integer>());
			hashmap.get(point.y).add(point.x);
		}
		int area = (max_x-min_x+1)*(max_y-min_y+1);
		System.out.println(area);
		count+=area;
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : hashmap.entrySet()) {
			int column = entry.getKey();
			Collections.sort(entry.getValue(), Collections.reverseOrder());
			System.out.println(entry.getValue());
			for (int i=0; i<entry.getValue().size();i++) {
				int start_index = entry.getValue().get(i);
				for (int a=start_index; a>=0;a--) {
					int index = a;
					System.out.println("index = "+index);
					if (index-1<0) {
						Arr[index][column] = DP[DP.length-1][column];
						start_index = DP.length-1;
					}
					else {
						Arr[index][column] = Arr[index-1][column];
						System.out.println("나 여기고   "+Arr[index][column]+"   "+Arr[index-1][column]);
					}
					
				}
				for (int a=start_index; a>=0; a--) {
					if (a-1<0) DP[a][column]=0;
					else DP[a][column] = DP[a-1][column];
					
				}
				System.out.println("--------------------------");
				for (int a=0; a<Arr.length;a++) {
					System.out.println(Arrays.toString(Arr[a]));
				}
			}
		}
		System.out.println("--------------------------");
		for (int a=0; a<Arr.length;a++) {
			System.out.println(Arrays.toString(Arr[a]));
		}
		
		
		
	}


}
