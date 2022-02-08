package 백준;

import java.io.*;
import java.util.*;

public class 베스트셀러_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int maxnum = Integer.MIN_VALUE; String maxlen = "";
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		for (int i=0; i<N; i++) {
			String title = br.readLine();
			if (!hashmap.containsKey(title)) hashmap.put(title, 0);
			hashmap.put(title, hashmap.get(title)+1);
			if (hashmap.get(title)>maxnum||(hashmap.get(title)==maxnum&&title.compareTo(maxlen)<0)) {
				maxnum = hashmap.get(title);
				maxlen = title;
			}
		}
		System.out.println(hashmap);
		System.out.println(maxlen);
		
		

	}

}
