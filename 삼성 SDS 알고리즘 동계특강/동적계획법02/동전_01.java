package 동적계획법02;

import java.io.*;
import java.util.Arrays;

public class 동전_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] coin_arr = new int[N+1];
			String[] str = br.readLine().split(" ");
			for (int i=1; i<=N; i++) coin_arr[i] = Integer.parseInt(str[i-1]);
			int M = Integer.parseInt(br.readLine());
			int[][] DP = new int[N+1][M+1];
			for (int i=0; i<=N; i++) DP[i][0]=1;
			for (int i=1; i<=N; i++) {
				for (int money = 1; money<=M; money++) {
					for (int coin=money; coin>=0; coin-=coin_arr[i]) {
						DP[i][money] +=DP[i-1][coin];
					}
				}
			}
			System.out.println(DP[N][M]);
		}

	}

}
