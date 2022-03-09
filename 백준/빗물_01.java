package น้มุ;

import java.util.*;

public class บ๘นฐ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), W = sc.nextInt();
		int[] DP = new int[W];
		for (int i=0; i<W; i++) DP[i] = sc.nextInt();
		
		int start = -1, end = start+1;
		int startloc = DP[0], endloc;
		
		int sum = 0;
		
		while(end<W) {
			if (start<0) startloc = DP[0];
			else startloc = DP[start];
			while(end<W&&DP[end]<startloc) {
				end++;
			}
			if (end>=W) {
				endloc = DP[end-1];
				end = end-1;
			}
			else endloc = DP[end];
			int loc = Math.min(startloc, endloc);
			System.out.println(start+" / "+end+" / "+startloc+" / "+endloc+" / &&&&& "+loc);
			for (int i=(end-1); i>start; i--) sum+=(loc-DP[i]);
			System.out.println(">>>> "+sum);
			start = end;
			end = start+1;
		}
		System.out.println(sum);
	}

}
