package 백준;

import java.util.*;
import java.io.*;

public class 팰린드롬_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] word = new String[N];
			for (int p=0; p<N; p++) word[p] = br.readLine();
			
			boolean ischeck = true;
			for (int a=0; a<N&&ischeck; a++) {
				for (int b=0; b<N&&ischeck; b++) {
					String wordsen = word[a]+word[b];
					String[] wordarr = wordsen.split("");
					int len = wordarr.length/2,q;
					for (q=0; q<len;q++) {
						if (!wordarr[q].equals(wordarr[wordarr.length-1-q])) {
							break;
						}
					}
					if (q==len) {
						System.out.println(wordsen);
						ischeck=false;
					}
				}
			}
			if (ischeck) System.out.println(0);
		}
		

	}

}
