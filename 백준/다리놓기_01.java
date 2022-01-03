package 백준;

import java.util.*;
import java.math.*;

public class 다리놓기_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			BigInteger n1 = BigInteger.ONE;
			BigInteger n2 = BigInteger.ONE;
			for (int a=m; a>(m-n);a--) n1 = n1.multiply(new BigInteger(a+""));
			for (int a=n; a>0; a--) n2 = n2.multiply(new BigInteger(a+""));
			n1 = n1.divide(n2);
			System.out.println(n1);
		}
		

	}

}
