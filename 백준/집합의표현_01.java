package 백준;

import java.util.*;

public class 집합의표현_01 {
	public static int N, M;
	public static int[] parents;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		parents = new int[N+1];
		for (int i=0; i<=N; i++) parents[i] = i;

		
		for (int i=0; i<M; i++) {
			int op = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
			if (op==1) {
				int num_a = find(a);
				int num_b = find(b);
				if (num_a==num_b) System.out.println("YES");
				else System.out.println("NO");
			}
			else {
				int num_a = find(a);
				int num_b = find(b);
				if (num_a!=num_b) parents[num_a] = num_b; // join
				System.out.println(Arrays.toString(parents));
			}
		}
	}
	
	public static int find(int num) {
		if (parents[num]==num) return parents[num];
		return parents[num] = find(parents[num]);
	}

}
