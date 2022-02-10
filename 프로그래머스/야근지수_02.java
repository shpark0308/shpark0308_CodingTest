package 프로그래머스;

import java.util.*;

class 야근지수_02_Solution {
    public long solution(int n, int[] works) {
    	Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    	for (int i=0; i<works.length;i++) queue.add(works[i]);
    	while(n>0) {
    		int num = queue.poll()-1;
    		if (num<0) break;
    		queue.add(num);
    		n-=1;
    	}
    	long answer = 0;
    	int size = queue.size();
    	for (int i=0; i<size;i++) answer +=Math.pow(queue.poll(), 2);
        return answer;
    }
}
public class 야근지수_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		야근지수_02_Solution s = new 야근지수_02_Solution();
		s.solution(4, new int[] {4,3,3});
		s.solution(1, new int[] {2,1,2});
		s.solution(3, new int[] {1,1});
		s.solution(99, new int[] {2,15,22,55,55});
		s.solution(15, new int[] {11,5,3,2,1});
		s.solution(2, new int[] {1,1,99});

	}

}
