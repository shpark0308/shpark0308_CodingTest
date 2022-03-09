package น้มุ;

import java.util.*;

public class บ๘นฐ_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), W = sc.nextInt();
		int[] location = new int[W];
		for (int i=0; i<W; i++) location[i] = sc.nextInt();
		
		int start = 0, end = start+1;
		int startloc = location[start], endloc;
		int sum=0;
		if (startloc==0) {
			for ( ; end<W&&location[end]<=startloc;) {
				end++;
			}
			for (int j=(end-1); j>=0; j--) sum+=(location[end]-location[j]);
			start = end; end = start+1;
		}
		
		while(end<W) {
			startloc = location[start];
			while(end<W&&location[end]<startloc) {
				end++;
			}
			end = end>=W?end-1:end;
			endloc = location[end];
			int loc = Math.min(startloc, endloc);
			for (int j=(end-1); j>start;j-- ) sum+=(loc-location[j]);
			System.out.println(start+" / "+end+" / "+startloc+" / "+endloc+" / >>"+sum);
			start = end; end = start+1;
			System.out.println(sum);
		}
		System.out.println("&& "+sum);

	}

}
