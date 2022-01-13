package 백준;

import java.util.*;
import java.io.*;

public class 집합의표현 {
	public static int n,m;
	public static int[] parent;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]); m = Integer.parseInt(str[1]);
		parent = new int[n+1];
		for (int i=0; i<=n; i++) parent[i] = i;
		
		for (int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			int op = Integer.parseInt(str[0]); int a = Integer.parseInt(str[1]); int b = Integer.parseInt(str[2]);
			if (op==0) {
				/* union 작업 */
				int aRoot = find(a);
				int bRoot = find(b);
				if (aRoot!=bRoot) {
					parent[bRoot] = aRoot; // 이렇게 묶어줌
				}
			}
			else {
				if (find(a)==find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
			
			
		}
		
	}
	public static int find(int num) {
		if (parent[num]==num) return num;
		return parent[num] = find(parent[num]);
	}

}
