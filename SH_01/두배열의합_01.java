
import java.util.*;
import java.io.*;

public class 두배열의합_01 {
	public static int T, n, m;
	public static ArrayList<Integer> listA = new ArrayList<Integer>();
	public static ArrayList<Integer> listB = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i=0; i<n; i++) A[i] = Integer.parseInt(str[i]);
		
		m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		str = br.readLine().split(" ");
		for (int i=0; i<m; i++) B[i] = Integer.parseInt(str[i]);
		
		for (int a=0; a<n; a++) {
			int sum = 0;
			for (int b=a; b<n; b++) {
				sum+=A[b];
				listA.add(sum);
			}
		}
		
		for (int a=0; a<m; a++) {
			int sum = 0;
			for (int b=a; b<m; b++) {
				sum+=B[b];
				listB.add(sum);
			}
		}
		
		Collections.sort(listA);
		Collections.sort(listB);
		
		int pa = 0, pb = listB.size()-1;
		long answer = 0;
		
		while(pa<listA.size()&&pb>=0) {
			int total = listA.get(pa)+listB.get(pb);
			
			if (total==T) {
				int answer_a = listA.get(pa);
				int answer_b = listB.get(pb);
				
				long aCnt = 0, bCnt = 0;
				
				for ( ; pa<listA.size()&&listA.get(pa)==answer_a; pa++, aCnt++ ) { };
				
				for ( ; pb>=0&&listB.get(pb)==answer_b; pb--, bCnt++ ) { };
				
				answer+=(aCnt*bCnt);
			}
			else if (total>T) pb--;
			else pa++; // total < T
		}
		
		System.out.println(answer);
	}

}
