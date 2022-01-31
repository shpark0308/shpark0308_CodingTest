package 백준;

import java.io.*;
import java.util.*;
import java.awt.*;

class 구슬탈출2_Node{
	Point red, blue;
	int num;
	public 구슬탈출2_Node(Point red, Point blue, int num ) {
		this.red = red; this.blue = blue; this.num = num;
	}
}

public class 구슬탈출2_01 {
	public static String[][] Arr;
	public static int N, M;
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};
	public static int[][] visited_red, visited_blue;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		Arr = new String[N][M]; visited_red = new int[N][M]; visited_blue = new int[N][M];
		
		Point red = new Point(), blue = new Point();
		for (int a=0; a<N; a++) {
			str = br.readLine().split("");
			for (int b=0; b<M; b++) {
				Arr[a][b] = str[b];
				if (Arr[a][b].equals("R")) red = new Point(a,b);
				else if (Arr[a][b].equals("B")) blue = new Point(a,b);
			}
		}
		
		Queue<구슬탈출2_Node> queue = new LinkedList<구슬탈출2_Node>();
		queue.add(new 구슬탈출2_Node(red, blue, 0));
		visited_red[red.x][red.y]=1; visited_blue[blue.x][blue.y]=1;
		int answer= -1;
		
		boolean flag = true;
		while(!queue.isEmpty()&&flag) {
			구슬탈출2_Node node = queue.poll();
			
			if (node.num>=10) {
				answer = -1;
				break;
			}
			//if (visited_red[node.red.x][node.red.y]==1||visited_blue[node.blue.x][node.blue.y]==1) continue;
			Arr[node.red.x][node.red.y] = "R";
			Arr[node.blue.x][node.blue.y] = "B";
			
			for (int i=0; i<4; i++) {
				/* 빨간 구슬 부터 */
				boolean red_f=false, blue_f = false;
				int index=0;
				for (index=0; node.red.x+go_X[i]*index>=0&&node.red.x+go_X[i]*index<N&&node.red.y+go_Y[i]*index>=0&&node.red.y+go_Y[i]*index<M ; index++) {
					if (Arr[node.red.x+go_X[i]*index][node.red.y+go_Y[i]*index].equals("#")) break;
					else if (Arr[node.red.x+go_X[i]*index][node.red.y+go_Y[i]*index].equals("O")) {
						red_f = true;
						break;
					}
				}
				Point next_red = new Point(node.red.x+go_X[i]*(index-1), node.red.y+go_Y[i]*(index-1));
				index = 0;
				for (index=0; node.blue.x+go_X[i]*index>=0&&node.blue.x+go_X[i]*index<N&&node.blue.y+go_Y[i]*index>=0&&node.blue.y+go_Y[i]*index<M ; index++) {
					if (Arr[node.blue.x+go_X[i]*index][node.blue.y+go_Y[i]*index].equals("#")) break;
					else if(Arr[node.blue.x+go_X[i]*index][node.blue.y+go_Y[i]*index].equals("O")) {
						blue_f = true;
						break;
					}
				}
				Point next_blue = new Point(node.blue.x+go_X[i]*(index-1), node.blue.y+go_Y[i]*(index-1));
				
				if (blue_f) continue;
				if (red_f&&!blue_f) {
					answer = node.num+1;
					flag = false;
					break;
				}
				if (next_red.equals(next_blue)) { /* 같은 위치에 있을 경우 */
					if (i==0) {
						if (node.red.x>node.blue.x) next_blue.setLocation(next_blue.x+1, next_blue.y);
						else next_red.setLocation(next_red.x+1, next_red.y);
					}
					else if (i==1) {
						if (node.red.x>node.blue.x) next_red.setLocation(node.red.x-1, node.red.y);
						else next_blue.setLocation(node.blue.x-1, node.blue.y);
					}
					else if (i==2) {
						if (node.red.y<node.blue.y) next_blue.setLocation(next_blue.x, next_blue.y+1);
						else next_red.setLocation(next_red.x, next_red.y+1);
					}
					else {
						if (node.red.y<node.blue.y) next_red.setLocation(next_red.x, next_red.y-1);
						else next_blue.setLocation(next_blue.x, next_blue.y-1);
					}
				}
				
				/* 구명에 빠지는 case */
				
				//System.out.println("여기는 오지 못한건가?   "+next_red+"  ///    "+next_blue);
				if (!(visited_red[next_red.x][next_red.y]==1&&visited_blue[next_blue.x][next_blue.y]==1)){
					queue.add(new 구슬탈출2_Node(next_red, next_blue, node.num+1));
					visited_red[next_red.x][next_red.y]=1; visited_blue[next_blue.x][next_blue.y]=1;
				}
				
			}
		}
		System.out.println(answer);
		
	}

}
