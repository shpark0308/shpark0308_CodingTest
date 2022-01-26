package µ¿Àû°èÈ¹¹ý01;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Çà·Ä°ö¼À¼ø¼­_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Point> arraylist = new ArrayList<Point>();
		for (int i=0; i<N; i++) arraylist.add(new Point(sc.nextInt(), sc.nextInt()));
		
		int[][] DP = new int[N][N];
		for (int a=1; a<N; a++) {
			int start = a;
			for (int b=0; b<(N-a); b++, start++) {
				DP[b][start] = Integer.MAX_VALUE;
				for (int c=b; c<start; c++) {
					DP[b][start] = Math.min(DP[b][start], DP[b][c]+DP[c+1][start]+arraylist.get(b).x*arraylist.get(c).y*arraylist.get(start).y);
				}
			}
		}
		System.out.println(DP[0][N-1]);
	}

}
