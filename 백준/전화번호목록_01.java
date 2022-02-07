package 백준;

import java.io.*;
import java.util.*;

class 전화번호목록_01_Trie{
	HashMap<String, 전화번호목록_01_Trie> childnode = new HashMap<String, 전화번호목록_01_Trie>();
	boolean isEnd;
	
	public HashMap<String, 전화번호목록_01_Trie> getchildnode() { return this.childnode; }
	
	public void setEnd(boolean isEnd) { this.isEnd = isEnd; }
	
	public boolean getEnd() { return isEnd; }
	
}

public class 전화번호목록_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> array = new ArrayList<String>();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			전화번호목록_01_Trie rootnode = new 전화번호목록_01_Trie();
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			for (int p=0; p<N; p++) { // number 데로
				String phonenumber = br.readLine();
				전화번호목록_01_Trie temp = rootnode;
				for (int k=0; k<phonenumber.length(); k++) {
					temp = temp.getchildnode().computeIfAbsent(phonenumber.charAt(k)+"", c -> new 전화번호목록_01_Trie());
					if (temp.getEnd()) {
						flag = false;
						continue;
					}
				}
				if (temp.childnode.size()!=0) flag = false;
				temp.setEnd(true);
			}
			if (flag) System.out.println("YES");
			else System.out.println("NO");
		}
		array.clear();

	}
	

}
