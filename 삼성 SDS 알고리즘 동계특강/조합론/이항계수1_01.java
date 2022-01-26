package 조합론;

import java.math.BigInteger;
import java.util.Scanner;

public class 이항계수1_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		BigInteger N_sum = BigInteger.ONE;
		BigInteger K_sum = BigInteger.ONE;
		
		for (int i=N; i>(N-K); i--) {
			N_sum = N_sum.multiply(new BigInteger(i+""));
		}
		for (int i=K; i>0; i--) K_sum = K_sum.multiply(new BigInteger(i+""));
		N_sum = N_sum.divide(K_sum).mod(new BigInteger(10007+""));
		System.out.println(N_sum);

	}

}
