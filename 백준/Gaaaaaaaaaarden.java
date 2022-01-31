package 백준;

import java.io.*;
import java.util.*;
import java.awt.*;

public class Gaaaaaaaaaarden {
	public static int N, M, G, R;
	public static ArrayList<Point> nutri_arr = new ArrayList<Point>();
	public static ArrayList<ArrayList<Point>> nutri_caseby = new ArrayList<ArrayList<Point>>();
	public static ArrayList<String> nutri_permutation = new ArrayList<String>();
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};
	public static int maxflower = Integer.MIN_VALUE;
	public static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); G = Integer.parseInt(str[2]); R = Integer.parseInt(str[3]);
		DP = new int[N][M];
		
		int nutrition = G+R;
		
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) {
				DP[a][b] = Integer.parseInt(str[b]);
				if (DP[a][b]==2) nutri_arr.add(new Point(a,b));
			}
		}
		permutation(G, R, "");
		combination(0, G+R, new ArrayList<Point>());
		System.out.println(maxflower);

	}
	public static void combination(int index, int r, ArrayList<Point> arr) {
		if (r==0) {
			nutri_caseby.add(arr);
			for (int i=0; i<nutri_permutation.size();i++) {
				bfs_search(arr, nutri_permutation.get(i));
			}
			return;
		}
		ArrayList<Point> ar = new ArrayList<Point>();
		ar.addAll(arr);
		for (int i=index; i<nutri_arr.size(); i++) {
			ar.add(nutri_arr.get(i));
			combination(i+1, r-1, new ArrayList<Point>(ar));
			ar.remove(ar.size()-1);
		}
	}
	public static void permutation(int G, int R, String sequence ) { // 배양액 순서
		//System.out.println("G : "+G+" R : "+R+" "+sequence);
		if (G==0) {
			for (int i=R; i>0; i--) sequence+="R"; 
			nutri_permutation.add(sequence);
			return;
		}
		else if (R==0) {
			for (int i=G; i>0; i--) sequence+="G";
			nutri_permutation.add(sequence);
			return;
		}
		else {
			permutation(G, R-1, sequence+"R");
			permutation(G-1, R, sequence+"G");
		}
	}
	
	public static void bfs_search(ArrayList<Point> arr, String sequence) {
		int[][] Arr = new int[N][M];
		int[][] visited = new int[N][M]; // visited무조건 해줘야 함
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				Arr[a][b] = DP[a][b];
				if (Arr[a][b]==0||Arr[a][b]==3||Arr[a][b]==4) visited[a][b]=1;
			}
		}
		
		Queue<Point> green_queue = new LinkedList<Point>(); // green = 3
		Queue<Point> red_queue = new LinkedList<Point>(); // red = 4
		ArrayList<Point> current_green = new ArrayList<Point>(); // 동일한 시간에 도달하는 빨간색 배양액 계산
		int flower=0;
		
		for (int i=0; i<arr.size();i++) {
			if (sequence.charAt(i)=='G') {
				green_queue.add(arr.get(i));
				Arr[arr.get(i).x][arr.get(i).y] = 3;
			}
			else {
				red_queue.add(arr.get(i));
				Arr[arr.get(i).x][arr.get(i).y] = 4;
			}
		}
		
		
		while(!(green_queue.isEmpty()&&red_queue.isEmpty())) {
			int greensize = green_queue.size();
			for (int i=0; i<greensize;i++) {
				Point green = green_queue.poll();
				int cx = green.x;
				int cy = green.y;
				if (visited[cx][cy]==1) continue;
				visited[cx][cy]=1;
				for (int v=0; v<4; v++) {
					int nx = cx+go_X[v];
					int ny = cy+go_Y[v];
					if (nx<0||nx>=N||ny<0||ny>=M) continue;
					if (visited[nx][ny]==1) continue;
					if (Arr[nx][ny]==1||Arr[nx][ny]==2) {
						Arr[nx][ny] = 3;
						green_queue.add(new Point(nx, ny));
						current_green.add(new Point(nx,ny));
					}
				}
			}
			int redsize = red_queue.size();
			for (int i=0; i<redsize; i++) {
				Point red = red_queue.poll();
				int cx = red.x;
				int cy = red.y;
				if (visited[cx][cy]==1) continue;
				visited[cx][cy]=1;
				for (int v=0;v<4;v++) {
					int nx = cx+go_X[v];
					int ny = cy+go_Y[v];
					if (nx<0||nx>=N||ny<0||ny>=M) continue;
					if (visited[nx][ny]==1) continue;
					if (Arr[nx][ny]==1||Arr[nx][ny]==2) {
						Arr[nx][ny] = 4;
						red_queue.add(new Point(nx,ny));
					}
					else if (Arr[nx][ny]==3&&current_green.contains(new Point(nx, ny))) { // 동일한 시간에 간거라면
						Arr[nx][ny] = 5;
						flower++;
						green_queue.remove(new Point(nx,ny)); // flower이 된 애들은 green_queue에서 지워줘야함
					}
				}
			}
			
			current_green.clear();
		}
		maxflower = Math.max(flower, maxflower);
	}

}
