package 백준;

import java.util.*;
import java.io.*;

public class 함께블록쌓기_01 {
	public static int N, M, H;
	public static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); H = Integer.parseInt(str[2]);
		long[][] DP = new long[N+1][H+1];
		
		array.add(new ArrayList<Integer>());
		for (int a=1; a<=N; a++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			str = br.readLine().split(" ");
			for (int b=0; b<str.length; b++) ar.add(Integer.parseInt(str[b]));
			Collections.sort(ar);
			array.add(ar);
		}
		
		for (int a=0; a<=N; a++) DP[a][0] = 1;


		for (int a=1; a<=N; a++) {
			for (int h = 1; h <= H; h++) {
				for (int k=0; k<array.get(a).size()&&array.get(a).get(k)<=h; k++) {
					int num = array.get(a).get(k);
					DP[a][h] += DP[a-1][h-num];
				}
				DP[a][h] += DP[a-1][h];
			}
		}
		System.out.println(DP[N][H]%10007);
		
		
		

	}

}
