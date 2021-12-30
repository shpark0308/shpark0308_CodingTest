package KAKAO_BLIND_RECRUITMENT;

import java.awt.*;
import java.util.*;

class 카드짝맞추기_01_Solution {
	public static int[] go_X = {-1, 1, 0, 0}; // 위 아래 왼쪽 오른쪽
	public static int[] go_Y = {0, 0, -1, 1};
    public int solution(int[][] board, int r, int c) {
    	HashMap<Integer, ArrayList<Point>> character = new HashMap<Integer, ArrayList<Point>>();
    	int cardnum = 0;
    	for (int a=0; a<4; a++) {
    		for (int b=0; b<4; b++) {
    			if (board[a][b]!=0) {
    				cardnum++;
    				Point point = new Point(a,b);
    				if (!character.containsKey(board[a][b])) {
    					character.put(board[a][b], new ArrayList<Point>());
    				}
    				character.get(board[a][b]).add(point);
    			}
    		}
    	}
    	
    	Queue<Point> queue = new LinkedList<Point>();
    	queue.add(new Point(r,c));
    	
    	int count=0;
    	
    	Point card1 = null, card2 = null;
    	int index = 0;
    	while(!queue.isEmpty()) {
    		if (cardnum==0) break;
    		Point point = queue.poll();
    		int cx = point.x;
    		int cy = point.y;
    		if (board[cx][cy]!=0) {
    			System.out.println("[1]. "+count);
    			count++; // 카드 한번 까보는 것
    			System.out.println("[2]. "+count);
				card1 = point;
				character.get(board[cx][cy]).remove(card1);
				card2 = character.get(board[cx][cy]).get(0);
				System.out.println(">>>>   "+card1+"   "+card2+"   "+" count : "+count);
				count=count+bfs(card1, card2, board)+1;
				System.out.println("[3]. "+count);
				System.out.println("가가가가가가  "+count);
				board[card1.x][card1.y] = 0; board[card2.x][card2.y] = 0;
				cardnum-=2;
				queue.add(card2);
    		}
    		else {
    			System.out.println("일단 여기는 왔니?");
    			Queue<Point> qq = new LinkedList<Point>();
    			qq.add(point);
    			int[][] array = new int[4][4];
    			for (int i=0; i<4; i++) Arrays.fill(array[i], Integer.MAX_VALUE);
    			array[cx][cy]=0;
    			boolean flag = true;
    			while(!qq.isEmpty()&&flag) {
    				Point qpoint = qq.poll();
    				int qx = qpoint.x;
    				int qy = qpoint.y;
    				if (array[qx][qy]!=Integer.MAX_VALUE&&qx!=cx&&qy!=cy) continue;
    				System.out.println("[ "+qx+" "+qy+"]");
    				for (int i=0; i<4; i++) {
    	    			int nx = qx+go_X[i];
    	    			int ny = qy+go_Y[i];
    	    			if (nx<0||nx>=4||ny<0||ny>=4) continue;
    	    			System.out.println("nx : "+nx+" ny : "+ny+" qx : "+qx+" qy : "+qy);
    	    			array[nx][ny] = Math.min(array[nx][ny], array[qx][qy]+1);
    	    			if (board[nx][ny]!=0) {
        					System.out.println("라라  "+qpoint);
        					for (int k=0; k<4; k++) System.out.println(Arrays.toString(array[k]));
            				System.out.println("---------------");
        					queue.add(new Point(nx,ny));
        					count+=array[nx][ny];
        					flag = false;
        					break;
        				}
    	    			qq.add(new Point(nx, ny));
    	    			if (board[nx][ny]==0) {
    	    				Point nextpoint = ctrlMove(i, nx, ny, board);
    	    				array[nextpoint.x][nextpoint.y] =  Math.min(array[nextpoint.x][nextpoint.y], array[qx][qy]+1);
    	    				if (board[nextpoint.x][nextpoint.y]!=0) {
    	    					System.out.println("라라  "+qpoint);
    	    					for (int k=0; k<4; k++) System.out.println(Arrays.toString(array[k]));
    	        				System.out.println("---------------");
    	    					queue.add(new Point(nextpoint.x,nextpoint.y));
    	    					count+=array[nextpoint.x][nextpoint.y];
    	    					flag = false;
    	    					break;
    	    				}
    	    				qq.add(new Point(nextpoint.x, nextpoint.y));
    	    			}
    	    		}
    				for (int k=0; k<4; k++) System.out.println(Arrays.toString(array[k]));
    				System.out.println("---------------");
    				System.out.println(qq);
    				index++;
    	    		if (index == 20) break;
    			}
    		}
    		/* 새로운 bfs를 완성하기 */
    		index++;
    		if (index == 20) break;
    	}
        int answer = 0;
        return answer;
    }
    public static int bfs(Point card1, Point card2, int[][] board) {
    	Queue<Point> queue = new LinkedList<Point>();
    	/* array 먼저 만들어 주기 */
    	int[][] Arr = new int[4][4];
    	for (int i=0; i<4; i++) Arrays.fill(Arr[i], Integer.MAX_VALUE);
    	Arr[card1.x][card1.y] = 0; // 시작 부분은 0
    	queue.add(card1);
    	
    	while(!queue.isEmpty()) {
    		Point point = queue.poll();
    		int cx = point.x;
    		int cy = point.y;
    		if (Arr[cx][cy]!=Integer.MAX_VALUE&&cx!=card1.x&&cy!=card1.y) continue; // 이미 방문한 아이들은 continue;
    		for (int i=0; i<4; i++) {
    			int nx = cx+go_X[i];
    			int ny = cy+go_Y[i];
    			if (nx<0||nx>=4||ny<0||ny>=4) continue;
    			Arr[nx][ny] = Math.min(Arr[nx][ny], Arr[cx][cy]+1);
    			if (nx == card2.x && ny == card2.y) {
        			System.out.println("통통 ++   "+Arr[nx][ny]);
        			return Arr[nx][ny];
        		}
    			queue.add(new Point(nx, ny));
    			if (board[nx][ny]==0) {
    				Point nextpoint = ctrlMove(i, nx, ny, board);
    				//System.out.println(nextpoint);
    				Arr[nextpoint.x][nextpoint.y] =  Math.min(Arr[nextpoint.x][nextpoint.y], Arr[cx][cy]+1);
    				if (nextpoint.x == card2.x && nextpoint.y == card2.y) {
    	    			System.out.println("통통  +++++   " + Arr[nextpoint.x][nextpoint.y]);
    	    			return Arr[nextpoint.x][nextpoint.y];
    	    		}
    				queue.add(new Point(nextpoint.x, nextpoint.y));
    			}
    		}
    		for (int k=0; k<4; k++) System.out.println(Arrays.toString(Arr[k]));
			System.out.println("***********************");
    	}
    	return board[card2.x][card2.y];
    }
    public static Point ctrlMove(int direct,int cx, int cy, int[][] board) {
    	//System.out.println("cx = "+cx + "  cy = "+cy);
    	while(board[cx][cy]==0) {
    		int nx = cx + go_X[direct];
    		int ny = cy + go_Y[direct];
    		if (nx<0||nx>=4||ny<0||ny>=4) break;
    		cx = nx; cy = ny;
    	}
    	return new Point(cx, cy);
    	
    }
}

public class 카드짝맞추기_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		카드짝맞추기_01_Solution s = new 카드짝맞추기_01_Solution();
		s.solution(new int[][] {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0);
		//s.solution(new int[][] {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}}, 0, 1);

	}

}
