package 백준;

import java.util.*;

public class 모든순열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		permutation(output, visited, 0, N);
		//perm(new ArrayList<Integer>(), visited, 0, N);
		

	}
	public static void permutation(int[] output, boolean[] visited, int index, int n) {
		if (index==n) {
			for (int i=0; i<output.length; i++) {
				if (visited[i]) System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				output[index] = i+1;
				visited[i]=true;
				permutation(output, visited, index+1, n);
				visited[i]=false;
				output[index]=0;
			}
		}
	}
	/* 한번 array 를 사용해보기 */
	public static void perm(ArrayList<Integer> arr, boolean[] visited, int index, int n) {
		if (index==n) {
			System.out.println(arr);
			return;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.addAll(arr);
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				ar.add(i+1);
				visited[i]=true;
				perm(new ArrayList<Integer>(ar), visited, index+1, n);
				visited[i]=false;
				ar.remove(ar.size()-1);
			}
		}
	}

}
