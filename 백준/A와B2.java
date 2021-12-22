package 연습문제;

import java.util.Scanner;

public class A와B2 {
	public static String S, T;
	public static int answer = 0;
	
	/* S - > T로 탐색하는 것은 2^3이 필요 */
	/* T - > S로 탐색하는 것은 필요 조건에 따라 검색하는 거여서 적게 탐색 */

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
