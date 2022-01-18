package 시간복잡도;

import java.util.Scanner;

public class 부분합_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minlen = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), S = sc.nextInt();
		int[] number = new int[N];
		for (int i=0; i<N; i++) number[i] = sc.nextInt();
		int end = 0, window_size = number[0], b;
		for (int a=0;a<N ;a++) {
			for (b=(end+1);window_size<S&&b<N ;b++ ) {
				window_size+=number[b];
			}
			end = b-1;
			if (window_size>=S) minlen = Math.min(minlen, end-a+1);
			System.out.println(a+"  "+end+"  "+window_size+"  "+(end-a+1)+"   minlen = "+minlen);
			window_size-=number[a];
		}
		minlen = minlen==Integer.MAX_VALUE?0:minlen;
		System.out.println(minlen);

	}

}
