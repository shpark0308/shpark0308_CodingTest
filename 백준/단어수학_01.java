package ����;

import java.util.*;
import java.io.*;

public class �ܾ����_01 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		String[][] number = new String[N][8];
		int maxlen = 0;
		for(int a=0; a<N; a++) {
			String[] str = br.readLine().split("");
			maxlen = Math.max(maxlen, str.length);
			int k = 8-str.length;
			for (int b=0; b<str.length; b++) {
				number[a][k+b] = str[b];
			}
		}
		int NUM = 9;
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		// for�� �ϳ��ϳ� �������� �ϱ�
		for (int a=(8-maxlen); a<8; a++) {
			for (int b=0; b<N; b++) {
				if (number[b][a]==null) continue;
				if (!hashmap.containsKey(number[b][a])) {
					hashmap.put(number[b][a], NUM);
					NUM--;
				}
			}
		}
		int sum=0;
		for (int a=0; a<N; a++) {
			StringBuffer str = new StringBuffer();
			for (int b=7; b>=0&&number[a][b]!=null; b--) {
				str.append(hashmap.get(number[a][b]));
			}
			sum+=Integer.parseInt(str.reverse().toString());
		}
		System.out.println(sum);
		

	}

}
