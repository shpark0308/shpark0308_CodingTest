package 백준;

import java.io.*;
import java.util.Arrays; 
public class 플로이드_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 한번 해보기 : 플로이드 와샬 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] DP = new int[N+1][N+1];
		for (int a=1; a<=N; a++) Arrays.fill(DP[a], 20000000);
		for (int a=1; a<=N; a++) DP[a][a]=0;
		
		for (int a=0; a<M; a++) {
			String[] str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]), e = Integer.parseInt(str[1]), c = Integer.parseInt(str[2]);
			DP[s][e] = Math.min(DP[s][e], c);
		}
		
		for (int k=1; k<=N; k++) { // 거쳐가는 정점 선택
			for (int p=1; p<=N; p++) { // 출발점 선택
				for (int q=1; q<=N; q++) {
					DP[p][q] = Math.min(DP[p][q], DP[p][k]+DP[k][q]);
				}
			}
		}
		
		for (int a=1; a<=N; a++) {
			for (int b=1; b<=N; b++) {
				if (DP[a][b]==20000000) System.out.println(0+" ");
				else System.out.print(DP[a][b]+" ");
			}
			System.out.println();
		}
	}

}
