
import java.util.*;

public class 소수의연속합_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		/* 소수구하기 1 */
		/*for (int i=2, j; i<=N; i++) {
			for (j=2; j<i; j++) {
				if (i%j==0) break;
			}
			if (j==i) prime.add(i);
		}*/
		
		/* 소수 구하기 2 */
		boolean[] check = new boolean[N+1];
		for (int i=2; i*i<=N; i++) {
			if (!check[i]) for (int j=i*i; j<=N; j+=i) check[j] = true;
		}
		
		for (int i=2; i<=N; i++) if (!check[i]) prime.add(i);
		
		
		int start = 0, end = 0, sum = 0, count = 0;
		
		while(true) {
			if (sum>=N) sum-=prime.get(start++);
			else if (end==prime.size()) break;
			else if (sum<N) sum+=prime.get(end++);
			if (sum==N) count++;
			
		}
		System.out.println(count);
		
	}

}
