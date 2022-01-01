package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 테트로미노_01 {
	public static int max = Integer.MIN_VALUE;
	public static int N,M;
	public static int[][] DP;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		DP = new int[N][M];
		for (int a=0; a<N;a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				check(a,b);
			}
		}
		System.out.println(max);

	}
	/* 하나하나 다 해보는 방법 */
	public static void check(int x, int y) {
		if (y+3<M) max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x][y+2]+DP[x][y+3]);
		if (x+1<N&&y+2<M) {
			max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x][y+2]+DP[x+1][y]);
			max = Math.max(max, DP[x][y+2]+DP[x+1][y]+DP[x+1][y+1]+DP[x+1][y+2]);
			max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x][y+2]+DP[x+1][y+2]);
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+1][y+1]+DP[x+1][y+2]);
			max = Math.max(max, DP[x][y+1]+DP[x][y+2]+DP[x+1][y]+DP[x+1][y+1]);
			max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x+1][y+1]+DP[x+1][y+2]);
			max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x][y+2]+DP[x+1][y+1]);
			max = Math.max(max, DP[x][y+1]+DP[x+1][y]+DP[x+1][y+1]+DP[x+1][y+2]);
		}
		if (x+2<N&&y+1<M) {
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+2][y]+DP[x+2][y+1]);
			max = Math.max(max, DP[x][y]+DP[x][y+1]+DP[x+1][y+1]+DP[x+2][y+1]);
			max = Math.max(max, DP[x+2][y]+DP[x][y+1]+DP[x+1][y+1]+DP[x+2][y+1]);
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+2][y]+DP[x][y+1]);
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+1][y+1]+DP[x+2][y+1]);
			max = Math.max(max, DP[x+1][y]+DP[x+2][y]+DP[x][y+1]+DP[x+1][y+1]);
			max = Math.max(max, DP[x+1][y]+DP[x][y+1]+DP[x+1][y+1]+DP[x+2][y+1]);
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+2][y]+DP[x+1][y+1]);
		}
		if (x+1<N&&y+1<M) {
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x][y+1]+DP[x+1][y+1]);
		}
		if (x+3<N) {
			max = Math.max(max, DP[x][y]+DP[x+1][y]+DP[x+2][y]+DP[x+3][y]);
			
		}
	}
	

}
