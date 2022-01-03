package ¹éÁØ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ¿©¿Õ¹ú_02 {
	public static int M, N;
	public static int[][] Arr;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]); N = Integer.parseInt(str[1]);
		Arr = new int[M][M];
		for (int i=0; i<M; i++) Arrays.fill(Arr[i], 1);
		
		for (int i=0; i<N; i++) {
			int[] number = new int[3];
			str = br.readLine().split(" ");
			number[0] = Integer.parseInt(str[0]); number[1] = Integer.parseInt(str[1]); number[2] = Integer.parseInt(str[2]);
			calculate(number);
		}
		
		for (int a=0; a<M; a++) {
			for (int b=0; b<M; b++) {
				System.out.print(Arr[a][b]+" ");
			}
			System.out.println();
		}

	}
	
	public static void calculate(int[] number) {
		int cx = 0, cy = M-1;
		int idx = 2;
		for (int t=2*M-1; t>M; t--) {
			if (number[idx]==0) idx--;
			Arr[cx][cy] +=idx;
			number[idx]--;
			for (int v=0; v<M; v++) {
				Arr[v][cy] = Arr[cx][cy];
			}
			cy-=1;
		}
		cx=0; cy=0;
		for (int t=M; t>0; t--) {
			if (number[idx]==0) idx--;
			if (idx==0) break;
			Arr[cx][cy] +=idx;
			number[idx]--;
			cx+=1;
		}
	}

}
