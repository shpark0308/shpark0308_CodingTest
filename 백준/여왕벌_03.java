package 백준;

import java.io.*;
import java.util.Arrays;

public class 여왕벌_03 {
	public static int M, N;
	public static int[][] Arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 1. Scanner 보다 BufferedReader 사용
		 * 2. 매일 매일이 아닌 누적해서 계산해줌 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]); N = Integer.parseInt(str[1]);
		Arr = new int[M][M];
		for (int i=0; i<M; i++) Arrays.fill(Arr[i], 1);
		
		for (int i=0; i<N; i++) {
			/* 그냥 다 채워 넣고 시작하기 */
			str = br.readLine().split(" ");
			int zero = Integer.parseInt(str[0]); 
			int one = Integer.parseInt(str[1]); 
			int two = Integer.parseInt(str[2]); 

			// 제일 왼쪽 열 애벌레 키우기 
			for(int a = M-1; a > 0; a--) { 
				if(zero != 0) zero--;
				else if(one != 0) { one--; Arr[a][0] += 1; } // Arr 채워 넣기
				else if(two != 0) { two--; Arr[a][0] += 2; }
			}

			// 제일 위쪽 행 애벌레 키우기 
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
