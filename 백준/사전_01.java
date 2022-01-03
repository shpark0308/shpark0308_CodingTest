package 백준;

import java.math.BigInteger;
import java.util.*;

public class 사전_01 {
	public static Set<String> set = new HashSet<String>();
	public static char[] chararr;
	public static int finalnum=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		/* 가장 무식한 방법으로 하기 */
		chararr = new char[N+M];
		Arrays.fill(chararr, 0,N, 'a');
		Arrays.fill(chararr, N,chararr.length, 'z');
		finalnum = sc.nextInt();
		
		boolean[] visited = new boolean[N+M];
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		for (int i=(N+M); i>N; i--) n1 = n1.multiply(new BigInteger(i+""));
		for (int i=M; i>0; i--) n2 = n2.multiply(new BigInteger(i+""));
		n1 = n1.divide(n2);
		if (BigInteger.valueOf(finalnum).compareTo(n1)>0) {
			System.out.println("-1");
		}
		else {
			permutation("", visited, 0, N+M);
		}
		
		
	}
	public static void permutation(String str, boolean[] visited, int index, int n) {
		if (index==n) {
			if (!set.contains(str)) {
				set.add(str);
				if (set.size()==finalnum) {
					System.out.println(str);
					System.exit(0);
				}
			}
			return;
		}
		
		String st = str;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				st+=chararr[i];
				permutation(st, visited, index+1, n);
				visited[i] = false;
				st = st.substring(0, index);
			}
		}
	}
}
