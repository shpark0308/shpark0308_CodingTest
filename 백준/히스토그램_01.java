package 백준;

import java.util.Scanner;

public class 히스토그램_01 {
	public static int[] DP = new int[100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=0; i<N; i++) DP[i] = sc.nextInt();
		System.out.println(divide(0,N-1));

	}
	public static int divide(int left,int right) {
		if (left==right) {
			return DP[left];
		}
		int mid = (left+right)/2;
		int max_area = Math.max(divide(left,mid), divide(mid+1, right));
		/* 가운데 검색 */
		int min_height = Math.min(DP[mid], DP[mid+1]);
		int temp_area = min_height*2;
		int a = mid, b = mid+1;
		while(b-a<right-left) {
			if (a==left||DP[b+1]>DP[a-1]) {
				b++;
				min_height = Math.min(min_height, DP[b]); // 계속 뒤로 가면서 확인하기
			}
			else {
				a--;
				min_height = Math.min(min_height, DP[a]);
			}
			temp_area = Math.max(temp_area, (b-a+1)*min_height);
		}
		return Math.max(max_area, temp_area);
	}

}
