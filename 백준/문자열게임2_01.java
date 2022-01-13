package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 1. Sliding window -> window size 가 없다
		 * 2. 무식하게 하기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (int a=0; a<str.length()-K; a++) {
				String temp1 = str.substring(a+1);
				char findchar = str.charAt(a);
				String temp2 = findchar+"";
				int index=1, num;
				while((num = temp1.indexOf(findchar))!=-1&&index<K) {
					temp2 += temp1.substring(0,num+1);
					temp1 = temp1.substring(num+1);
					index++;
				}
				if (index==K) {
					System.out.println(temp2);
					max = Math.max(max, temp2.length());
					min = Math.min(min, temp2.length());
				}
			}
			if (min==Integer.MAX_VALUE&&max==Integer.MIN_VALUE) System.out.println("-1");
			else System.out.println(min+" "+max);
		}
		

	}

}
