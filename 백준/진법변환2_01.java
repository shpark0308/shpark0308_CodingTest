package 백준;

import java.util.*;


public class 진법변환2_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		char[] number = new char[36];
		number[0] = '0'; number[1] = '1'; number[2] = '2'; number[3] = '3'; number[4] = '4';
		number[5] = '5'; number[6] = '6'; number[7] = '7'; number[8] = '8'; number[9] = '9';
		
		for (int i=10; i<36; i++) number[i] = (char)('A'+(i-10));

		System.out.println(Arrays.toString(number));
		
		String str = "";
		
		while(N>=B) {
			int rem = N%B;
			N = N/B;
			str = number[rem]+str;
		}
		str = number[N]+str;

		System.out.println(str);
	}

}
