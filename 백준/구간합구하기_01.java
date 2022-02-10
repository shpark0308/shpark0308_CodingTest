package 백준;

import java.util.*;
import java.io.*;


public class 구간합구하기_01 {
	public static int N, M, K;
	public static long[] number, segmentTree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); K = Integer.parseInt(str[2]);
		
		number = new long[N+1];
		for (int i=1; i<=N; i++) number[i] = Long.parseLong(br.readLine());
		
		segmentTree = new long[4*N];
		init(1, N, 1);
		
		for (int i=0; i<(M+K); i++) {
			str = br.readLine().split(" ");
			int op = Integer.parseInt(str[0]);
			long a = Long.parseLong(str[1]),b = Long.parseLong(str[2]);
			if (op==1) {
				update(1,N, 1, (int)a, b-number[(int)a] );
				number[(int)a] = b;
			}
			else if (op==2) System.out.println(sum(1,N, 1, (int)a,(int)b));
		}
	}
	/* 세그먼트 트리 구성 */
	public static long init(int start, int end, int node) {
		if (start==end) return segmentTree[node] = number[start];
		int mid = (start+end)/2;
		return segmentTree[node] = init(start, mid, 2*node) + init(mid+1, end, 2*node+1);
	}
	
	// start : 시작 인덱스, end : 끝 인덱스, index : 구간 합을 수정하고자 하는 노드, value : 수정할 값
	public static void update(int start, int end, int node, int index, long value) {
		if (index<start||index>end) return;
		segmentTree[node]+=value; // 그만큼 수정해야한다는 뜻
		if (start == end) return;
		
		int mid = (start+end)/2;
		update(start, mid, 2*node, index, value);
		update(mid+1, end, 2*node+1, index, value);
	}
	public static long sum(int start, int end, int node, int left, int right) {
		if (end<left||start>right) return 0; // 완전 범위에서 벗어났으면
		if (left<=start&&end<=right) return segmentTree[node];
		
		int mid = (start+end)/2;
		return sum(start, mid, 2*node, left, right) + sum(mid+1, end, 2*node+1, left, right);
		
	}
	
	

}
