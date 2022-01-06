package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Dynamic programming */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N+1];
		for (int i=1; i<=N;i++ ) number[i] = sc.nextInt();
		int[] DP = new int[N+1];
		for (int a=1; a<=N; a++) {
			int temp = number[a];
			for (int b=(a-1);b>=0;b--) {
				if (number[b]<temp) {
					DP[a] = Math.max(DP[b]+1, DP[a]);
				}
			}
		}
		int answer = Arrays.stream(DP).max().getAsInt();
		System.out.println(answer);
	}

}
