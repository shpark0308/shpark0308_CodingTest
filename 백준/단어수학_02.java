package 백준;

import java.io.*;
import java.util.*;

public class 단어수학_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<String>> graph = new ArrayList<ArrayList<String>>();
		ArrayList<String[]> answer = new ArrayList<String[]>();
		for (int i=0; i<8; i++) graph.add(new ArrayList<String>());
		
		HashMap<String, Integer> hashmap1 = new HashMap<String, Integer>(); // 그 갯수만큼 저장
		
		int maxlen = 0;
		for (int a=0; a<N; a++) {
			String[] str = br.readLine().split("");
			answer.add(str);
			maxlen = Math.max(maxlen, str.length);
			for (int b=0; b<str.length; b++) {
				if (!hashmap1.containsKey(str[b])) hashmap1.put(str[b], 0);
				hashmap1.put(str[b], hashmap1.get(str[b])+1);
				graph.get(str.length-1-b).add(str[b]);
			}
		}
		
		for (int i=0; i<maxlen; i++) Collections.sort(graph.get(i), new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return hashmap1.get(o1)>hashmap1.get(o2)?-1:1;
			}
		});


		hashmap1.clear();
		int NUM = 9;
		for (int a=(maxlen-1);a>=0; a-- ) {
			for (int b=0; b<graph.get(a).size();b++) {
				if (!hashmap1.containsKey(graph.get(a).get(b))) {
					hashmap1.put(graph.get(a).get(b), NUM);
					NUM--;
				}
			}
		}
		int sum=0;
		for (int a=0; a<answer.size(); a++) {
			String str = "";
			for (int b=0; b<answer.get(a).length; b++) {
				str+=hashmap1.get(answer.get(a)[b]);
			}
			sum+=Integer.parseInt(str);
			
		}
		System.out.println(sum);
	}

}
