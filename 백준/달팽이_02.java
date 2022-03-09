package 백준;

import java.util.*;
import java.awt.*;

public class 달팽이_02 {
	public static int N, T;
	public static int[] go_X = { -1, 0, 1, 0 };
	public static int[] go_Y = { 0, 1, 0, -1 };
	public static Point point = new Point();
	public static int[][] DP;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); T = sc.nextInt();
		DP = new int[N][N];
		
		int count = 0, cnt = 0, move_count = 1, dir = 0, corner = 0; // 5 가지
		
		int cx = N/2, cy = N/2;
		
		while(count<N*N) {
			DP[cx][cy] = ++count;
			if (DP[cx][cy]==T) point.setLocation(cx, cy);
			cnt++; // 그만큼 간거
			
			cx+=go_X[dir];
			cy+=go_Y[dir];
			
			if (cnt==move_count) {
				dir = (dir==3)?0:dir+1;
				cnt=0;
				corner++;
			}
			if (corner==2) {
				move_count++;
				corner = 0;
			}
			
		}
		
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) System.out.print(DP[a][b]+" ");
			System.out.println();
		}
		System.out.println((point.x+1)+" "+(point.y+1));

	}

}
