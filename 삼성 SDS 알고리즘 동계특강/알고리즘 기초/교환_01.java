package �˰������;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ��ȯ_01 {
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
	/* ������ ���� �� ���غ��� */
	public static void dfs(]int[] number, int index) { // �ϴ� �غ���
		// 1. check -in
		// 2. ������
		if (index==K) {
			System.out.println(Arrays.toString(number));
			return;
		}
		// 3. ����� ���� �ִ���?
		int[] copyarr = Arrays.copyOf(number, number.length);
		Arrays.sort(copyarr);
		int start, end;
		
		// 4. ���� �ִ���
		// 5. ����
		// 6. checkout
		
	}

}
