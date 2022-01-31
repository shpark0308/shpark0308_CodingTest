package πÈ¡ÿ;

import java.io.*;
import java.util.*;
import java.awt.*;

public class ≤…±Ê_01 {
	public static int[][] DP;
	public static int[] go_X = { -1, 1, 0, 0 };
	public static int[] go_Y = { 0, 0, -1, 1 };
	public static int N,M, sum, minsum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N*N;
		DP = new int[N][N];
		for (int a=0; a<N; a++) {
			String[] str = br.readLine().split(" ");
			for (int b=0; b<N; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		
		combination(3, 0, new ArrayList<Integer>());
		System.out.println(minsum);

	}
	public static void combination(int index, int temp,  ArrayList<Integer> array) {
		if (index==0) {
			sum = 0;
			if (Flower(array)) {
				minsum = Math.min(minsum, sum);
			}
			return;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.addAll(array);
		for (int i=temp; i<M; i++) {
			ar.add(i);
			combination(index-1, i+1, new ArrayList<Integer>(ar));
			ar.remove(ar.size()-1);
		}
		
	}
	
	public static boolean Flower(ArrayList<Integer> array) {
		Point num1 = new Point(array.get(0)/N, array.get(0)%N);
		Point num2 = new Point(array.get(1)/N, array.get(1)%N);
		Point num3 = new Point(array.get(2)/N, array.get(2)%N);
		ArrayList<Point> arr = new ArrayList<Point>();
		arr.add(num1); arr.add(num2); arr.add(num3); 
		sum = sum + DP[num1.x][num1.y] + DP[num2.x][num2.y] + DP[num3.x][num3.y];
		
		for (int a=0; a<3; a++) {
			for (int i=0; i<4; i++) {
				Point point = new Point(arr.get(a).x+go_X[i], arr.get(a).y+go_Y[i]);
				if (arr.contains(point)) return false;
				if (point.x<0||point.x>=N||point.y<0||point.y>=N) return false;
				sum+=DP[point.x][point.y];
				arr.add(point);
			}
		}
		return true;
	}

}
