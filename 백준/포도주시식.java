package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 포도주시식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 연속 3번 마시면 안된다 : DP[i] = Math.max(DP[i-3]+arr[i-1], DP[i-2])+arr[i]; <- 이러면 연속으로 안되고 최댓값을 구할 수 있음
		 * 2. n-1 번째와 n 번쨰를 비교
		 * && 계단 오르기와 다르다는 점 : 지금까지 한것중에서 max 인것을 추출
		 * 3. 안마셔도 된다는 점
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i=1; i<=N; i++) arr[i] = sc.nextInt();
		int[] DP = new int[N+1];
		DP[1] = arr[1];
		if (N>=2) DP[2] = arr[1]+arr[2];
		int max = Integer.MIN_VALUE;
		if (N>=3) {
			for (int i=3; i<=N; i++) {
				DP[i] = Math.max(DP[i-3]+arr[i-1], DP[i-2])+arr[i];
				//DP[i] = Math.max(DP[i-1], DP[i]);
			}
		}
		System.out.println(Arrays.toString(DP));
		int answer = Math.max(DP[N-1], DP[N]);
		System.out.println(answer);

	}

}
