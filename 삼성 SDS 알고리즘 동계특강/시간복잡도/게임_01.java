package 시간복잡도;

import java.util.Scanner;

public class 게임_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/* 수학적 지식으로 풀기 */
		double X = sc.nextDouble(), Y = sc.nextDouble();
		/* 자바 : 올림 = Math.ceil() / 버림 = Math.floor() */
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
