package 프로그래머스;

import java.util.Arrays;

class 구명보트_02_Solution {

	  public int solution(int[] people, int limit) {
	    int answer = 0;

	    Arrays.sort(people);

	    int min = 0;

	    for (int max = people.length - 1; min <= max; max--){
	    	System.out.println(min+"  "+max);
	    	if (people[min] + people[max] <= limit) min++;
	    	answer++;
	    }
	    System.out.println(answer);

	    return answer;
	}
}


public class 구명보트_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		구명보트_02_Solution s = new 구명보트_02_Solution();
		s.solution(new int[] {70,50,80,50},100); // 3
		//s.solution(new int[] {70,80,50},100); // 3
		//s.solution(new int[] {50, 40,60,50},100);//
	}

}
