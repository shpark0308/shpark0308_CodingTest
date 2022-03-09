package 백준;

import java.util.*;

public class 샤워실바닥깔기_01 {
	public static int[][] DP;
	public static int K, N, count = 0;
	
	public static void main(String[] args) {
		/* 분할 정복 */
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); N = (int)Math.pow(2, K);
		
		DP = new int[N][N];
		
		int cy = sc.nextInt()-1, cx = N-sc.nextInt();
		DP[cx][cy] = -1;
		
		divide(0, 0, N);
		
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				System.out.print(DP[a][b]+" ");
			}
			System.out.println();
		}
	}
	
	public static void divide(int x, int y, int size ) {
		count++;
		int n = size / 2;
		if (isCheck(x, y, n)) DP[x+n-1][y+n-1] = count;
		if (isCheck(x+n, y, n)) DP[x+n][y+n-1] = count;
		if (isCheck(x, y+n, n)) DP[x+n-1][y+n] = count;
		if (isCheck(x+n,y+n, n)) DP[x+n][y+n] = count;
		
		if (size==2) return;
		
		divide(x, y, n);
		divide(x, y+n, n);
		divide(x+n, y, n);
		divide(x+n, y+n, n);
		
		
		
		
	}
	
	public static boolean isCheck(int x, int y, int size) {
		for (int a=x; a<(x+size); a++) {
			for (int b=y; b<(y+size); b++) {
				if (DP[a][b]!=0) return false; // 색칠 되어있다면
			}
		}
		return true;
	}
	

}
