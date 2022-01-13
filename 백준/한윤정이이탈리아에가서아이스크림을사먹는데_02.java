package 백준;

import java.util.Scanner;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/* 1. 모든 조합을 다 찾았을때 시간초과가 발생
		 * 2. int[][] 2차원 배열로 true만 확인
		 */
		int N = sc.nextInt(); int M = sc.nextInt();
		boolean[][] DP = new boolean[N+1][N+1];
		
		for (int i=0; i<M; i++) {
			int a = sc.nextInt();  int b = sc.nextInt();
			DP[a][b] = true; DP[b][a] = true;
		}
		int count=0;
		for (int i=1; i<=N; i++) {
			for (int j=i+1; j<=N; j++) {
				if (DP[i][j]) continue;
				for (int v=j+1; v<=N; v++) {
					if (!DP[i][v]&&!DP[j][v]) count++;
				}
			}
		}
		System.out.println(count);

	}

}
