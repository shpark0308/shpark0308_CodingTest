package �ð����⵵;

import java.util.Scanner;

public class ����_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/* ������ �������� Ǯ�� */
		double X = sc.nextDouble(), Y = sc.nextDouble();
		/* �ڹ� : �ø� = Math.ceil() / ���� = Math.floor() */
		double score = (Y/X) * 100;
		double match = ((int) Math.floor(score))+1;
		if (match==100) System.out.println(1);
		else {
			double answer = (match*X - 100*Y)/(100-match);
			if (answer<0) System.out.println("-1");
			else {
				if (answer-(int)answer==0) System.out.println((int)answer);
				else System.out.println(((int) answer)+1);
			}
		}
		
		
		
	}

}
