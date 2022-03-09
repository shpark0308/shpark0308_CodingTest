
import java.util.*;
import java.io.*;

public class 행렬교환_01 {
	/* 무식하게 하기 */
	public static int N, M;
	public static int[][] A, B, C;
	public static int flag=-1, totalcount;
	public static int[] go_X = { -1, 1, 0, 0};
	public static int[] go_Y = { 0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); M = Integer.parseInt(str[1]);
		
		A = new int[N][M]; B = new int[N][M]; C = new int[N][M];
		
		for (int a=0; a<N; a++) {
			str = br.readLine().split("");
			for (int b=0; b<M; b++) A[a][b] = Integer.parseInt(str[b]);
		}
		
		for (int a=0; a<N; a++) {
			str = br.readLine().split("");
			for (int b=0; b<M; b++) B[a][b] = Integer.parseInt(str[b]);
		}
		
		for (int a=0; a<N; a++) {
			str = br.readLine().split("");
			for (int b=0; b<M; b++) C[a][b] = Integer.parseInt(str[b]);
			totalcount+=Arrays.stream(C[a]).sum();
		}
		find(0);
		if (flag==-1) System.out.println(flag);

	}
	
	public static void find(int count) {
		if (count>totalcount) {
			System.out.println("나 여기야?");
			System.out.println(-1);
			System.exit(0);
		}
		if (isCheck()) { /* 최소 연산 횟수인지 점검 */ // 만약에 찾지 못했을 경우 어떻게 해야하는지
			System.out.println("{ A }");
			for (int a=0; a<N; a++) {
				System.out.println(Arrays.toString(A[a]));
			}
			System.out.println("-------------");
			
			System.out.println(count);
			System.exit(0);
			return;
		}
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				if (A[a][b]==1&&C[a][b]>0) {
					for (int d=0; d<4; d++) {
						int nx = a + go_X[d];
						int ny = b + go_Y[d];
						if (nx<0||nx>=N||ny<0||ny>=M) continue;
						else if (A[nx][ny]==1||C[nx][ny]==0) continue;
						
						int temp = A[a][b];
						A[a][b] = A[nx][ny];
						A[nx][ny] = temp;
						
						
						C[a][b]--; C[nx][ny]--;
						find(count+1);
						C[a][b]++; C[nx][ny]++;
						
						temp = A[nx][ny];
						A[nx][ny] = A[a][b];
						A[a][b] = temp;
					}
				}
			}
		}
	}
	
	public static boolean isCheck() {
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				if (A[a][b]!=B[a][b]) return false;
			}
			
		}
		return true;
	}

}
