package 시간복잡도;

import java.util.Scanner;

public class 게임_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long X = sc.nextInt(), Y = sc.nextInt();
		long Z = (Y*100/X);
		if (Z>=99) System.out.println(-1);
		else {
			long start = 1, end=X;
	        while (start <= end) {
	            long mid = (start + end) / 2;
	            long calc = (Y + mid) * 100 / (X + mid);

	            if (calc > Z) end = mid - 1;
	            else start = mid + 1;
	        }
	        System.out.println(start);
		}

	}

}
