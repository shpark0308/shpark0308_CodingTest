package ����;

import java.util.*;

public class ����_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), W = sc.nextInt();
		int[] location = new int[W];
		for (int i=0; i<W; i++) location[i] = sc.nextInt();
		
		int start, end = 0, sum=0;
		
		for (int i=1; i<W-1; i++) { // �ϳ��ϳ� �غ��� �� -> �������� ������ ���� �ϳ��ϳ� ���غ��� ����
			start = end = 0;
			
			// ���ʿ��� ���� ���� �ǹ��� ����
			for (int j=0; j<i; j++) {
				start = Math.max(location[j], start);
			}
			// �����ʿ��� ���� ���� �ǹ��� ����
			for (int j = i+1; j<W; j++) {
				end = Math.max(location[j], end);
			}
			
			int loc = Math.min(start, end);
			if (location[i]<loc) sum+=(loc-location[i]);
		}
		System.out.println(sum);

	}

}
