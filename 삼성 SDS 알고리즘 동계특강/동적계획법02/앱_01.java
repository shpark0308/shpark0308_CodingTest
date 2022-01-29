package µ¿Àû°èÈ¹¹ý02;

import java.io.*;
import java.util.Arrays;

public class ¾Û_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
		int[] MemoryArr = new int[N], CostArr = new int[N];
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) MemoryArr[i] = Integer.parseInt(str[i]);
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) CostArr[i] = Integer.parseInt(str[i]);
		
		int total = Arrays.stream(CostArr).sum();
		int[] DP = new int[total+1];
		for (int idx=0; idx<N; idx++) {
			for (int c = total; c>=CostArr[idx]; c--) {
				DP[c] = Math.max(DP[c], DP[c-CostArr[idx]]+MemoryArr[idx] );
			}
		}
		int answer = 0;
		for (int i=0; i<=total; i++) {
			if (M<=DP[i]) {
				answer = i; 
				break;
			}
		}
		System.out.println(answer);

	}

}
