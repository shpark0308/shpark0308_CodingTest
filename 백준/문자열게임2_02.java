package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String[] str = br.readLine().split("");
			int K = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (int index=K,right=0, left; right<str.length-K; right++, index=K) {
				for (left = right; left<str.length; left++) {
					if (str[left].equals(str[right])) index--;
					if (index==0) {
						if ((left-right+1)>max) max = left-right+1;
						if ((left-right+1)<min) min = left-right+1;
						break;
					}
				}
				
			}
			if (min==Integer.MAX_VALUE&&max==Integer.MIN_VALUE) System.out.println("-1");
			else System.out.println(min+" "+max);
		}
	}

}
