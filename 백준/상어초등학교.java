package 백준;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 상어초등학교 {
	public static int[] go_X = { -1, 1, 0, 0 };
	public static int[] go_Y = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] DP = new int[N*N][5];
		for (int a=0; a<N*N; a++) {
			for (int b=0; b<5; b++) {
				DP[a][b] = sc.nextInt();
			}
		}
		
		int[][] arr = new int[N][N];
		HashMap<Integer, Point> nodeloc = new HashMap<Integer, Point>(); // 위치를 저장하는 것
		HashMap<Point, Integer> calcloc = new HashMap<Point, Integer>();
		ArrayList<Point> candidate = new ArrayList<Point>();
		
		for (int a=0; a<N*N; a++) {
			int num = DP[a][0];
			for (int b=1; b<5;b++) {
				if (nodeloc.containsKey(DP[a][b])) {
					Point point = nodeloc.get(DP[a][b]);
					for (int t=0; t<4; t++) {
						int nx = point.x + go_X[t];
						int ny = point.y + go_Y[t];
						if (nx<0||nx>=N||ny<0||ny>=N) continue;
						if (arr[nx][ny]!=0) continue; // 이미 채워져 있다는 것
						Point p = new Point(nx, ny);
						if (!calcloc.containsKey(p)) calcloc.put(p, 1);
						else calcloc.put(p, calcloc.get(p)+1);
					}
				}
			}
			
			if (calcloc.size()==0) { // 빈자리에서 검색 1. 빈자리도 많을 수 있고 2. 빈자리도 적을 수 있음
				for (int p=0; p<N; p++) {
					for (int q=0; q<N;q++) {
						if (arr[p][q]==0) candidate.add(new Point(p,q));
					}
				}
			}
			else {
				int max = Collections.max(calcloc.values());
				for (Map.Entry<Point, Integer> entry : calcloc.entrySet()) {
					if (entry.getValue()==max) {
						candidate.add(entry.getKey());
					}
				}
			}
			calcloc.clear();
			if (candidate.size()==1) { // 그 애로 지정하면 되니까
				arr[candidate.get(0).x][candidate.get(0).y] = num;
				nodeloc.put(num, candidate.get(0));
			}
			else { // 여러개면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
				for (int i=0; i<candidate.size();i++) {
					Point point = candidate.get(i);
					int count=0;
					for (int t=0;t<4;t++) {
						int nx = point.x+go_X[t];
						int ny = point.y+go_Y[t];
						if (nx<0||nx>=N||ny<0||ny>=N) continue;
						if (arr[nx][ny]==0) count++;
					}
					calcloc.put(point, count);
				}
				candidate.clear();
				int max2 = Collections.max(calcloc.values());
				for (Map.Entry<Point, Integer> entry : calcloc.entrySet()) {
					if (entry.getValue()==max2) {
						candidate.add(entry.getKey());
					}
				}
				if (candidate.size()==1) {
					arr[candidate.get(0).x][candidate.get(0).y] = num;
					nodeloc.put(num, candidate.get(0));
				}
				else {
					Point cdpoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
					for (int i=0; i<candidate.size();i++) {
						if (candidate.get(i).x<cdpoint.x) {
							cdpoint.x = candidate.get(i).x;
							cdpoint.y = candidate.get(i).y;
						}
						else if (candidate.get(i).x == cdpoint.x) {
							if (candidate.get(i).y<cdpoint.y) {
								cdpoint.x = candidate.get(i).x;
								cdpoint.y = candidate.get(i).y;
							}
						}
					}
					arr[cdpoint.x][cdpoint.y]=num;
					nodeloc.put(num, cdpoint);
				}
			}
			calcloc.clear();
			candidate.clear();
		}
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int total = 0;
		int countnum = 0;
		for (int i=0; i<N*N; i++) {
			countnum = 0;
			int number = DP[i][0];
			Point pp = nodeloc.get(number);
			ar.addAll(Arrays.asList(DP[i][1],DP[i][2],DP[i][3],DP[i][4]));
			for (int t=0; t<4; t++) {
				int nx = pp.x+go_X[t];
				int ny = pp.y+go_Y[t];
				if (nx<0||nx>=N||ny<0||ny>=N) continue;
				if (ar.contains(arr[nx][ny])) countnum++;
			}
			total+=checknum(countnum);
			ar.clear();
		}
		System.out.println(total);
	}
	public static int checknum(int num) {
		switch(num) {
		case 0: return 0;
		case 1: return 1;
		case 2: return 10;
		case 3: return 100;
		case 4: return 1000;
		default: return -1;
		}
	}

}