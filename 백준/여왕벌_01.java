package ¹éÁØ;

import java.io.*;
import java.util.Arrays;

public class ¿©¿Õ¹ú_01 {
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
			str = br.readLine().split(" ");
			String strr = "";
			strr += "0".repeat(Integer.parseInt(str[0])); strr += "1".repeat(Integer.parseInt(str[1])); strr += "2".repeat(Integer.parseInt(str[2]));
			calculateDP(strr);
		
		}
		for (int a=0; a<M; a++) {
			for (int b=0; b<M; b++) System.out.print(Arr[a][b]+" ");
			System.out.println();
		}
		

	}
	public static void calculateDP(String str) {
		boolean direct=true;
		int cx = M-1, cy=0;
		for (int i=0; i<str.length(); i++) {
			Arr[cx][cy] +=Integer.parseInt(str.charAt(i)+"");
			if (direct) cx-=1;
			else cy+=1;
			if (cx<0) {
				cx=0; cy=1;
				direct = false;
			}
		}
		for (int a=1; a<M; a++) {
			for (int b=1; b<M; b++) {
				int max = Arr[a][b-1];
				max = Math.max(max, Arr[a-1][b-1]);
				max = Math.max(max, Arr[a-1][b]);
				Arr[a][b] = max;
			}
		}
	}

}
