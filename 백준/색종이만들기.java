package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����̸���� {
	public static int N, white=0, blue=0;
	public static int[][] Arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// ���� ����
		/*
		 * 1. �� ���� �� �ִ��� Ȯ���ϱ�
		 * 2. ����
		 * 3. Ž�� -> ��ġ��
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arr = new int[N][N];
		for (int a=0; a<N; a++) {
			String[] str = br.readLine().split(" ");
			for (int b=0; b<N; b++) {
				Arr[a][b] = Integer.parseInt(str[b]);
			}
		}
		partition(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	public static void partition(int row, int col, int size) {
		// ������ ���� ���ϱ�
		if (check(row, col, size)) { // ������ ���ص� �ȴٸ�
			if (Arr[row][col]==0) white++;
			else blue++;
			return;
		}
		int newsize = size/2;
		partition(row, col, newsize);
		partition(row+newsize, col, newsize);
		partition(row, col+newsize, newsize);
		partition(row+newsize, col+newsize, newsize);
		
	}
	
	public static boolean check(int row, int col, int size) {
		int color = Arr[row][col];
		for (int a=row; a<row+size; a++) {
			for (int b=col; b<col+size; b++) {
				if (Arr[a][b]!=color) return false;
			}
		}
		return true;
	}

}
