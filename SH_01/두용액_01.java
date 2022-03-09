
import java.io.*;
import java.util.*;

public class µÎ¿ë¾×_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];
		
		String[] str = br.readLine().split(" ");
		for (int i=0; i<N; i++) liquid[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(liquid);
		long min = 2000000000;
		int num1 = liquid[0], num2 = liquid[N-1];
		
		int start = 0, end = N-1;
		
		while(start<end) {
			long sum = liquid[start]+liquid[end];
			
			if (Math.abs(sum)<min) {
				num1 = liquid[start];
				num2 = liquid[end];
				
				min = Math.abs(sum);
				
			}
			
			if (sum<0) start++;
			else end--;
		}
		System.out.println(num1+" "+num2);
	}

}
