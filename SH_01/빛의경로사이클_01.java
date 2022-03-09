
import java.util.*;

class 빛의경로사이클_01_Solution {
	boolean[][][] direct;
	public static int[] go_X = { -1, 0, 1, 0 };
	public static int[] go_Y = { 0, 1, 0, -1 };
	public int R, C;
	
    public int[] solution(String[] grid) {
    	R = grid.length; C = grid[0].length();
    	direct = new boolean[R][C][4];
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	
    	for (int a=0; a<R; a++) {
    		for (int b=0; b<C; b++) {
    			for (int d=0; d<4; d++) {
    				if (!direct[a][b][d]) {
    					array.add(goLight(a, b, d, grid));
    				}
    			}
    		}
    	}
    	
        return array.stream().sorted().mapToInt(i-> i).toArray();
    }
    public int goLight(int a, int b, int d, String[] grid) {
    	int count = 0;
    	while(true) {
    		if (direct[a][b][d]==true) break; // 다시 돌아온거니까
    		count++;
    		direct[a][b][d] = true;
    		
    		if (grid[a].charAt(b)=='L') d = d==0?3:d-1;
    		else if (grid[a].charAt(b)=='R') d = d==3?0:d+1;
    		
    		a = (a+go_X[d]<0||a+go_X[d]>=R)?(a+go_X[d]<0?R-1:0):a+go_X[d];
    		b = (b+go_Y[d]<0||b+go_Y[d]>=C)?(b+go_Y[d]<0?C-1:0):b+go_Y[d];
    		
    	}
    	return count;
    }
}

public class 빛의경로사이클_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		빛의경로사이클_01_Solution s = new 빛의경로사이클_01_Solution();
		//s.solution(new String[] {"SL", "LR"}); // 16
		// s.solution(new String[] {"S"}); // 1111
		s.solution(new String[] {"R","R"}); //4, 4

	}

}
