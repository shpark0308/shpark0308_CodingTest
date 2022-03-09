package 백준;

import java.util.*;

public class 빗물_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), W = sc.nextInt();
		int[] location = new int[W];
		for (int i=0; i<W; i++) location[i] = sc.nextInt();
		
		int start, end = 0, sum=0;
		
		for (int i=1; i<W-1; i++) { // 하나하나 해보는 것 -> 생각보다 간단한 문제 하나하나 비교해보는 문제
			start = end = 0;
			
			// 왼쪽에서 가장 높은 건물의 높이
			for (int j=0; j<i; j++) {
				start = Math.max(location[j], start);
			}
			// 오른쪽에서 가장 높은 건물의 높이
			for (int j = i+1; j<W; j++) {
				end = Math.max(location[j], end);
			}
			
			int loc = Math.min(start, end);
			if (location[i]<loc) sum+=(loc-location[i]);
		}
		System.out.println(sum);

	}

}
