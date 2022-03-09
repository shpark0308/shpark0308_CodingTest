package 백준;

import java.io.*;
import java.util.*;


public class 원판돌리기_01 {
	public static int N, M, T;
	public static int[][] circle;
	public static int totalzero=0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]); T = Integer.parseInt(str[2]);
		circle = new int[N+1][M];
		
		for (int a=1; a<=N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) circle[a][b] = Integer.parseInt(str[b]);
		}
		
		for (int i=0; i<T; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]), d = Integer.parseInt(str[1]), k = Integer.parseInt(str[2]);
			
			for (int t=x; t<=N; t+=x) rotate(t,d,k);
			System.out.println("=====================");
			for (int p=1; p<=N; p++) System.out.println(Arrays.toString(circle[p])); 
			nearclear();
			System.out.println("************************");
			for (int p=1; p<=N; p++) System.out.println(Arrays.toString(circle[p])); 
			
			
		}
		System.out.println("정답 = "+calcSum());

	}
	public static void rotate(int x, int d, int k) {
		int[] copyarr = new int[M];
		int index = d==0?M-k:k;

		for (int i=0; i<M; i++) {
			copyarr[i] = circle[x][index];
			index++;
			if (index==M) index = 0;
		}
		System.arraycopy(copyarr, 0, circle[x], 0, M);
	}
	
	public static void nearclear() {
		totalzero = 0;
		int sum = 0, count = 0;
		
		for (int a=1; a<=N; a++) {
			for (int b=0; b<M; b++) {
				sum+=circle[a][b];
				if (circle[a][b]==0) continue;
				count++;
				int num = circle[a][b];
				clearnum(a,b,num);
				
				if (circle[a][b]==0) {
					System.out.println("{ "+a+" & "+b+" }");
					for (int p=1; p<=N; p++) System.out.println(Arrays.toString(circle[p])); 
				}
			}
		}
		
		if (totalzero==0) {
			double avg = (double)sum / count;
			System.out.println("AVG = "+avg);
			for (int a=1; a<=N; a++) {
				for (int b=0; b<M; b++) {
					if (circle[a][b]==0||circle[a][b]==avg) continue;
					if (circle[a][b]<avg) circle[a][b]++;
					else circle[a][b]--;
				}
			}
			
		}
	}
	
	public static int calcSum() {
		int sum = 0;
		for (int a=1; a<=N; a++) {
			sum+= Arrays.stream(circle[a]).sum();
		}
		return sum;
	}
	
	public static void clearnum(int a, int b, int num) {
		for (int p=(b==M-1)?0:(b+1); p!=b&&circle[a][p]==num;) { // 오른쪽
			circle[a][p] = 0; circle[a][b] = 0;
			totalzero++;
			clearnum(a,p,num);
			p++;
			if (p==M) p=0; // 순환
			
		}
		for (int p=(b==0)?M-1:b-1; p!=b&&circle[a][p]==num;) { // 왼쪽
			circle[a][p] = 0; circle[a][b] = 0;
			totalzero++;
			clearnum(a,p,num);
			p--;
			if (p==-1) p = M-1; 
			
		}
		for (int p=a-1; p>=1&&circle[p][b]==num;) { // 위쪽 -> 순한 X
			System.out.println("P1 = "+p);
			circle[p][b] = 0; circle[a][b] = 0;
			totalzero++;
			clearnum(p,b,num);
			p--;
			
		}
		for (int p=a+1; p<=N &&circle[p][b]==num;) { // 아래쪽 -> 순환 X
			System.out.println("P2 = "+p+" / "+a+" / "+b);
			circle[p][b] = 0; circle[a][b] = 0;
			totalzero++;
			clearnum(p,b,num);
			p++;
			
		}
		
	}
}
