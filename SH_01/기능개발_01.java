import java.util.*;

class 기능개발_01_Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	Stack<Integer> remain = new Stack<Integer>();
    	remain.push(Integer.MAX_VALUE);
    	for (int i=progresses.length-1; i>=0; i--) {
    		int rem = 100-progresses[i];
    		int tem = rem%speeds[i]==0?rem/speeds[i]:rem/speeds[i]+1;
    		remain.push(tem);
    	}
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	int num = -1, sum = 0;
    	while(!remain.isEmpty()) {
    		int temp = remain.pop();
    		if (temp>num) {
    			arr.add(sum);
    			sum=1;
    			num = temp;
    		}
    		else {
    			sum++;
    		}
    		
    	}
    	int[] answer = new int[arr.size()-1];
    	for (int i=1; i<arr.size(); i++) answer[i-1] = arr.get(i);
    	System.out.println(Arrays.toString(answer));
        return answer;
    }
}
public class 기능개발_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		기능개발_01_Solution s = new 기능개발_01_Solution();
		//s.solution(new int[] {93, 30, 55 }, new int[] {1, 30, 5 });
		s.solution(new int[] {95, 90, 99, 99, 80, 99} , new int[] {1,1,1,1,1,1});

	}

}
