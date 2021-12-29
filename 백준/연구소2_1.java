package 백준;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소2_1 {
	public static int N, M;
	public static int[][] DP;
	public static ArrayList<Point> virusloc = new ArrayList<Point>();
	public static int[] go_X = { -1, 1, 0, 0 }; // 위, 아래, 오른쪽, 왼쪽
	public static int[] go_Y = { 0, 0, 1, -1 };
	public static int min = Integer.MAX_VALUE;
	public static int totalcount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		DP = new int[N][N];
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				DP[a][b] = sc.nextInt();
				if (DP[a][b]==2) virusloc.add(new Point(a,b));
			}
		}
		combination(new ArrayList<Point>(), 0, M);
		int answer = min==Integer.MAX_VALUE?-1:min;
		System.out.println(answer);
	}
	
	public static void combination(ArrayList<Point> arr, int start, int r) {
		if (r==0) {
			bfs(arr);
			return;
		}
		ArrayList<Point> ar = new ArrayList<Point>(arr);
		for (int i=start; i<virusloc.size(); i++) {
			ar.add(virusloc.get(i));
			combination(ar, i+1, r-1);
			ar.remove(ar.size()-1);
		}
	}
	
	public static void bfs(ArrayList<Point> arr) {
		totalcount = N*N;
		int[][] array = copyarray(arr);
		Queue<Point> queue = new LinkedList<Point>();
		for (int i=0; i<arr.size();i++) queue.add(arr.get(i));
		int time=0;
		
		while(!queue.isEmpty()) {
			time++;
			int queue_size = queue.size();
			for (int i=0; i<queue_size; i++) {
				Point point = queue.poll();
				for (int t=0; t<4; t++) {
					int nx = point.x+go_X[t];
					int ny = point.y+go_Y[t];
					if (nx<0||nx>=N||ny<0||ny>=N) continue;
					if (array[nx][ny]!=-2) continue; // 다른 곳은 덮어 쓰면 되니까
					array[nx][ny]=time;
					totalcount--;
					queue.add(new Point(nx, ny));
				}
			}
		}
		if (totalcount>0) return;
		if ((time-1)<min) min = time-1;
		
		
	}
	
	public static int[][] copyarray(ArrayList<Point> arr){
		int[][] array = new int[N][N];
		/* 배열 복사하기 */
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				array[a][b] = DP[a][b];
				if (DP[a][b]==1) {
					array[a][b]=-1; 
					totalcount--;
				}
				else array[a][b]=-2;
			}
		}
		totalcount-=arr.size();
		for (int i=0; i<arr.size();i++) {
			array[arr.get(i).x][arr.get(i).y]=0;
		}
		return array;
	}

}