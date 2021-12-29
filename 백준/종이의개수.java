package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이의개수 {
	public static int N;
	public static int[][] Arr;
	public static int first=0,second=0,third=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arr = new int[N][N];
		for(int a=0; a<N; a++) {
			String[] str = br.readLine().split(" ");
			for(int b=0; b<N; b++) {
				Arr[a][b] = Integer.parseInt(str[b]);
			}
		}
		partition(0,0,N);
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
	}
	
	public static void partition(int row, int col, int size) {
		if (check(row, col, size)) { // 모두 같은 색이면
			if (Arr[row][col]==-1) first++;
			else if (Arr[row][col]==0) second++;
			else third++;
			return;
		}
		int newsize = size/3;
		partition(row,col,newsize);
		partition(row+newsize, col, newsize);
		partition(row+2*newsize, col, newsize);
		partition(row, col+newsize, newsize);
		partition(row+newsize, col+newsize, newsize);
		partition(row+2*newsize, col+newsize, newsize);
		partition(row, col+2*newsize, newsize);
		partition(row+newsize, col+2*newsize, newsize);
		partition(row+2*newsize, col+2*newsize, newsize);
		
		
		
	}
	
	public static boolean check(int row, int col, int size) {
		int number = Arr[row][col];
		for (int a=row; a<row+size; a++) {
			for (int b=col; b<col+size; b++) {
				if (Arr[a][b]!=number) return false;
			}
		}
		return true;
	}
}
