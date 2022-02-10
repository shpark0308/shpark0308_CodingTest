package 백준;

import java.util.*;

public class Z_01 {
	public static int N, r, c, answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = (int)Math.pow(2, sc.nextInt()); r = sc.nextInt(); c = sc.nextInt();
		dfs(0,0,N);
	}
	
	public static void dfs(int x, int y, int n) {
		if (x==r&&y==c) {
			System.out.println(answer);
			System.exit(0); // 더이상 안하게 됨
		}
		if (x<=r&&r<(x+n)&&y<=c&&c<(y+n)) {
			n = n/2;
			dfs(x,y, n);
			dfs(x, y+n, n);
			dfs(x+n, y, n);
			dfs(x+n, y+n, n);
		}
		else answer+=n*n;
	}

}
