package 연습문제;

import java.util.Arrays;

class Solution {
	/* 이분 탐색 */
    public long solution(int n, int[] times) {
    	long maxtime = (long)Arrays.stream(times).max().getAsInt()*n;
    	long answer = 0;
    	long start = 0, end = maxtime, mid; /* 0과 end 사이 */
    	while(start<=end) {
    		mid = (start+end)/2;
    		int sum = 0;
    		for (int t=0; t<times.length;t++) {
    			sum+=mid/times[t]; // time이 7인 심사관이 최대로 볼 수 있는 사람의 수
    		}
    		if (sum<n) { // 1. 아직 심사 처리를 모두 하지 못하였을 경우 ex). 5 < 6
    			start = mid+1;
    		}
    		else {
    			end = mid-1;
    			answer = mid;
    		}
    	}
    	
        return answer;
    }
}

public class 입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(3, new int[] {1,9,9});

	}

}
