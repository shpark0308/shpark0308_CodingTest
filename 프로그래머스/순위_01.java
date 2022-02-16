package 프로그래머스;

import java.util.Arrays;

class 순위_01_Solution {
	/* [ 플로이드 와샬 ]
	 * 1. 모든 정점에서 모든 정점으로 가는 최단거리
	 * 2. 해당 정점을 지나는 최소비용 */
	
    public int solution(int n, int[][] results) {
    	int[][] DP = new int[n+1][n+1];
    	for (int a=1;a<=n;a++) Arrays.fill(DP[a], 10000);
    	
    	for (int a=0; a<results.length;a++) DP[results[a][0]][results[a][1]] = 1;
    	
    	for (int k=1; k<=n; k++) { // 지나가는 정점을 선택
    		for (int p=1; p<=n; p++) { // 출발점 선택
    			for (int q=1; q<=n; q++) { // 목적지 점 선택
    				DP[p][q] = Math.min(DP[p][q], DP[p][k]+DP[k][q]); //해당 정점을 지나는 것과 비교한 최소값
    			}
    		}
    	}
    	int answer = 0;
    	for (int p=1; p<=n; p++) {
    		int count = 0;
    		for (int q=1; q<=n; q++) {
    			if (DP[p][q]<10000||DP[q][p]<10000) count++;
    		}
    		if (count==(n-1)) answer++; // 자기 자신을 제외한 모든 애들과 비교하였을 경우
    	}
        return answer;
    }
}
public class 순위_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		순위_01_Solution s = new 순위_01_Solution();
		s.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

	}

}
