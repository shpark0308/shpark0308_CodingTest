package 조합론;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class N과M_01 {
	public static int N, M;
	public static int[] number;
	public static Set<String> set = new LinkedHashSet<String>();
	/* 순열 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		number = new int[N];
		for (int i=0; i<N; i++) number[i] = sc.nextInt();
		boolean[] visited = new boolean[N];
		Arrays.sort(number); /* 먼저 정렬을 시켜주기 */
		permuation(0, "", visited);
		for (String ans : set) {
			System.out.println(ans.substring(1));
		}
		

	}
	public static void permuation(int index, String arr, boolean[] visited) {
		if (index==M) {
			if (!set.contains(arr)) set.add(arr);
			return;
		}
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permuation(index+1, arr+" "+number[i], visited);
				visited[i] = false;
			}
		}
		
	}

}
