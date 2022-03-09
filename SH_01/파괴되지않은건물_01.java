class 파괴되지않은건물_01_Solution {
    public int solution(int[][] board, int[][] skill) {
    	int[][] temp = new int[board.length+1][board[0].length+1];
    	
    	for (int i=0; i<skill.length; i++) {
    		int type = skill[i][0], r1 = skill[i][1], c1 = skill[i][2], r2 = skill[i][3], c2 = skill[i][4], degree = type==1?-skill[i][5]:skill[i][5];
    		
    		temp[r1][c1]+=degree;
    		temp[r1][c2+1]-=degree;
    		temp[r2+1][c1]-=degree;
    		temp[r2+1][c2+1]+=degree; // 이렇게 싹 하고
    		
    	}
    	
    	for (int a=1; a<board.length; a++) { /* O(n^2) 로 고침 */
    		for (int b=0; b<board[0].length; b++) {
    			temp[a][b]+=temp[a-1][b];
    		}
    	}
    	
    	for (int a=0; a<board.length; a++) {
    		for (int b=1; b<board[0].length; b++) {
    			temp[a][b]+=temp[a][b-1];
    		}
    	}
    	int answer = 0;
    	for (int a=0; a<board.length; a++) {
    		for (int b=0; b<board[0].length; b++) {
    			if (board[a][b]+temp[a][b]>0) answer++;
    		}
    	}
    	System.out.println(answer);
        
        return answer;
    }
}
public class 파괴되지않은건물_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		파괴되지않은건물_01_Solution s = new 파괴되지않은건물_01_Solution();
		s.solution(new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
		//s.solution(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, new int[][] {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});

	}

}
