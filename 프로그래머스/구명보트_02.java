package ���α׷��ӽ�;

import java.util.Arrays;

class ����Ʈ_02_Solution {

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


public class ����Ʈ_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		����Ʈ_02_Solution s = new ����Ʈ_02_Solution();
		s.solution(new int[] {70,50,80,50},100); // 3
		//s.solution(new int[] {70,80,50},100); // 3
		//s.solution(new int[] {50, 40,60,50},100);//
	}

}
