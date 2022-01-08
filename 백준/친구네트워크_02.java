package 백준;

import java.io.*;
import java.util.*;

public class 친구네트워크_02 {
	
	public static int[] parent, totalnum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> indexnum = new HashMap<String, Integer>();
		for (int i=0; i<T; i++) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F*2];
			totalnum = new int[F*2];
			Arrays.fill(totalnum, 1);
			int index=0;
			for (int f=0; f<F; f++) {
				String[] friend = br.readLine().split(" ");
				if (!indexnum.containsKey(friend[0])) {
					/* 초기화 */
					indexnum.put(friend[0], index);
					parent[index] = index++;
				}
				if (!indexnum.containsKey(friend[1])){
					indexnum.put(friend[1], index);
					parent[index] = index++;
				}
				int aRoot = find(indexnum.get(friend[0]));
				int bRoot = find(indexnum.get(friend[1]));
				if (aRoot!=bRoot) {
					parent[bRoot] = aRoot;
					totalnum[aRoot]+=totalnum[bRoot];
				}
				System.out.println(totalnum[aRoot]);
			}
			
			indexnum.clear();
		}
		
		
	}
	public static int find(int num) {
		if (parent[num]==num) return num;
		return parent[num] = find(parent[num]);
	}

}
