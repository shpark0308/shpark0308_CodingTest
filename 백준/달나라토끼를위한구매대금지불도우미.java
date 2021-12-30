package 백준;

import java.util.*;

public class 달나라토끼를위한구매대금지불도우미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] DP = new int[N+1];
		Arrays.fill(DP, Integer.MAX_VALUE);
		int[] coin = { 1,2,5,7 };
		DP[0] = 0;
		for (int money=1; money<=N; money++) {
			for (int c : coin ) {
				if (money>=c) {
					DP[money] = Math.min(DP[money], DP[money-c]+1);
				}
			}
		}
		System.out.println(DP[N]);
	}

}
