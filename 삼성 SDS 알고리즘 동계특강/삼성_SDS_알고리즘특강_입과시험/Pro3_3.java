package 삼성_SDS_알고리즘특강_입과시험;

import java.util.ArrayList;
import java.util.Scanner;

public class Pro3_3 {
	public static ArrayList<Integer> camploc = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub4
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int a=0; a<N; a++) {
				arr[a] = sc.nextInt();
				if (arr[a]==3) camploc.add(a);
			}
			int finalend = camploc.get(camploc.size()-1);
			System.out.println(camploc+"  "+finalend);
			int time=0;
			for (int cur=0; cur<finalend; ) {
				int end = cur+15;
				int target_index = checktarget(cur, end);
				int target = camploc.get(target_index);
				while(true) {
					for (int a=(cur+6); a>cur; a--) {
						if (arr[a]==2) {
							
						}
					}
				}
				
			}
			camploc.clear();
		}

	}

	public static int checktarget(int start, int end) {
		int i=0;
		for (i=camploc.size()-1; (i>=0)&&camploc.get(i)>end; i--) {
			
		}
		camploc.remove(i);
		return i;
	}
}
