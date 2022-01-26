package 동적계획법01;

import java.io.*;
import java.util.Arrays;

public class 구간합구하기5_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
		
		int[][] number = new int[N+1][N+1];
		int[][] summation = new int[N+1][N+1];
		for (int a=1; a<=N; a++) {
			str = br.readLine().split(" ");
			int sum = 0;
			for (int b=1; b<=N; b++) {
				number[a][b] = Integer.parseInt(str[b-1]);
				sum+=number[a][b];
				summation[a][b] = summation[a-1][b]+sum;
			}
		}
		for (int t=0; t<M; t++) {
			str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]), y1 = Integer.parseInt(str[1]), x2 = Integer.parseInt(str[2]), y2 = Integer.parseInt(str[3]);
			int answer = summation[x2][y2] - summation[x2][y1-1] - summation[x1-1][y2] + summation[x1-1][y1-1];
			System.out.println(answer);
		}

	}

}
