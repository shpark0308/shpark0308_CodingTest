package 백준;

import java.util.*;
import java.math.*;

public class 조합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* BigInteger 써보기 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for (int i=n; i> (n-m); i--) n1 = n1.multiply(new BigInteger(i+""));
		for (int i=m; i>0; i--) n2 = n2.multiply(new BigInteger(i+""));
		
		n1 = n1.divide(n2);
		System.out.println(n1);
		
	}

}
