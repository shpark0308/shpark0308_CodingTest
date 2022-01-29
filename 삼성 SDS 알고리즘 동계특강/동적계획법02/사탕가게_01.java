package µ¿Àû°èÈ¹¹ı02;

import java.io.*;
import java.util.Arrays;

public class »çÅÁ°¡°Ô_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if (str.equals("0 0.00")) break;
			String[] strarr = str.split(" ");
			int N = Integer.parseInt(strarr[0]), M = (int)Math.round((Double.parseDouble(strarr[1])*100));
			int[] DP = new int[M+1];
			for (int i=0; i<N; i++) {
				strarr = br.readLine().split(" ");
				int C = Integer.parseInt(strarr[0]), cost = (int) Math.round((Double.parseDouble(strarr[1])*100));
				for (int m = cost; m<=M; m++) {
					DP[m] = Math.max(DP[m], DP[m-cost]+C);
				}
			}
			System.out.println(DP[M]);
		}
	}

}
