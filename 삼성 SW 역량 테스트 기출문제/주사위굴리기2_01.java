import java.io.*;
import java.util.*;
import java.awt.*;

public class 주사위굴리기2_01 {
	public static int N, M, K;
	public static int total=0, count = 0;
	public static int[][] Arr;
	public static boolean[][] visited;
	public static Point current = new Point(0,0);
	public static int[] go_X = { 0, 1, 0, -1}; // 동 남 서 북
	public static int[] go_Y = { 1, 0, -1, 0};
	public static int[] dice = { 0, 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); K = Integer.parseInt(str[2]);
		
		Arr = new int[N][M];
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) Arr[a][b] = Integer.parseInt(str[b]);
		}
		
		int direct = 0;
		for (int i=0; i<K; i++) {
			direct = move(direct);
			count=1;
			bfs();
			total+=Arr[current.x][current.y]*count;
			
		}
		System.out.println(total);
		
	}
	
	public static int move(int direct) {
		int nx = current.x+go_X[direct];
		int ny = current.y+go_Y[direct];
		if (nx<0||nx>=N||ny<0||ny>=M) {
			direct = (direct<2?(direct==0?2:3):(direct==2?0:1));
			nx = current.x+go_X[direct];
			ny = current.y+go_Y[direct];
		}
		moveDice(direct);
		direct = rotate(direct, dice[6]-Arr[nx][ny]);
		current.setLocation(nx, ny);
		return direct;
	}
	
	public static int rotate(int direct, int num) { // direct return;
		int[] temp = Arrays.copyOf(dice, 7);
		
		if (num>0) {
			//dice[2] = temp[4]; dice[3] = temp[2]; dice[5] = temp[3]; dice[4] = temp[5];
			direct = direct==3?0:direct+1;
		}
		else if (num<0) {
			//dice[2] = temp[3]; dice[3] = temp[5]; dice[5] = temp[4]; dice[4] = temp[2];
			direct = direct==0?3:direct-1;
		}
		return direct;
	}
	
	public static void moveDice(int direct) {
		int[] temp = Arrays.copyOf(dice, 7);
		switch(direct) {
		case 0: dice[1] = temp[4]; dice[3]=temp[1]; dice[6] = temp[3]; dice[4] = temp[6]; return;
		case 1: dice[1] = temp[2]; dice[5]=temp[1]; dice[6] = temp[5]; dice[2] = temp[6]; return;
		case 2: dice[1] = temp[3]; dice[4]=temp[1]; dice[6] = temp[4]; dice[3] = temp[6]; return;
		case 3: dice[1] = temp[5]; dice[2]=temp[1]; dice[6] = temp[2]; dice[5] = temp[6]; return;
		}
	}
	public static void bfs() {
		visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<Point>(); queue.add(current);
		visited[current.x][current.y] = true;
		
		while(!queue.isEmpty()) { /*그냥 말 그대로 연속으로 갈 수 있는곳중에 */
			Point point = queue.poll();
			
			for (int i=0; i<4; i++) {
				int nx = point.x+go_X[i];
				int ny = point.y+go_Y[i];
				if (nx<0||nx>=N||ny<0||ny>=M) continue;
				if (visited[nx][ny]||Arr[nx][ny]!=Arr[current.x][current.y]) continue;
				count++;
				visited[nx][ny] = true;
				queue.add(new Point(nx,ny));
				
			}
		}
	}

}
