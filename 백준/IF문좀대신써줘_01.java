package 백준;

import java.util.*;
import java.io.*;

public class IF문좀대신써줘_01 {
	public static int N, M;
	public static int[] number;
	public static String[] name;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		
		number = new int[N]; name = new String[N];
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			name[i] = str[0];
			number[i] = Integer.parseInt(str[1]);
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i=0; i<M; i++) array.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(array);
		
		int start = 0;
		for (int i=0; i<M; i++) {
			int k=0;
			for (k=start; k<N&& number[k]<array.get(i); k++) {}
			if (k==-1) k=0;
			else if (k==N) k=N-1;
			System.out.println(name[k]);
			start = k;
		}
		

	}

}
