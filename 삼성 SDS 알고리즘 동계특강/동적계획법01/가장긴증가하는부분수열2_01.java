package 동적계획법01;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열2_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N+1];
		for (int i=1; i<=N; i++) number[i] = sc.nextInt();
		
		
		int[] DP = new int[N+1];
		for (int a=1; a<=N; a++) {
			for (int b=(a-1); b>=0; b--) {
				if (number[b]<number[a]) DP[a] = Math.max(DP[a], DP[b]+1);
			}
		}
		int maxlen = Arrays.stream(DP).max().getAsInt();
		System.out.println(maxlen);

	}

}
