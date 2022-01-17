package 알고리즘기초;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 교환_01 {
	public static int N, K, L, max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt(); L = (N+"").length();
		String[] str = (N+"").split("");
		int[] number = new int[str.length];
		for (int i=0; i<str.length;i++) number[i] = Integer.parseInt(str[i]);
		max = N;
		dfs(0,0,number,0);
		System.out.println(max);

	}
	/* 조합을 전부 다 구해보기 */
	public static void dfs(]int[] number, int index) { // 일단 해보기
		// 1. check -in
		// 2. 목적지
		if (index==K) {
			System.out.println(Arrays.toString(number));
			return;
		}
		// 3. 연결된 곳이 있는지?
		int[] copyarr = Arrays.copyOf(number, number.length);
		Arrays.sort(copyarr);
		int start, end;
		
		// 4. 갈수 있는지
		// 5. 간다
		// 6. checkout
		
	}

}
