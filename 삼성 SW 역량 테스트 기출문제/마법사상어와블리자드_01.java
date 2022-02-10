
import java.util.*;
import java.io.*;
import java.awt.*;

public class 마법사상어와블리자드_01 {
	public static int N, M;
	public static int[][] DP;
	public static Point center;
	public static int[] go_X = { 0, -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, 0, -1, 1};
	public static ArrayList<Integer> numberarr = new ArrayList<Integer>();
	public static int one=0, two = 0, three = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* 하나하나 차근차근 해보기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		DP = new int[N][N];
		
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<N; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		
		center = new Point((N-1)/2, (N-1)/2);
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int d = Integer.parseInt(str[0]), s = Integer.parseInt(str[1]);
			attack(d,s);
			addnum();
			for (int a=0; a<N; a++) System.out.println(Arrays.toString(DP[a]));
			System.out.println(numberarr);
			clearlist();
			addlist();
			addarray();
			addnum();
			for (int a=0; a<N; a++) System.out.println(Arrays.toString(DP[a]));
			System.out.println("======================");
			numberarr.clear();
		}
		System.out.println("ONE = "+one+" TWO = "+two+" THREE = "+three);
		int answer = 1*one+2*two+3*three;
		System.out.println(answer);
		

	}
	public static void attack(int d, int s) {
		int cx = center.x, cy = center.y;
		for (int i=0; i<s; i++) {
			int nx = cx + go_X[d];
			int ny = cy + go_Y[d];
			if (nx<0||nx>=N||ny<0||ny>=N) return;
			DP[nx][ny] = 0;
			cx = nx; cy = ny;
		}
	}
	
	public static void addnum() {
		int cx = center.x, cy = center.y;
		int size = 1, cnt = 0, corner = 0;
		int dir = 3;
		
		while(true) {
			cnt++;
			cx +=go_X[dir]; cy+=go_Y[dir];
			
			if (cx==0&&cy==-1) return; /* 종결 조건 ( 전부 다 돌면 ) */
			if (DP[cx][cy]!=0) numberarr.add(DP[cx][cy]);
			if (cnt==size) {
				corner++;
				cnt=0;
				dir = dirchange(dir);
			}
			if (corner==2) {
				size++;
				corner=0;
			}
			
		}
	}
	
	public static void clearlist() {
		int count = 0, number = numberarr.size()>0?numberarr.get(0):Integer.MAX_VALUE;
		numberarr.add(0);
		boolean isRemove = false;
		TreeMap<Integer, Point> hashmap = new TreeMap<Integer, Point>();
		
		for (int i=0; i<numberarr.size();i++) {
			if (numberarr.get(i).equals(number)) count++;
			else {
				if (count>=4) {
					hashmap.put(i-count, new Point(number, count));
					isRemove = true;
				}
				number = numberarr.get(i);
				count = 1;
			}
		}
		System.out.println("TREE MAP = "+hashmap);
		if (isRemove) {
			int total = 0;
			for (Map.Entry<Integer, Point> entry : hashmap.entrySet()) {
				int locate = entry.getKey() - total;
				for (int i=0; i<entry.getValue().y&&(0<=locate&&locate<numberarr.size()); i++) {
					numberarr.remove(locate);
				}
				total+=entry.getValue().y;
				calculate(entry.getValue().x, entry.getValue().y);
			}
			System.out.println("콩콩     ====  "+numberarr);
			clearlist();
			return;
		}
	}
	public static void addlist() {
		numberarr.add(0);
		ArrayList<Integer> copyarr = new ArrayList<Integer>();
		int ballcount = 0, ballnumber = numberarr.get(0);
		for (int i=0; i<numberarr.size();i++) {
			if (numberarr.get(i).equals(ballnumber)) ballcount++;
			else {
				copyarr.add(ballcount); copyarr.add(ballnumber); ballcount=1; ballnumber = numberarr.get(i);
			}
			
		}
		numberarr.clear(); numberarr.addAll(copyarr);
	}
	public static void addarray() {
		int cx = center.x, cy = center.y;
		int cnt = 0, corner = 0, size = 1, dir = 3, index=0;
		while(true) {
			cnt++;
			cx+=go_X[dir]; cy+=go_Y[dir];
			if (cx==0&&cy==-1) return;
			if (index>=numberarr.size()) DP[cx][cy]=0;
			else DP[cx][cy] = numberarr.get(index++);
			
			if (cnt==size) {
				corner++;
				dir = dirchange(dir);
				cnt = 0;
			}
			
			if (corner ==2) {
				size++;
				corner=0;
			}
		}
	}
	public static void calculate(int num, int count) {
		switch(num) {
		case 1: one+=count; return;
		case 2: two+=count; return;
		case 3: three+=count; return;
		default: return;
		}
	}
	public static int dirchange(int dir) {
		switch(dir) {
		case 3: return 2;
		case 2: return 4;
		case 4: return 1;
		default: return 3;
		}
	}

}
