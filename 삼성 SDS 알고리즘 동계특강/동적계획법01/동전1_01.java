package ������ȹ��01;

import java.util.Arrays;
import java.util.Scanner;

public class ����1_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[] coin_arr = new int[N+1];
		for (int i=1; i<=N; i++) coin_arr[i] = sc.nextInt();
		/* ����� �ּ����� �غ� */
		int[][] DP = new int[N+1][K+1];
		for (int i=0; i<=N; i++) DP[i][0] = 1;
		
		for (int a=1; a<=N; a++) {
			int coin = coin_arr[a];
			for (int money = 1; money<=K; money++) {
				for (int c=money; c>=0; c-=coin) {
					DP[a][money]+=DP[a-1][c];
				}
			}
		}
		System.out.println(DP[N][K]);

	}

}
