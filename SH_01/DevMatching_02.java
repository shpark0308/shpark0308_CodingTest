import java.util.*;
import java.awt.*;

class DevMatching_02_Solution {
	public static int[] go_X = { -1, 0, 1, 1 };
	public static int[] go_Y = { 1, 1, 0, 1 };
	
	public static int[] ch_X = { 1, 0, -1, -1};
	public static int[] ch_Y = { -1, -1, 0, -1};
	
	public static int[][] DEV;
	public static int count = 0;
	public static Queue<Point> queue = new LinkedList<Point>();
	
    public int solution(int h, int w, int n, String[] board) {
    	DEV = new int[h][w];
    	
    	for (int a=0; a<board.length; a++) {
    		String[] str = board[a].split("");
    		for (int b=0; b<str.length; b++) {
    			DEV[a][b] = Integer.parseInt(str[b]);
    			if (DEV[a][b]==1) queue.add(new Point(a,b));
    		}
    	}
    	while(!queue.isEmpty()) {
    		Point point = queue.poll();
    		DEV[point.x][point.y] = 2;
    		for (int i=0; i<4; i++) {
    			go_Find(1, i, point, n);
    		}
    		DEV[point.x][point.y] = 1;
    	}
    	System.out.println(count);
        int answer = -1;
        return answer;
    }
    
    public static void go_Find(int chance, int dir, Point point, int n) {
    	int nx = point.x+go_X[dir];
    	int ny = point.y+go_Y[dir];
    	if ((nx<0||nx>=DEV.length||ny<0||ny>=DEV[0].length)||(nx>=0&&nx<DEV.length&&ny>=0&&ny<=DEV[0].length&&DEV[nx][ny]==0)) {
    		if (chance==n) {
    			int px = point.x+ch_X[dir]*n;
    			int py = point.y+ch_Y[dir]*n;
    			if (px>=0&&px<DEV.length&&py>=0&&ny<DEV[0].length&&DEV[px][py]==1) return;
    			count++;
    		}
    		return;
    	}
    	if (DEV[nx][ny]==2) return;
    	DEV[nx][ny] = 2;
    	go_Find(chance+1, dir, new Point(nx, ny), n);
    	DEV[nx][ny] = 1;
    }
    
    
}
public class DevMatching_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DevMatching_02_Solution s = new DevMatching_02_Solution();
		//s.solution(7, 9, 4, new String[] {"111100000","000010011","111100011","111110011","111100011","111100010","111100000"}); // 10
		s.solution(5, 5, 5, new String[] {"11111","11111","11111","11111","11111"});

	}

}
