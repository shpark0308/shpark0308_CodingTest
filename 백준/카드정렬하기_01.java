package 백준;

import java.util.*;

public class 카드정렬하기_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i=0; i<N; i++) queue.add(sc.nextInt());
		
		int sum = 0;
		while(queue.size()>1) {
			System.out.println(queue);
			int num1 = queue.poll();
			int num2 = queue.poll();
			sum+=(num1+num2);
			queue.add(num1+num2);
		}
		System.out.println(sum);

	}

}
