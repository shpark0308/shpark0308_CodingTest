package ����;

import java.util.*;

public class ����������Ż���ƿ��������̽�ũ������Դµ�_01 {
	public static int N, M, count=0;
	public static Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* �������� �����ϸ� �� */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		
		for (int i=0; i<M; i++) {
			set.add(new ArrayList<Integer>(Arrays.asList(sc.nextInt(),sc.nextInt())));
		}
		combination(3, 0, new ArrayList<Integer>());
		System.out.println(count);

	}
	public static void combination(int r, int index, ArrayList<Integer> arr) {
		if (r==0) {
			boolean flag = true;
			for(ArrayList<Integer> entry : set) {
				if (arr.containsAll(entry)) {
					flag = false;
					break;
					
				}
			}
			if (flag) {
				count++;
			}
			return;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.addAll(arr);
		for (int i=index; i<N; i++) {
			ar.add(i+1);
			combination(r-1, i+1, new ArrayList<Integer>(ar)); // index+1�� �ƴ϶� i+1
			ar.remove(ar.size()-1);
		}
	}

}
