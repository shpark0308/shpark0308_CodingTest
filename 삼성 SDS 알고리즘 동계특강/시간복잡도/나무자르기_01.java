package 시간복잡도;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] number = new int[N];
		for (int i=0; i<N; i++) number[i] = sc.nextInt();
		/* 이분탐색 열심히 공부하기 */ // 일단해보기
		long left = 0, right = Arrays.stream(number).max().getAsInt(); // 이 부분을 무조건 long으로 해주어야 한다.
		while(left<=right) {
			long mid = (left + right) / 2;
			long sum=0;
			for (int t=0; t<N; t++) {
				if (number[t]<=mid) continue;
				sum+=(number[t]-mid);
			}
			if (sum<M) right = mid-1; // 나무 높이를 올려야 한다.
			else left = mid+1;
		}
		System.out.println(left+"  "+right);
		System.out.println(left-1);
	}

}
