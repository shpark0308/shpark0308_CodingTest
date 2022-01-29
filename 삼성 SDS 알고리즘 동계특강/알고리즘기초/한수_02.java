package 알고리즘기초;

import java.util.Scanner;

public class 한수_02 {
	public static int N, count=0;
	/* 재귀함수 작성 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if ((N+"").length()<3) System.out.println(N);
		else {
			int count=99;
			for (int start_num=100; start_num<=N; start_num++) {
				if (recursion(start_num)) count++;
			}
			System.out.println(count);
		}
	}
	public static boolean recursion(int start_num) {
		String[] str = (start_num+"").split("");
		int index = Integer.parseInt(str[1])-Integer.parseInt(str[0]);
		for (int i=2; i<str.length;i++) {
			if (Integer.parseInt(str[i])-Integer.parseInt(str[i-1])!=index) return false;
		}
		return true;
	}

}
