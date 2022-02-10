package 백준;

import java.io.*;

public class IF문좀대신써줘_02 {
	/* 이분 탐색 */
	public static int[] number;
	public static String[] name;
	public static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		
		number = new int[N]; name = new String[N];
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			name[i] = str[0]; number[i] = Integer.parseInt(str[1]);
		}
		
		for (int i=0; i<M; i++) System.out.println(binarySearch(Integer.parseInt(br.readLine())));


	}
	public static String binarySearch(int num) {
		int start = 0, end = N-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if (number[mid]<num) start = mid+1;
			else end = mid-1;
		}
		return name[start];
	}

}
