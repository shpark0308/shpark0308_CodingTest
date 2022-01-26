package 동적계획법01;

import java.io.*;
import java.util.Arrays;

public class 가장큰사각형_02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
		int[][] number = new int[n][m], calculate = new int[n][m];
		for (int a=0; a<n; a++) {
			str = br.readLine().split("");
			for (int b=0; b<m; b++) number[a][b] = Integer.parseInt(str[b]);
		}
		int maxlen = number[0][0];
				
		System.arraycopy(number[0],0 , calculate[0], 0, m);
		System.out.println(Arrays.toString(calculate[0]));
		for (int a=1; a<n; a++) {
			calculate[a][0] = number[a][0];
			for (int b=1; b<m; b++) {
				if (number[a][b]==1) {
					if (number[a][b-1]==0||number[a-1][b]==0||number[a-1][b-1]==0) calculate[a][b]=1;
					else calculate[a][b] = Math.min(calculate[a][b-1], Math.min(calculate[a-1][b], calculate[a-1][b-1]))+1;
					maxlen = Math.max(maxlen, calculate[a][b]);
				
				}
			}
			System.out.println(Arrays.toString(calculate[a]));
		}
		System.out.println(maxlen*maxlen);
		
	}

}
