package ��������;

import java.util.Scanner;

public class A��B2 {
	public static String S, T;
	public static int answer = 0;
	
	/* S - > T�� Ž���ϴ� ���� 2^3�� �ʿ� */
	/* T - > S�� Ž���ϴ� ���� �ʿ� ���ǿ� ���� �˻��ϴ� �ſ��� ���� Ž�� */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new  Scanner(System.in);
		S = sc.next(); T = sc.next();
		dfs(T.length()-1, T);
		System.out.println(answer);

	}
	public static void dfs(int depth, String str) {
		if (depth==S.length()-1) {
			if (str.equals(S)) {
				answer = 1;
			}
			return;
		}
		
		if (str.charAt(depth)=='A') {
			dfs(depth-1, str.substring(0, depth));
		}
		if (str.charAt(0)=='B') {
			dfs(depth-1, new StringBuffer(str.substring(1)).reverse().toString());
		}
	}

}
