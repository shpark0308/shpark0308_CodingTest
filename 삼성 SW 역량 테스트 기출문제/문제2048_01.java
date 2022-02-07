
import java.util.*;
import java.io.*;
import java.awt.*;

public class 문제2048_01 {
	public static int N;
	public static int[] go_X = { 0, 0, -1, 1};
	public static int[] go_Y = { -1, 1, 0, 0};
	public static int maxnum = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] DP = new int[N][N];
		for (int a=0; a<N; a++) {
			String[] str = br.readLine().split(" ");
			for (int b=0; b<N; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		dfs(DP, 1);
		System.out.println("maxnum = "+maxnum);

	}
	
	public static void dfs(int[][] DP, int chance) {
		if (chance == 0) {
			for(int k=0; k<N; k++) maxnum = Math.max(Arrays.stream(DP[k]).max().getAsInt(), maxnum);
			return;
		}
		dfs(move1(DP), chance-1);
		dfs(move2(DP), chance-1);
		dfs(move3(DP), chance-1);
		dfs(move4(DP), chance-1);
	}
	public static int[][] move1(int[][] copy) {
		int[][] DP = new int[N][N];
		for (int a=0; a<N; a++) DP[a] = Arrays.copyOf(copy[a], N);
		
		for (int a=0; a<N; a++) {
			boolean flag = true;
			for (int b=1; b<N; b++) {
				int count = 0;
				if (DP[a][b]!=0) {
					int t = (b-1);
					for (t=(b-1); (t>=0&&t<N)&&DP[a][t]==0 ;t--) {}
					if (t==-1) DP[a][t+1] = DP[a][b];
					else {
						if (DP[a][t]==DP[a][b]&&flag) {
							DP[a][t] +=DP[a][b];
							count = 1;
							flag = false;
						}
						else DP[a][t+1] = DP[a][b];
					}
					if (count==0&&flag==false) flag = true;
					if (!((t+1)==b)&&count==0)DP[a][b]=0;
					else if (count==1) DP[a][b] = 0;
				}
			}
		}
		System.out.println("----------[MOVE1]---------");
		for (int a=0; a<N; a++) System.out.println(Arrays.toString(DP[a]));
		return DP;
	}
	public static int[][] move2(int[][] copy){
		int[][] DP = new int[N][N];
		for (int a=0; a<N; a++) DP[a] = Arrays.copyOf(copy[a], N);
		
		for (int a=0; a<N; a++) {
			boolean flag = true;
			for (int b=(N-2); b>=0; b--) { // N-1은 안하는 이유는 더이상 이동할 곳이 없으니까
				int count = 0;
				if (DP[a][b]!=0) {
					int t = (b+1);
					for (t=(b+1); (t>=0&&t<N)&&DP[a][t]==0 ;t++) {}
					if (t==N) DP[a][t-1] = DP[a][b];
					else {
						if (DP[a][t]==DP[a][b]&&flag) {
							DP[a][t] +=DP[a][b];
							count++;
							flag = false;
						}
						else DP[a][t-1] = DP[a][b];
					}
					if (count==0&&flag==false) flag = true;
					if (!((t-1)==b)&&count==0)DP[a][b]=0;
					else if (count==1) DP[a][b]=0;
					for (int k=0; k<N; k++) System.out.println(Arrays.toString(DP[k]));
					System.out.println("***************");
				}
			}
		}
		System.out.println("----------[MOVE2]---------");
		for (int a=0; a<N; a++) System.out.println(Arrays.toString(DP[a]));
		System.out.println("====================");
		return DP;
	}
	public static int[][] move3(int[][] copy) {
		int[][] DP = new int[N][N];
		for (int a=0; a<N; a++) DP[a] = Arrays.copyOf(copy[a], N);
		
		for (int a=0; a<N; a++) {
			boolean flag = true;
			for (int b=1; b<N; b++) {
				int count = 0;
				if (DP[b][a]!=0) {
					int t = (b-1);
					for (t=(b-1); (t>=0&&t<N)&&DP[t][a]==0 ;t--) {}
					if (t==-1) DP[t+1][a] = DP[b][a];
					else {
						if (DP[t][a]==DP[b][a]&&flag) {
							DP[t][a] +=DP[b][a];
							count++;
							flag = false;
						}
						else DP[t+1][a] = DP[b][a];
					}
					if (count==0&&flag==false) flag = true;
					if (!((t+1)==b)&&count==0)DP[b][a]=0;
					else if (count==1) DP[b][a]=0;
				}
			}
			
		}
		System.out.println("----------[MOVE3]---------");
		for (int k=0; k<N; k++) System.out.println(Arrays.toString(DP[k]));
		System.out.println("====================");
		return DP;
	}
	public static int[][] move4(int[][] copy) {
		int[][] DP = new int[N][N];
		for (int a=0; a<N; a++) DP[a] = Arrays.copyOf(copy[a], N);
		
		for (int a=0; a<N; a++) {
			boolean flag = true;
			for (int b=(N-2); b>=0; b--) {
				int count = 0;
				if (DP[b][a]!=0) {
					int t = (b+1);
					for (t=(b+1); (t>=0&&t<N)&&DP[t][a]==0 ;t++) {}
					if (t==N) DP[t-1][a] = DP[b][a];
					else {
						if (DP[t][a]==DP[b][a]&&flag) {
							DP[t][a]+=DP[b][a];
							count++;
							flag = false;
						}
						else DP[t-1][a] = DP[b][a];
					}
					if (count==0&&flag==false) flag = true;
					if (!((t-1)==b)&&count==0)DP[b][a]=0;
					else if (count==1) DP[b][a]=0;
				}
			}
			
		}
		System.out.println("----------[MOVE4]---------");
		for (int k=0; k<N; k++) System.out.println(Arrays.toString(DP[k]));
		System.out.println("====================");
		return DP;
	}
}
