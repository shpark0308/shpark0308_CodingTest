package 프로그래머스;

import java.util.*;
import java.awt.*;

class 표편집_01_Solution {
    public String solution(int n, int k, String[] cmd) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	for (int i=0; i<n; i++) array.add(i);
    	
    	Stack<Point> stack = new Stack<Point>(); //  index, number
    	
    	for (int i=0, num=0; i<cmd.length;i++) {
    		String[] str = cmd[i].split(" ");
    		String order = str[0];
			if (str.length>=2) num = Integer.parseInt(str[1]);
			if (order.equals("U")) k = (k-num<0)?0:k-num;
			else if (order.equals("D")) k = (k+num>array.size()-1)?array.size()-1:k+num;
			else if (order.equals("C")) {
				stack.add(new Point(k,array.get(k)));
				array.remove(k);
				if (k>=array.size()) k = array.size()-1;
			}
			else if (order.equals("Z")) {
				Point index = stack.pop();
				array.add(index.x, index.y);
				if (index.x<=k) k++;
			}
    		System.out.println(array +"   "+k);
    		System.out.println(stack);
    		System.out.println("----------------------");
    	}
        StringBuilder answer = new StringBuilder();
        int count=0;
        for (int i=0, index=0; i<n;i++ ) {
        	if (index>=array.size()||i!=array.get(index)) {
        		answer.append("O".repeat(count));
        		answer.append("X");
        		count=0;
        	}
        	else {
        		count++;
        		index++;
        	}
        }
        if (count>0) answer.append("O".repeat(count));
        System.out.println("Answer = "+answer);
        return answer.toString();
    }
}

public class 표편집_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		표편집_01_Solution s = new 표편집_01_Solution();
		s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
		//s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1", "C"});
		//s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
	}

}
