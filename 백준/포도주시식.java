package ����;

import java.util.Arrays;
import java.util.Scanner;

public class �����ֽý� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. ���� 3�� ���ø� �ȵȴ� : DP[i] = Math.max(DP[i-3]+arr[i-1], DP[i-2])+arr[i]; <- �̷��� �������� �ȵǰ� �ִ��� ���� �� ����
		 * 2. n-1 ��°�� n ������ ��
		 * && ��� ������� �ٸ��ٴ� �� : ���ݱ��� �Ѱ��߿��� max �ΰ��� ����
		 * 3. �ȸ��ŵ� �ȴٴ� ��
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i=1; i<=N; i++) arr[i] = sc.nextInt();
		int[] DP = new int[N+1];
		DP[1] = arr[1];
		if (N>=2) DP[2] = arr[1]+arr[2];
		int max = Integer.MIN_VALUE;
		if (N>=3) {
			for (int i=3; i<=N; i++) {
				DP[i] = Math.max(DP[i-3]+arr[i-1], DP[i-2])+arr[i];
				//DP[i] = Math.max(DP[i-1], DP[i]);
			}
		}
		System.out.println(Arrays.toString(DP));
		int answer = Math.max(DP[N-1], DP[N]);
		System.out.println(answer);

	}

}
