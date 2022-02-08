package น้มุ;

import java.util.*;
import java.util.stream.Collectors;

public class ผาวณ_01 {
	public static int K, N, F;
	public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
	public static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); N = sc.nextInt(); F = sc.nextInt();
		
		for (int i=0; i<=N; i++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			ar.add(i);
			graph.put(i,ar);
		}
		for (int i=0; i<F; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			graph.get(a).add(b); graph.get(b).add(a);
		}
		for (int i=0; i<=N; i++) if (graph.get(i).size()<K) graph.remove(i);
		
		
		
		int[] array = new int[K];
		combination(K, 0, array);
		if (!flag) System.out.println(-1);
		
		
		

	}
	public static void combination(int index, int start, int[] array) {
		if (flag) return;
		if (index==0) {
			for (int a=0; a<K; a++) {
				if (!graph.get(array[a]).containsAll(Arrays.stream(array).boxed().collect(Collectors.toList()))) return;
			}
			for (int a=0; a<K; a++) System.out.println(array[a]);
			flag = true;
			return;
		}
		for (int i=start; i<N; i++) {
			if (graph.containsKey(i+1)) {
				array[K-index] = (i+1);
				combination(index-1, i+1, array);
			}
			
		}
	}
}
