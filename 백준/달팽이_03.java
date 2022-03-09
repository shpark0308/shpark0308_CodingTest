package 백준;

import java.util.*;
import java.awt.*;

public class 달팽이_03 {
	public static int N, T;
	public static int[][] DP;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); T = sc.nextInt();
		DP = new int[N][N];
		
		int  cx = N/2, cy = N/2;
		int count = 1, num = 1;
		
		while(true) {
			for (int i=0; i<count; i++) DP[cx--][cy] = num++; // 위로 올라감
			if ((num-1)==(N*N)) break;
			
			for (int i=0; i<count; i++) DP[cx][cy++] = num++;
			
			count++;
			for (int i=0; i<count; i++) DP[cx++][cy] = num++;
			for (int i=0; i<count; i++) DP[cx][cy--] = num++;
			
			count++;
			
		}
		
		Point point = new Point();
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				if (DP[a][b]==T) point.setLocation(a,b);
				System.out.print(DP[a][b]+" ");
			}
			System.out.println();
		}
		System.out.println((point.x+1)+" "+(point.y+1));

	}

}
