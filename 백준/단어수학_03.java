package 백준;

import java.util.*;
import java.io.*;

public class 단어수학_03 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/*  그 만큼 숫자를 더하기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] answer = new String[N];
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		for (int i=0; i<N; i++) answer[i] = br.readLine();
		
		for (int a=0; a<N; a++) {
			int temp = (int)Math.pow(10, answer[a].length()-1);
			for (int b=0; b<answer[a].length(); b++) {
				String str = answer[a].charAt(b)+"";
				if (!hashmap.containsKey(str)) hashmap.put(str,0);
				hashmap.put(str, hashmap.get(str)+temp);
				temp/=10;
			}
		}
		List<Map.Entry<String, Integer>> entryList = new LinkedList<Map.Entry<String,Integer>>(hashmap.entrySet());
		entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
		int Num = 9, sum=0;
		for (Map.Entry<String, Integer> entry : entryList) {
			sum+=(entry.getValue()*Num);
			Num--;
		}
		System.out.println(sum);

	}

}
