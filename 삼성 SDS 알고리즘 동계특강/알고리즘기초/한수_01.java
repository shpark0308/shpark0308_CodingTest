package �˰������;

import java.util.Scanner;

public class �Ѽ�_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* �ϴ� �ѹ� �غ��� */
		Scanner sc = new Scanner(System.in);
		System.out.println(findNum(sc.nextInt()));
		
		

	}
	public static int findNum(int num) {
		if ((num+"").length()<3) return num;
		int count = 99;
		for(int start_num=100; start_num<=num; start_num++) {
			String[] str = (start_num+"").split("");
			int index = Integer.parseInt(str[1]) - Integer.parseInt(str[0]);
			int i;
			for (i=2; i<str.length;i++) { // �������� ��
				if (Integer.parseInt(str[i])-Integer.parseInt(str[i-1])!=index) break;
			}
			if (i==str.length) count++;
		}
		return count;
		
	}
}
