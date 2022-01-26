package 동적계획법01;

import java.util.Arrays;
import java.util.Scanner;

public class 쉬운계단수_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] DP = new long[N+1][10];
		Arrays.fill(DP[1], 1, 10, 1);
		
		for (int a=2; a<=N; a++) {
			for (int b=0; b<10;b++) {
				if ((b-1)>=0) DP[a][b-1]=(DP[a][b-1]+DP[a-1][b])%1000000000;
				if ((b+1)<10) DP[a][b+1]=(DP[a][b+1]+DP[a-1][b])%1000000000;
			}
		}
		long sum = 0;
		for (int i=0; i<10; i++) sum+=DP[N][i];
		long answer = sum%1000000000;
		System.out.println(answer);

	}

}
