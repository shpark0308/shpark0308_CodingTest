package 백준;

import java.util.*;

public class Z_02 {
	public static int N,r,c, num;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); r = sc.nextInt(); c = sc.nextInt();
		
		divide(0,0,(int)Math.pow(2, N));
	}
	
	public static void divide(int x, int y, int size) {
		/* 전부 다 돌필요는 없다 */
		if (x==r&&y==c) {
			System.out.println(num);
			System.exit(0);
		}
		if (x<=r&&r<x+size&&y<=c&&c<y+size) {
			System.out.println("NUM = "+num);
			size/=2;
			divide(x, y, size);
			divide(x, y+size, size);
			divide(x+size, y, size);
			divide(x+size, y+size, size);
		}
		else num+=(size*size);
		
		
	}

}
