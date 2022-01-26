package 동적계획법01;

import java.io.*;
import java.util.Arrays;

public class 가장큰사각형_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 부분합으로 풀기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
		int[][] number = new int[n+1][m+1], summation = new int[n+1][m+1];
		
		for (int a=1; a<=n; a++) {
			str = br.readLine().split("");
			int sum = 0;
			for (int b=1; b<=m; b++) {
				number[a][b] = Integer.parseInt(str[b-1]);
				sum+=number[a][b];
				summation[a][b] = summation[a-1][b]+sum;
			}
		}
		int maxarea = 0;
		
		/* 정사각형 탐색 */
		for (int a=1; a<=n; a++) {
			for (int b=1; b<=m; b++) {
				if (number[a][b]==1) {
					for (int index=0; a+index<=n&&b+index<=m;index++) {
						int area = summation[a+index][b+index] - summation[a-1][b+index] - summation[a+index][b-1]+summation[a-1][b-1];
						if (area!=(index+1)*(index+1)) break;
						maxarea = Math.max(maxarea, area);
					}
				}
			}
		}
		System.out.println(maxarea);

	}

}
