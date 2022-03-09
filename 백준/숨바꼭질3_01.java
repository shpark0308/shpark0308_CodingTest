package 백준;

import java.util.*;

public class 숨바꼭질3_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] location = new int[100001];
		Arrays.fill(location, Integer.MAX_VALUE);
		int N = sc.nextInt(), K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N); location[N] = 0;
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue);
			int Num = queue.poll();
			if (Num==K) break;
			if (Num<0||Num>=100001) continue;
			if (Num-1>=0) {
				if (location[Num]+1<location[Num-1]) {
					location[Num-1] = location[Num]+1;
					queue.add(Num-1);
				}
			}
			if (Num+1<100001) {
				if (location[Num]+1<location[Num+1]) {
					location[Num+1] = location[Num]+1;
					queue.add(Num+1);
				}
			}
			if (Num*2<100001) {
				if (location[Num]<location[Num*2]) {
					location[Num*2] = location[Num];
					queue.add(Num*2);
				}
			}
		}
		System.out.println(location[K]);

	}

}
