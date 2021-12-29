package 백준;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 치킨배달_01 {
	public static int[] go_X = { -1, 1, 0, 0 }; // 위 아래
	public static int[] go_Y = { 0, 0, -1, 1 };
	public static ArrayList<Point> house = new ArrayList<Point>();
	public static ArrayList<Point> chicken = new ArrayList<Point>();
	public static int minimal = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] DP = new int[N][N];
		
		for (int a=0; a<N; a++) {
			for (int b=0; b<N; b++) {
				DP[a][b] = sc.nextInt();
				if (DP[a][b]==2) chicken.add(new Point(a,b));
				else if (DP[a][b]==1) house.add(new Point(a,b));
			}
		}
		combination(0, M, new ArrayList<Point>(), chicken.size());
		System.out.println(minimal);

	}

	public static void combination(int index, int r, ArrayList<Point> arr, int n) {
		if (r==0) {
			calculate(arr);
			return;
		}
		ArrayList<Point> ar = new ArrayList<Point>();
		ar.addAll(arr);
		for (int i=index; i<n; i++) { // n 은 끝까지
			ar.add(chicken.get(i));
			combination(i+1, r-1, new ArrayList<Point>(ar), n);
			ar.remove(ar.size()-1);
		}
	}
	
	public static void calculate(ArrayList<Point> arr) {
		int[] DP = new int[house.size()];
		Arrays.fill(DP, Integer.MAX_VALUE);
		for (int a=0; a<arr.size();a++) {
			int cx = arr.get(a).x;
			int cy = arr.get(a).y;
			for (int b=0; b<house.size();b++) {
				int nx = house.get(b).x;
				int ny = house.get(b).y;
				int temp = Math.abs(nx-cx)+Math.abs(ny-cy);
				DP[b] = Math.min(DP[b], temp);
			}
		}
		minimal = Math.min(minimal, Arrays.stream(DP).sum());
	}
	

}
