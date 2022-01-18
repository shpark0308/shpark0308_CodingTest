package �ð����⵵;

import java.util.Arrays;
import java.util.Scanner;

public class �����ڸ���_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] number = new int[N];
		for (int i=0; i<N; i++) number[i] = sc.nextInt();
		/* �̺�Ž�� ������ �����ϱ� */ // �ϴ��غ���
		long left = 0, right = Arrays.stream(number).max().getAsInt(); // �� �κ��� ������ long���� ���־�� �Ѵ�.
		while(left<=right) {
			long mid = (left + right) / 2;
			long sum=0;
			for (int t=0; t<N; t++) {
				if (number[t]<=mid) continue;
				sum+=(number[t]-mid);
			}
			if (sum<M) right = mid-1; // ���� ���̸� �÷��� �Ѵ�.
			else left = mid+1;
		}
		System.out.println(left+"  "+right);
		System.out.println(left-1);
	}

}
