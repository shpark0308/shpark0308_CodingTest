package 동적계획법02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class 공장_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> hashmap1 = new TreeMap<Integer, Integer>();
		HashMap<Integer, Integer> hashmap2 = new HashMap<Integer, Integer>();
		
		String[] str = br.readLine().split(" ");
		for (int i=1; i<=N; i++) hashmap1.put(i,Integer.parseInt(str[i-1]));
		
		str = br.readLine().split(" ");
		for (int i=1; i<=N; i++) hashmap2.put(Integer.parseInt(str[i-1]), i);
		
		int answer = 0;
		int visited[] = new int[N+1];
		/* 짝 맞추기 */
		for(Entry<Integer, Integer> entry : hashmap1.entrySet()) {
			answer+=Arrays.stream(visited, hashmap2.get(entry.getValue()),visited.length).sum();
			visited[hashmap2.get(entry.getValue())] = 1;
		}
		System.out.println(answer);
		

	}

}
