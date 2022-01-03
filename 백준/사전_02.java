package ����;

import java.util.*;

public class ����_02 {
	public static double[][] DP;
	public static String answer="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		double finalnum = sc.nextDouble();
		
		DP = new double[N+1][M+1];
		
		calculate(N,M, finalnum);
		if (fillDP(N,M)<finalnum) System.out.println("-1");
		else System.out.println(answer);

	}
	
	public static void calculate(int n, int m, double finalnum) {
		if (n==0) {
			// ���� m ����ŭ z �߰�
			for (int i=0; i<m; i++) answer+="z";
			return;
		}
		if(m==0) {
			// ���� m ����ŭ z �߰�
			for (int i=0; i<n; i++) answer+="a";
			return;
		}
		double priorcount = fillDP(n-1, m);
		if (finalnum>priorcount) {
			answer+="z";
			calculate(n, m-1, finalnum-priorcount);
		}
		else {
			answer+="a";
			calculate(n-1, m, finalnum);
		}
	}
	
	public static double fillDP(int n, int m) {
		if (n==0||m==0) {
			return DP[n][m]=1;
		}
		if (DP[n][m]!=0) return DP[n][m];
		return DP[n][m] = Math.min(fillDP(n-1, m)+fillDP(n, m-1), 1000000001);
	}

}
