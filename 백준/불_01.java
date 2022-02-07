package 백준;

import java.io.*;
import java.awt.*;
import java.util.*;

public class 불_01 {
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};
	public static int N, M;
	public static String[][] Arr;
	public static Queue<Point> person = new LinkedList<Point>();
	public static Queue<Point> fire = new LinkedList<Point>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
			Arr = new String[M][N];
			for (int a=0; a<M; a++) {
				str = br.readLine().split("");
				for (int b=0; b<N; b++) {
					Arr[a][b] = str[b];
					if (Arr[a][b].equals("@")) person.add(new Point(a,b));
					else if (Arr[a][b].equals("*")) fire.add(new Point(a,b));
				}
			}
			int num = solve();
			if (num==-1) System.out.println("IMPOSSIBLE");
			else System.out.println(num);
			
			
			person.clear(); fire.clear();
			
		}
		

	}
	public static int solve() {
		int time = 0;
		while(!person.isEmpty()||!fire.isEmpty()) { // 이 조건이 맞는지
			time++;
			int firesize = fire.size();
			for (int p = 0; p<firesize; p++) {
				Point firenode = fire.poll();
				for (int i=0; i<4; i++) {
					int nx = firenode.x + go_X[i];
					int ny = firenode.y + go_Y[i];
					if (nx<0||nx>=M||ny<0||ny>=N) continue;
					if (Arr[nx][ny].equals("#")||Arr[nx][ny].equals("*")) continue; // visited는 어떻게 할것인지 -> * 이 있는 곳이면 안간다.
					Arr[nx][ny] = "*";
					fire.add(new Point(nx, ny));					
				}
			}
			
			int personsize = person.size();
			for (int q=0; q<personsize;q++) {
				Point node = person.poll();
				for (int i=0; i<4; i++) {
					int nx = node.x+go_X[i];
					int ny = node.y+go_Y[i];
					if (nx<0||nx>=M||ny<0||ny>=N) return time;
					if (!Arr[nx][ny].equals(".")) continue; // visited는 어떻게 할것인지 -> * 이 있는 곳이면 안간다.
					Arr[nx][ny] = "@";
					person.add(new Point(nx, ny));
				}
			}
		}
		return -1;
	}
	
}
