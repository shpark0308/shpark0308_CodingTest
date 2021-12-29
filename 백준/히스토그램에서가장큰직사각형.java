package 백준;


import java.util.Scanner;

public class 히스토그램에서가장큰직사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		while((N=sc.nextInt())!=0) {
			long[] DP = new long[100001];
			for (int a=0; a<N;a++) DP[a] = (sc.nextLong());
			System.out.println(divide(0, N-1,DP));
		}
	}
	public static long divide(int left, int right, long[] DP) {
		if (left==right) return DP[left];
		int mid = (left+right)/2;
		long max_value = Math.max(divide(left, mid, DP), divide(mid+1, right, DP));
		/* 가운데 꺼 기준 */
		long min_height = Math.min(DP[mid], DP[mid+1]);
		long temp_area = 2*min_height;
		int a = mid, b = mid+1;
		while(b-a<right-left) { // 그 범위에서 못넘어가게
			if (a==left||DP[b+1]>DP[a-1]) {
				b++;
				min_height = Math.min(min_height, DP[b]);
			}
			else {
				a--;
				min_height = Math.min(min_height, DP[a]);
			}
			temp_area = Math.max(temp_area, (b-a+1)*min_height);
		}
		return Math.max(max_value, temp_area);
	}

}
