package ����;

import java.util.Scanner;

public class ����������Ż���ƿ��������̽�ũ������Դµ�_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/* 1. ��� ������ �� ã������ �ð��ʰ��� �߻�
		 * 2. int[][] 2���� �迭�� true�� Ȯ��
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
