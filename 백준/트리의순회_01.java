package 백준;

import java.util.HashMap;
import java.util.Scanner;

public class 트리의순회_01 {
	public static int N, index;
	public static HashMap<Integer, Integer> inorder = new HashMap<Integer, Integer>();
	public static int[] postorder, preorder;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		postorder = new int[N]; preorder = new int[N];
		for (int i=0; i<N; i++) inorder.put(sc.nextInt(), i);
		for (int i=0; i<N; i++) postorder[i] = sc.nextInt();
		divide(0,N-1, 0, N-1);
		for (int i=0; i<N; i++) System.out.print(preorder[i]+" ");
		

	}
	public static void divide(int in_start, int in_end, int post_start, int post_end) {
		if (in_end<in_start||post_end<post_start) return;
		int root = postorder[post_end];
		preorder[index++] = root;
		int root_index = inorder.get(root);
		divide(in_start, root_index-1, post_start, post_start+(root_index-in_start-1));
		divide(root_index+1, in_end, post_start+(root_index-in_start), post_end-1);
	}

}
