package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 문자열게임2_03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, ArrayList<Integer>> hashmap = new HashMap<String, ArrayList<Integer>>();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String[] str = br.readLine().split("");
			int K = Integer.parseInt(br.readLine());
			for (int c=0; c<str.length;c++) {
				if (!hashmap.containsKey(str[c])) hashmap.put(str[c], new ArrayList<Integer>());
				hashmap.get(str[c]).add(c);
			}
			int min= Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (Map.Entry<String, ArrayList<Integer>> entry : hashmap.entrySet()) {
				if (entry.getValue().size()<K) continue;
				for (int t=0; t<=entry.getValue().size()-K; t++) {
					int calc = entry.getValue().get(t+(K-1))-entry.getValue().get(t)+1;
					min = Math.min(min, calc);
					max = Math.max(max, calc);
				}
			}
			if (min==Integer.MAX_VALUE&&max==Integer.MIN_VALUE) System.out.println("-1");
			else System.out.println(min+" "+max);
			
			hashmap.clear();
		}

	}

}
