package �˰������;

import java.io.*;
import java.util.Arrays;

public class ��ȣ�����_01 {
	// dfs �� Ǯ��
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
		
		// 2. �������� �Դ°�
		if (answer.length()==L) {
			if (o>=1&&w>=2) System.out.println(answer);
			return;
		}
		// 3. ����Ǿ��ִ°�
		for (int i=index; i<string.length;i++ ) {
			if (string[i].equals("a")||string[i].equals("e")||string[i].equals("i")||string[i].equals("o")||string[i].equals("u")) {
				dfs(i+1, answer+string[i], o+1, w);
			}
			else dfs(i+1, answer+string[i], o, w+1);
		}
		// 4. �� �� �ִ°�?
		// 5. ����
		// 6. check -out
	}

}
