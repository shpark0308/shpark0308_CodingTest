package 알고리즘기초;

import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 탈출_01 {
	public static int R,C;
	public static String[][] DP;
	public static int[][] Arr;
	public static Point beaver;
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]); C = Integer.parseInt(str[1]);
		DP = new String[R][C]; Arr = new int[R][C];
		Queue<Point> hedgehog_arr = new LinkedList<Point>();
		Queue<Point> water_arr = new LinkedList<Point>();
		for(int a=0; a<R; a++) {
			str = br.readLine().split("");
			for (int b=0; b<C; b++) {
				DP[a][b] = str[b];
				if (str[b].equals("S")) hedgehog_arr.add(new Point(a,b));
				else if (str[b].equals("*")) water_arr.add(new Point(a,b));
				else if (str[b].equals("D")) beaver = new Point(a,b);
			}
		}
		int time = 0;
		boolean flag = true;
		while((!hedgehog_arr.isEmpty()||!water_arr.isEmpty())&&flag) {
			// 물을 먼저 -> 고슴도치를 다음 : 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다.
			// 일단 하기
			time++;
			int water_size = water_arr.size();
			for (int p=0; p<water_size; p++) {
				Point water = water_arr.poll();
				for (int i=0; i<4; i++) {
					int nx = water.x+go_X[i];
					int ny = water.y+go_Y[i];
					if (nx<0||nx>=R||ny<0||ny>=C) continue;
					if (DP[nx][ny].equals("X")||DP[nx][ny].equals("*")||DP[nx][ny].equals("D")) continue;
					DP[nx][ny] = "*";
					water_arr.add(new Point(nx,ny));
				}
			}
			System.out.println(hedgehog_arr);
			int hedgehog_size = hedgehog_arr.size();
			for (int q=0; q<hedgehog_size; q++) {
				Point hedgehog = hedgehog_arr.poll();
				for (int i=0; i<4; i++) {
					int nx = hedgehog.x+go_X[i];
					int ny = hedgehog.y+go_Y[i];
					if (nx<0||nx>=R||ny<0||ny>=C) continue;
					if (DP[nx][ny].equals("S")||DP[nx][ny].equals("*")||DP[nx][ny].equals("X")) continue;
					if (DP[nx][ny].equals("D")) {
						System.out.println("여기로 안온건가?");
						DP[nx][ny] = "S";
						flag = false;
						break;
					}
					DP[nx][ny] = "S";
					hedgehog_arr.add(new Point(nx,ny));
				}
				
			}
			for (int k=0; k<R; k++) {
				System.out.println(Arrays.toString(DP[k]));
			}
			System.out.println("----------------------");
		}
		if (DP[beaver.x][beaver.y].equals("D")) System.out.println("KAKTUS");
		else System.out.println(time);
		

	}

}
