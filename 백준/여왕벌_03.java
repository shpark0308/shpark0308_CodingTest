package ����;

import java.io.*;
import java.util.Arrays;

public class ���չ�_03 {
	public static int M, N;
	public static int[][] Arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 1. Scanner ���� BufferedReader ���
		 * 2. ���� ������ �ƴ� �����ؼ� ������� */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]); N = Integer.parseInt(str[1]);
		Arr = new int[M][M];
		for (int i=0; i<M; i++) Arrays.fill(Arr[i], 1);
		
		for (int i=0; i<N; i++) {
			/* �׳� �� ä�� �ְ� �����ϱ� */
			str = br.readLine().split(" ");
			int zero = Integer.parseInt(str[0]); 
			int one = Integer.parseInt(str[1]); 
			int two = Integer.parseInt(str[2]); 

			// ���� ���� �� �ֹ��� Ű��� 
			for(int a = M-1; a > 0; a--) { 
				if(zero != 0) zero--;
				else if(one != 0) { one--; Arr[a][0] += 1; } // Arr ä�� �ֱ�
				else if(two != 0) { two--; Arr[a][0] += 2; }
			}

			// ���� ���� �� �ֹ��� Ű��� 
			for(int b = 0; b < M; b++) {
				if(zero != 0) zero--;
				else if(one != 0) { one--; Arr[0][b] += 1; } 
				else if(two != 0) { two--; Arr[0][b] += 2; }
			}
		}
		for (int a=1; a<M; a++) {
			for (int b=1; b<M; b++) {
				Arr[a][b] = Math.max(Arr[a][b-1], Math.max(Arr[a-1][b-1], Arr[a-1][b]));
			}
		}
		for (int a=0; a<M; a++) {
			for (int b=0; b<M; b++) System.out.print(Arr[a][b]+" ");
			System.out.println();
		}
	}
}
