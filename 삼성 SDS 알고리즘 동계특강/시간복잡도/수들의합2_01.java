package 시간복잡도;

import java.util.Scanner;

public class 수들의합2_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] number = new int[N];
		for(int i=0; i<N; i++) number[i] = sc.nextInt();
		/* 일단 무식한 방법으로 하기 */
		
		int window_size = number[0], count=0, end=0, b;
		for (int a=0; a<N ; a++ ) {
			for (b=(end+1); window_size<M&&b<N; b++) {
				window_size+=number[b];
			}
			// 크거나 같을 것이다
			end = b-1;
			if (window_size==M) count++;
			System.out.println(">>>>>"+a+"   "+end+"    "+window_size+"   "+count);
			window_size-=number[a];
			
		}
		System.out.println(count);

	}

}
