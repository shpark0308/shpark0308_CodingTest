package 동적계획법01;

import java.io.*;
import java.util.Arrays;

public class 정수삼각형_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int level = Integer.parseInt(br.readLine());
		int[][] triangle = new int[level][level+1];
		int[][] summation = new int[level][level+1];
		for (int a=0; a<level; a++) {
			String[] str = br.readLine().split(" ");
			for (int b=0; b<str.length; b++) triangle[a][b+1] = Integer.parseInt(str[b]);
		}
		
		summation[0][1] = triangle[0][1];
		System.out.println(Arrays.toString(summation[0]));
		for (int a=1; a<level; a++) {
			for (int b=1; b<=(a+1); b++) {
				summation[a][b] = Math.max(summation[a-1][b], summation[a-1][b-1])+triangle[a][b];
			}
			System.out.println(Arrays.toString(summation[a]));
		}
		int answer = Arrays.stream(summation[level-1]).max().getAsInt();
		System.out.println(answer);
	}

}
