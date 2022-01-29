package �˰������;

import java.util.Arrays;
import java.util.Scanner;

public class N_Queens_01 {
	public static int N, count=0;
	public static int[] Arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Arr = new int[N];
		dfs(0);
		System.out.println(count);

	}
	public static void dfs(int index) {
		if (index==N) { // ���� �� �����ϸ�
			count++;
			return;
		}
		for (int i=0; i<N; i++) {
			Arr[index]=i; // �����
			if (Possible(index)) {
				dfs(index+1);
			}
			
		}
		
	}
	public static boolean Possible(int index) {
		for (int i=0; i<index; i++) { // �� ���͵� �߿���
			if (Arr[i]==Arr[index]) return false;
			else if (Math.abs(i-index)==Math.abs(Arr[i]-Arr[index])) return false;
		}
		return true;
	}
	

}
