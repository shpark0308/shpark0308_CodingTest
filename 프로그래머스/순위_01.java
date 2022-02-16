package ���α׷��ӽ�;

import java.util.Arrays;

class ����_01_Solution {
	/* [ �÷��̵� �ͼ� ]
	 * 1. ��� �������� ��� �������� ���� �ִܰŸ�
	 * 2. �ش� ������ ������ �ּҺ�� */
	
    public int solution(int n, int[][] results) {
    	int[][] DP = new int[n+1][n+1];
    	for (int a=1;a<=n;a++) Arrays.fill(DP[a], 10000);
    	
    	for (int a=0; a<results.length;a++) DP[results[a][0]][results[a][1]] = 1;
    	
    	for (int k=1; k<=n; k++) { // �������� ������ ����
    		for (int p=1; p<=n; p++) { // ����� ����
    			for (int q=1; q<=n; q++) { // ������ �� ����
    				DP[p][q] = Math.min(DP[p][q], DP[p][k]+DP[k][q]); //�ش� ������ ������ �Ͱ� ���� �ּҰ�
    			}
    		}
    	}
    	int answer = 0;
    	for (int p=1; p<=n; p++) {
    		int count = 0;
    		for (int q=1; q<=n; q++) {
    			if (DP[p][q]<10000||DP[q][p]<10000) count++;
    		}
    		if (count==(n-1)) answer++; // �ڱ� �ڽ��� ������ ��� �ֵ�� ���Ͽ��� ���
    	}
        return answer;
    }
}
public class ����_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		����_01_Solution s = new ����_01_Solution();
		s.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

	}

}
