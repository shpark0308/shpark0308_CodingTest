
import java.util.*;

class ���߿켱����ť_01_Solution {
    public int[] solution(String[] operations) {
    	/* ���� ������ ������� Ǯ�� */
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	for (int i=0; i<operations.length; i++) {
    		String[] str = operations[i].split(" ");
    		if (str[0].equals("I")) {
    			array.add(Integer.parseInt(str[1]));
    		}
    		else {
    			Collections.sort(array);
    			if (array.size()==0) continue;
    			if (str[1].equals("1")) array.remove(array.size()-1);
    			else array.remove(0);
    		}
    	}
    	Collections.sort(array);
    	int[] answer = new int[2];
        if (array.size()>0) {
        	answer[0] = array.get(array.size()-1);
        	answer[1] = array.get(0);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

public class ���߿켱����ť_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		���߿켱����ť_01_Solution s = new ���߿켱����ť_01_Solution();
		//s.solution(new String[] {"I 16","D 1"});
		//s.solution(new String[] {"I 7","I 5","I -5","D -1"});
		s.solution(new String[] { "I 1", "I 2", "I 3", "I 4", "D -1", "D 1", "D -1"});
		

	}

}
