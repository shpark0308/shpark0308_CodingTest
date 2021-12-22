package ��������;

import java.util.Arrays;

class Solution {
	/* �̺� Ž�� */
    public long solution(int n, int[] times) {
    	long maxtime = (long)Arrays.stream(times).max().getAsInt()*n;
    	long answer = 0;
    	long start = 0, end = maxtime, mid; /* 0�� end ���� */
    	while(start<=end) {
    		mid = (start+end)/2;
    		int sum = 0;
    		for (int t=0; t<times.length;t++) {
    			sum+=mid/times[t]; // time�� 7�� �ɻ���� �ִ�� �� �� �ִ� ����� ��
    		}
    		if (sum<n) { // 1. ���� �ɻ� ó���� ��� ���� ���Ͽ��� ��� ex). 5 < 6
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

public class �Ա��ɻ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(3, new int[] {1,9,9});

	}

}
