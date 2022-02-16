package 프로그래머스;

import java.util.*;
import java.awt.*;

class 표편집_03_Solution {
    public String solution(int n, int k, String[] cmd) {
    	Stack<Integer> remove = new Stack<Integer>();
    	int table_size = n;
    	
    	
    	/* Linked List를 사용 안함 */
    	for(int i=0, num=0; i<cmd.length;i++) {
    		String[] str = cmd[i].split(" ");
    		if (str.length>=2) num = Integer.parseInt(str[1]);
    		if (str[0].equals("U")) k = k-num<0?0:k-num;
    		else if (str[0].equals("D")) k = k+num>=n?(n-1):k+num;
    		else if (str[0].equals("C")) {
    			remove.add(k);
    			table_size--; // 전체 사이즈
    			if (k==table_size) k = (k-1);
    		}
    		else if (str[0].equals("Z")) {
    			if (remove.pop()<=k) k++;
    			table_size++;
    		}
    	}
    	StringBuilder answer = new StringBuilder("O".repeat(table_size));
    	while(!remove.isEmpty()) {
    		answer.insert(remove.pop(), "X");
    	}
    	System.out.println("ANSWER = "+answer);
    	return answer.toString();
    }
}

public class 표편집_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		표편집_03_Solution s = new 표편집_03_Solution();
		//s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
		s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
	}

}
