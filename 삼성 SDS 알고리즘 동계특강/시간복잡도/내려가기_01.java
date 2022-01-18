package 시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 내려가기_01 {
	public static int[] go = { -1, 0, 1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/* DFS 로 풀어보기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] DP = new int[N][3],max = new int[N][3], min = new int[N][3];
		for (int a=0; a<N; a++) {
			String[] str = br.readLine().split(" ");
			for (int b=0; b<3; b++) DP[a][b] = Integer.parseInt(str[b]);
		}
		System.arraycopy(DP[0], 0, max[0], 0, 3);
		for (int i=0; i<N; i++) Arrays.fill(min[i], Integer.MAX_VALUE);
		System.arraycopy(DP[0], 0, min[0], 0, 3);
		for (int a=0; a<N-1; a++) {
			for (int b=0; b<3; b++) {
				for (int t=0; t<3; t++) {
					int nx = a+1;
					int ny = b+go[t];
					if (ny<0||ny>=3) continue;
					max[nx][ny] = Math.max(max[nx][ny], max[a][b]+DP[nx][ny]);
					min[nx][ny] = Math.min(min[nx][ny], min[a][b]+DP[nx][ny]);
				}
			}
		}
		int maxnum = Arrays.stream(max[N-1]).max().getAsInt();
		int minnum = Arrays.stream(min[N-1]).min().getAsInt();
		System.out.println(maxnum+" "+minnum);
		

	}

}
