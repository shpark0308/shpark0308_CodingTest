package 백준;

import java.io.*;
import java.util.*;

public class 선수과목_01 {
	/* 일단 위상정렬로 풀기 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
		
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<=N; i++) array.add(new ArrayList<Integer>());
		
		int[] indegree = new int[N+1], DP = new int[N+1];
		/* 그냥 일단 하기 */
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]), end = Integer.parseInt(str[1]);
			array.get(start).add(end); indegree[end]++;
		}
		System.out.println(Arrays.toString(indegree));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i=1; i<=N; i++) {
			if (indegree[i]==0) {
				queue.add(i);
				DP[i]=1;
			}
		}
		int time = 1;
		while(!queue.isEmpty()) {
			System.out.println(queue);
			time++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				int num = queue.poll();
				for (int k=0; k<array.get(num).size(); k++) {
					int temp = array.get(num).get(k);
					indegree[temp]--;
					if (indegree[temp]==0) {
						DP[temp] = time;
						queue.add(temp);
					}
				}
				
			}
			System.out.println(Arrays.toString(DP));
		}
		for (int i=1; i<=N; i++) System.out.print(DP[i]+" ");

	}

}
