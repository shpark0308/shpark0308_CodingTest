import java.util.*;

class ´õ¸Ê°Ô_01_Solution {
    public int solution(int[] scoville, int K) {
    	Queue<Integer> queue = new PriorityQueue<Integer>();
    	for (int i=0; i<scoville.length; i++) queue.add(scoville[i]);
    	System.out.println(queue);
    	int count = 0;
    	while(queue.peek()<K) {
    		if (queue.size()==1) break;
    		int num1 = queue.poll();
    		int num2 = queue.poll();
    		System.out.println("¶ó¶ó "+(num1+num2*2));
    		queue.add(num1+num2*2);
    		System.out.println(queue);
    		count++;
    	}
    	if (queue.peek()<K) count = -1;
    	System.out.println(count);
        int answer = 0;
        return answer;
    }
}
public class ´õ¸Ê°Ô_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		´õ¸Ê°Ô_01_Solution s = new ´õ¸Ê°Ô_01_Solution();
		//s.solution(new int[] {1,2,3,9,10,12 }, 7);
		s.solution(new int[] {1,2,3}, 13);
		//s.solution(new int[] {4,5,6}, 3);

	}

}
