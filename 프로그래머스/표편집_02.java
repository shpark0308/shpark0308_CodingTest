package 프로그래머스;

import java.util.*;
import java.awt.*;

class 표편집_02_Solution {
    public String solution(int n, int k, String[] cmd) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	for (int i=0; i<n; i++) array.add(i);
    	
    	Stack<Point> stack = new Stack<Point>(); //  index, number
    	
    	
    	StringBuilder answer = new StringBuilder("O".repeat(n)); /* 함께 만들어가기 */
    	for (int i=0, num=0; i<cmd.length;i++) {
    		String[] str = cmd[i].split(" ");
    		String order = str[0];
			if (str.length>=2) num = Integer.parseInt(str[1]);
			if (order.equals("U")) k = (k-num<0)?0:k-num;
			else if (order.equals("D")) k = (k+num>array.size()-1)?array.size()-1:k+num;
			else if (order.equals("C")) {
				answer.setCharAt(array.get(k), 'X');
				stack.add(new Point(k,array.get(k)));
				System.out.println(stack.peek());
				array.remove(k);
				
				if (k>=array.size()) k = array.size()-1;
			}
			else if (order.equals("Z")) {
				Point index = stack.pop();
				array.add(index.x, index.y);
				answer.setCharAt(index.y, 'O');
				if (index.x<=k) k++;
			}
    		System.out.println(array +"   "+k);
    		System.out.println(stack);
    		System.out.println("ANSWER = "+answer);
    		System.out.println("----------------------");
    	}
    	
        System.out.println("Answer = "+answer);
        return answer.toString();
    }
}

public class 표편집_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		표편집_02_Solution s = new 표편집_02_Solution();
		//s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
		s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1", "C"});
		//s.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
	}

}
