package ����;

import java.util.*;

public class Moo���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Moo(N));
	}
	public static String Moo(int N) {
		if (N==1) return "m";
		else if (N<=3) return "o";
		else {
			int size = 3;
			int index = 1;
			/* ������ �� �� �ִ� ������ ����� */
			while(size<N) {
				size = size*2+3+index;
				index++;
			}
			
			int front = (size-index-2)/2;
			
			if (N>(size-front)) {
				return Moo(N-size+front);
			}
			else if (N==(front+1)) return "m";
			else return "o";
		} 
	}

}
