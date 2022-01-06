package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 테트로미노_02 {
	public static int N,M;
	public static int max = Integer.MIN_VALUE;
	public static int[][] Arr;
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		/* DFS 로 풀기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		Arr = new int[N][M];
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) Arr[a][b] = Integer.parseInt(str[b]);
		}
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				ArrayList<Point> ar = new ArrayList<Point>();
				ar.add(new Point(a,b));
				dfs(1,a,b,Arr[a][b],ar);
				check(a,b);
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int index, int cx, int cy, int count, ArrayList<Point> visited) {
		if (index==4) {
			max = Math.max(max, count);
			return;
		}
		ArrayList<Point> ar = new ArrayList<Point>();
		ar.addAll(visited);
		for (int i=0; i<4; i++) {
			int nx = cx+go_X[i];
			int ny = cy+go_Y[i];
			if (nx<0||nx>=N||ny<0||ny>=M) continue;
			if (ar.contains(new Point(nx, ny))) continue;
			ar.add(new Point(nx,ny));
			dfs(index+1, nx, ny, count+Arr[nx][ny], new ArrayList<Point>(ar));
			ar.remove(ar.size()-1);
		}
	}
	public static void check(int cx, int cy) {
		if (cx+1<N&&cy+2<M) {
			max = Math.max(max, Arr[cx][cy]+Arr[cx][cy+1]+Arr[cx][cy+2]+Arr[cx+1][cy+1]);
			max = Math.max(max, Arr[cx][cy+1]+Arr[cx+1][cy]+Arr[cx+1][cy+1]+Arr[cx+1][cy+2]);
		}
		if (cx+2<N&&cy+1<M) {
			max = Math.max(max, Arr[cx][cy+1]+Arr[cx+1][cy]+Arr[cx+1][cy+1]+Arr[cx+2][cy+1]);
			max = Math.max(max, Arr[cx][cy]+Arr[cx+1][cy]+Arr[cx+2][cy]+Arr[cx+1][cy+1]);
		}
	}
}
