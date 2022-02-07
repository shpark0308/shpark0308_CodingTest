package ����;

import java.io.*;
import java.util.*;

class ��ȭ��ȣ���_01_Trie{
	HashMap<String, ��ȭ��ȣ���_01_Trie> childnode = new HashMap<String, ��ȭ��ȣ���_01_Trie>();
	boolean isEnd;
	
	public HashMap<String, ��ȭ��ȣ���_01_Trie> getchildnode() { return this.childnode; }
	
	public void setEnd(boolean isEnd) { this.isEnd = isEnd; }
	
	public boolean getEnd() { return isEnd; }
	
}

public class ��ȭ��ȣ���_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> array = new ArrayList<String>();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			��ȭ��ȣ���_01_Trie rootnode = new ��ȭ��ȣ���_01_Trie();
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			for (int p=0; p<N; p++) { // number ����
				String phonenumber = br.readLine();
				��ȭ��ȣ���_01_Trie temp = rootnode;
				for (int k=0; k<phonenumber.length(); k++) {
					temp = temp.getchildnode().computeIfAbsent(phonenumber.charAt(k)+"", c -> new ��ȭ��ȣ���_01_Trie());
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
