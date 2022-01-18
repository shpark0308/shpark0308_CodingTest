package 시간복잡도;

import java.util.Scanner;

public class 게임_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(), Y = sc.nextInt();
		long Z = (Y*100/X);
		if (Z>=100) System.out.println(-1);
		else {
			int start = 0, end=X;
	        while (start <= end) {
	            int mid = (start + end) / 2;
	            long ratio = (Y + mid) * 100 / (X + mid);

	            if (ratio > Z) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        System.out.println(start);
		}

	}

}
