package 백준;

import java.util.Scanner;

public class 투에모스문자열_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int index=0;
		while(N>2) {
			long totalNum = (long) Math.pow(2,Math.ceil(Math.log10(N)/Math.log10(2))-1);
			index++;
			N-=totalNum;
		}
		int answer = 0;
		if (N==1) answer = (index%2)==0?0:1;
		else answer = (index%2)==0?1:0;
		System.out.println(answer);

	}
	

}
