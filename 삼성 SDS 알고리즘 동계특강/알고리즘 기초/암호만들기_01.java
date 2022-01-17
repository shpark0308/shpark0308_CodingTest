package 알고리즘기초;

import java.io.*;
import java.util.Arrays;

public class 암호만들기_01 {
	// dfs 로 풀기
	public static int L, C;
	public static String[] string;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		L = Integer.parseInt(str[0]); C = Integer.parseInt(str[1]);
		string = br.readLine().split(" ");
		Arrays.sort(string);
		dfs(0,"",0,0);
	}
	public static void dfs(int index, String answer, int o, int w) {
		// 1. check - in
		
		// 2. 목적지에 왔는가
		if (answer.length()==L) {
			if (o>=1&&w>=2) System.out.println(answer);
			return;
		}
		// 3. 연결되어있는가
		for (int i=index; i<string.length;i++ ) {
			if (string[i].equals("a")||string[i].equals("e")||string[i].equals("i")||string[i].equals("o")||string[i].equals("u")) {
				dfs(i+1, answer+string[i], o+1, w);
			}
			else dfs(i+1, answer+string[i], o, w+1);
		}
		// 4. 갈 수 있는가?
		// 5. 간다
		// 6. check -out
	}

}
