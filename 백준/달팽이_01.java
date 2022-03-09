package πÈ¡ÿ;

import java.util.*;
import java.awt.*;

public class ¥ﬁ∆ÿ¿Ã_01 {
	public static int N, Num;
	public static int[][] DP;
	public static int[] go_X = { -1, 0, 1, 0 };
	public static int[] go_Y = { 0, 1, 0, -1 };
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); Num = sc.nextInt();
		
		DP = new int[N][N];
		
		int cx = N/2, cy = N/2;
		
		int dir = 0, count = 0, cnt = 0, move_count = 1, corner = 0;
		
		while(!(cx==-1&&cy==0)) {
			count++;
			cnt++;
			System.out.println("cx = "+cx+" cy = "+cy);
			DP[cx][cy] = count;
			
			cx+=go_X[dir];
			cy+=go_Y[dir];
			
			if (cx==0&&cy==-1) return;
			
			if (cnt==move_count) {
				dir = dir==3?0:dir+1;
				corner++;
				cnt=0;
			}
			if (corner==2) {
				move_count++;
				corner = 0;
			}
			
		}
		for (int a=0; a<N; a++) System.out.println(Arrays.toString(DP[a]));
		
		
		
		

	}

}
