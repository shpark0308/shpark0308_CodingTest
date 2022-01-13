package 프로그래머스;

import java.util.*;
import java.util.stream.*;

/* 1. 일단 무식한 방법으로 해보기 = 50 50 70 80 정렬시키고 그 마이너스 값중에서 제일 큰 것 선택  */

class 구명보트_01_Solution {
    public int solution(int[] people, int limit) {
    	Queue<Integer> people_arr = new PriorityQueue<Integer>(Collections.reverseOrder());
    	people_arr.addAll(Arrays.stream(people).boxed().collect(Collectors.toList()));
    	System.out.println(people_arr);
    	int count=0;
    	while(!people_arr.isEmpty()) {
    		int num1 = people_arr.poll();
    		Iterator<Integer> iter = people_arr.iterator();
    		while(iter.hasNext()) {
    			int num2 = iter.next();
    			if (num2+num1<=limit) {
    				people_arr.remove(num2);
    				break;
    			}
    		}
    		count++;
    	}
    	System.out.println(count);
        int answer = 0;
        return answer;
    }
}
public class 구명보트_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		구명보트_01_Solution s = new 구명보트_01_Solution();
		//s.solution(new int[] {70,50,80,50},100); // 3
		//s.solution(new int[] {70,80,50},100); // 3
		s.solution(new int[] {40,50,60,90 },100); // 2

	}

}
