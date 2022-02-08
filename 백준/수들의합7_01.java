package 백준;

import java.io.*;
import java.util.*;

public class 수들의합7_01 {
	public static int N, M;
	public static long[] number, segmentTree;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		
		number = new long[N+1]; segmentTree = new long[4*N];
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int op = Integer.parseInt(str[0]);
			long a = Long.parseLong(str[1]), b = Long.parseLong(str[2]);
			if (op==0) {
				int left = (int)Math.min(a, b), right = (int) Math.max(a, b);
				System.out.println(sum(1,N,1,left, right));
			}
			else {
				modify(1,N,1,(int)a, b-number[(int)a]);
				number[(int)a]=b;
			}
		}
		
		
		

	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		if (end<left||start>right) return 0;
		if (left<=start&&end<=right) return segmentTree[node]; /* 범위에 속해있으면 */
		int mid = (start+end)/2;
		return sum(start, mid, 2*node, left, right)+sum(mid+1, end, 2*node+1,left, right);
	}
	
	public static void modify(int start, int end, int node, int index, long value) {
		if (!(start<=index&&index<=end)) return;
		segmentTree[node]+=value;
		if (start==end) return;
		
		int mid = (start+end)/2;
		modify(start, mid, 2*node, index, value);
		modify(mid+1, end, 2*node+1, index, value);
	}

}
