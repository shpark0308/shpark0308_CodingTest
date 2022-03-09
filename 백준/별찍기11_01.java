package 백준;

import java.util.*;

public class 별찍기11_01 {
	public static int N, K;
	public static char[][] DP;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 일단 해보기 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		DP = new char[N][5*(N/3)+((N/3)-1)];
		
		System.out.println(DP[0].length);
		K = (int)(Math.log10(N/3)/Math.log10(2));
		System.out.println(K);

	}
	
	public static void divide(int central, int y, int height) { // 그 구간만큼 나타내야함
		if (height==3) {
			DP[y][central] = '*';
			DP[y+1][central-1] = '*'; DP[y+1][central+1] = '*';
			DP[y+2][central-2] = '*'; DP[y+2][central-1] = '*'; DP[y+2][central] = '*'; DP[y+2][central+1] = '*'; DP[y+2][central+2]='*'; 
			return;
		}
		
		/* division */
	}

}
