
import java.util.*;
import java.awt.*;

class 거리두기확인하기_02_Solution {
	public static Queue<Point> queue = new LinkedList<Point>();
	public static int[] go_X = { -1, 1, 0, 0 };
	public static int[] go_Y = { 0, 0, -1, 1 };
	public static boolean flag = true;
	
    public int[] solution(String[][] places) {
    	int[] answer = new int[5];
    	
    	for (int t=0; t<5; t++) {
    		flag = true;
    		
    		int[][] loc = new int[5][5];
    		for (int a=0; a<5; a++) { 
    			String[] str = places[t][a].split("");
    			for (int b=0; b<5; b++) {
    				if (str[b].equals("P")) {
    					loc[a][b] = 1;
    					queue.add(new Point(a,b));
    				}
    				else if (str[b].equals("O")) loc[a][b]=2;
    				else loc[a][b]=3;
    			}
    		}
    		System.out.println("queue = "+queue);
    		find(loc);
    		
    		answer[t]=(flag==true)?1:0;
    		System.out.println(answer[t]);
    		queue.clear();
    	}
    	System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    public static void find(int[][] loc) { // bfs
    	while(!queue.isEmpty()&&flag) {
    		Point point = queue.poll();
    		loc[point.x][point.y] = 4;
    		isOk(0, point, loc);
    		loc[point.x][point.y] = 1;
    		
    	}
    }
    
    public static void isOk(int chance, Point cur, int[][] loc) {
    	if (!flag) return;
    	if (chance==2) {
    		for (int i=0; i<5; i++) System.out.println(Arrays.toString(loc[i]));
    		System.out.println("---------------------");
    		return;
    	}
    	
    	
    	for (int i=0; i<4; i++) {
    		int nx = cur.x+go_X[i];
    		int ny = cur.y+go_Y[i];
    		if (nx<0||nx>=5||ny<0||ny>=5) continue;
    		if (loc[nx][ny]==4||loc[nx][ny]==3) continue; // loc[nx][ny] == 4 -> 방문했다는 뜻
    		if (loc[nx][ny]==1) {
    			System.out.println("통통 "+nx+" ** "+ny+" "+loc[nx][ny]);
    			flag = false;
    			return;
    		}
    		System.out.println("여기까지는 온건가 ? "+nx+" / "+ny);
    		loc[nx][ny] = 4;
    		isOk(chance+1, new Point(nx, ny), loc);
    		loc[nx][ny] = 2;
    	}
    	
    }
}

public class 거리두기확인하기_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		거리두기확인하기_02_Solution s = new 거리두기확인하기_02_Solution();
		s.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

	}

}
