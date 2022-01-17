package 알고리즘기초;

import java.util.Scanner;

public class 한수_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 일단 한번 해보기 */
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
			for (i=2; i<str.length;i++) { // 본격적인 비교
				if (Integer.parseInt(str[i])-Integer.parseInt(str[i-1])!=index) break;
			}
			if (i==str.length) count++;
		}
		return count;
		
	}
}
