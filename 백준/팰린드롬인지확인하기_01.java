package ����;

import java.util.*;

public class �Ӹ��������Ȯ���ϱ�_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.next());
		String reversestr = new StringBuilder(str).reverse().toString();
		if (str.toString().equals(new StringBuilder(str).reverse().toString())) System.out.println(1);
		else System.out.println(0);
	}

}
