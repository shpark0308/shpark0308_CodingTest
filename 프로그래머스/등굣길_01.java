package ÇÁ·Î±×·¡¸Ó½º;

import java.util.Arrays;

class µî±·±æ_01_Solution {
    public int solution(int m, int n, int[][] puddles) {
    	int[][] DP = new int[n][m];
    	for (int i=0; i<puddles.length; i++) {
    		DP[puddles[i][1]-1][puddles[i][0]-1] = -1;
    	}
    	for (int i=0; i<n&&DP[i][0]!=-1; i++) DP[i][0] = 1;
    	for (int i=0; i<m&&DP[0][i]!=-1; i++) DP[0][i] = 1;
    	
    	for (int a=0; a<n; a++) {
    		for (int b=0;b<m; b++) {
    			if (DP[a][b]==-1) {
    				DP[a][b]=0;
    				continue;
    			}
    			if (!(a==0||b==0)) DP[a][b] = DP[a-1][b]+DP[a][b-1];
    		}
    		for (int i=0; i<n; i++) {
    			System.out.println(Arrays.toString(DP[i]));
    		}
    		System.out.println("--------------------------");
    	}
    	System.out.println(DP[n-1][m-1]);
    	
        int answer = 0;
        return answer;
    }
}

public class µî±·±æ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		µî±·±æ_01_Solution s = new µî±·±æ_01_Solution();
		s.solution(4, 3, new int[][] {{2,2}});
		//s.solution(4, 3, new int[][] {{2,1},{1,2}});

	}

}
