import java.util.*;
import java.io.*;
import java.awt.*;

public class 마법사상어와복제_01 {
	public static int M, S;
	public static int[][] pastDP = new int[5][5], curDP = new int[5][5], dirDP = new int[5][5]; // DP1 : 2번 전
	public static Queue<Point> fishlist = new LinkedList<Point>();
	public static int[] go_X = {0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] go_Y = {0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] sharkdir = { 3, 1, 7, 5 };
	public static String maxdirect;
	public static Point shark;
	public static int maxnum = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 일단해보기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]); S = Integer.parseInt(str[1]);
		
		// curDP : 1 ~ 8 = 물고기 갯수 -1 = 물고기 냄새 -2 = 상어냄새
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]), c = Integer.parseInt(str[2]);
			dirDP[a][b] = c;
			fishlist.add(new Point(a, b));
		}
		
		str = br.readLine().split(" ");
		curDP[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = -2;
		shark = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		
		goOneStep();
		moveShark(0, shark, 3, "");
		/* curDP가 원래데로 돌아왔는지 */
		/* 구해놓은 maxdirect 에서 상어 위치 조정하기 */
		System.out.println(maxnum+" / "+maxdirect);
		for (int a=1; a<5; a++) System.out.println(Arrays.toString(dirDP[a]));
		int chance = 0;
		

	}
	public static void goOneStep() {
		int size = fishlist.size();
		for (int i=0; i<size; i++) {
			Point fish = fishlist.poll();
			int dir = rotation(fish.x, fish.y, dirDP[fish.x][fish.y], 8);

			if (dir==-1) continue;
			
			int nx = fish.x+go_X[dir];
			int ny = fish.y+go_Y[dir];
			dirDP[nx][ny] = dir; dirDP[fish.x][fish.y] = 0;
			curDP[nx][ny]++;
			fishlist.add(new Point(nx, ny));
		}
	}
	
	public static int rotation(int x, int y, int dir, int chance) {
		if (dir<=0) dir = 8;
		if (chance == 0) return -1;
		int nx = x+go_X[dir];
		int ny = y+go_Y[dir];
		
		if ((nx<1||nx>=5||ny<1||ny>=5)||curDP[nx][ny]==-1||curDP[nx][ny]==-2) return rotation(x,y, dir-1, chance-1);
		else return dir;
	}
	
	public static void moveShark(int total, Point location, int chance , String direct) { 
		if (chance==0) {
			if (total>maxnum) {
				maxnum = total;
				maxdirect = direct;
			}
			return;
		}
		for (int i=0; i<4; i++) {
			int nx = location.x+go_X[sharkdir[i]];
			int ny = location.y+go_Y[sharkdir[i]];
			if (nx<1||nx>=5||ny<1||ny>=5) continue;
			if (curDP[nx][ny]>0) {
				int temp = curDP[nx][ny];
				curDP[nx][ny] =0;
				moveShark(total+temp, new Point(nx, ny), chance-1, direct+i);
				curDP[nx][ny]+=temp;
			}
			else moveShark(total, new Point(nx, ny), chance-1, direct+i);
			
		}
	}

}
