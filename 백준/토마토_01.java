package 백준;

import java.io.*;
import java.util.*;

class 토마토_01_Node{
	int x, y, z;
	public 토마토_01_Node(int x, int y, int z) {
		this.x = x; this.y = y; this.z = z;
	}
}

public class 토마토_01 {
	public static int M, N, H;
	public static int[][][] Arr;
	public static int[] go_X = { 0, 0, 0, 0, -1, 1 };
	public static int[] go_Y = { 0, 0, -1, 1, 0, 0 };
	public static int[] go_Z = { -1, 1, 0, 0, 0, 0 };
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]); N = Integer.parseInt(str[1]); H = Integer.parseInt(str[2]);
		Arr = new int[H][N][M];
		int total_count = 0;
		
		Queue<토마토_01_Node> queue = new LinkedList<토마토_01_Node>();
		for (int a=0; a<H; a++) {
			for (int b=0; b<N; b++) {
				str = br.readLine().split(" ");
				for (int c=0; c<M; c++) {
					Arr[a][b][c] = Integer.parseInt(str[c]);
					if (Arr[a][b][c]==0) total_count++;
					else if (Arr[a][b][c]==1) queue.add(new 토마토_01_Node(b, c, a));
				}
			}
		}
		int time = 0;
		while(!queue.isEmpty()) {
			time++;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				토마토_01_Node node = queue.poll();
				for (int p=0; p<6; p++) {
					int nx = node.x + go_X[p];
					int ny = node.y + go_Y[p];
					int nz = node.z + go_Z[p];
					if (nx<0||nx>=N||ny<0||ny>=M||nz<0||nz>=H) continue;
					if (Arr[nz][nx][ny]==0) {
						total_count-=1;
						queue.add(new 토마토_01_Node(nx, ny, nz));
						Arr[nz][nx][ny] = time;
					}
				}
			}
			
		}
		
		if (total_count==0) System.out.println(time-1);
		else System.out.println(-1);

	}

}
