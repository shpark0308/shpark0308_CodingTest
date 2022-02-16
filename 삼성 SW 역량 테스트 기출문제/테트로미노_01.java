import java.io.*;
import java.util.*;

public class 테트로미노_01 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M=Integer.parseInt(str[1]);
		int[][] Arr = new int[N][M];
		for (int a=0; a<N; a++) {
			str = br.readLine().split(" ");
			for (int b=0; b<M; b++) Arr[a][b] = Integer.parseInt(str[b]);
		}
		
		int maxnum = Integer.MIN_VALUE, count = 0; // 회전과 대칭을 함
		for (int a=0; a<N; a++) {
			for (int b=0; b<M; b++) {
				if (b+3<M) {
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a][b+2]+Arr[a][b+3];
					maxnum = Math.max(maxnum, count);
				}
				if (a+1<N&&b+1<M) {
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a+1][b]+Arr[a+1][b+1];
					maxnum = Math.max(maxnum,count);
				}
				if (a+2<N&&b+1<M) {
					count = 0;
					count = count+Arr[a][b]+Arr[a+1][b]+Arr[a+2][b]+Arr[a+2][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a+1][b]+Arr[a+1][b+1]+Arr[a+2][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a+1][b+1]+Arr[a+2][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b+1]+Arr[a+1][b+1]+Arr[a+2][b]+Arr[a+2][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a+1][b]+Arr[a+2][b]+Arr[a][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b+1]+Arr[a+1][b]+Arr[a+1][b+1]+Arr[a+2][b];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a+1][b]+Arr[a][b+1]+Arr[a+1][b+1]+Arr[a+2][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a+1][b]+Arr[a+2][b]+Arr[a+1][b+1];
					maxnum = Math.max(maxnum, count);
				}
				if (a+1<N&&b+2<M) {
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a][b+2]+Arr[a+1][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b+1]+Arr[a+1][b]+Arr[a+1][b+1]+Arr[a+1][b+2];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b+1]+Arr[a][b+2]+Arr[a+1][b]+Arr[a+1][b+1];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a+1][b+1]+Arr[a+1][b+2];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a][b+2]+Arr[a+1][b];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a+1][b]+Arr[a+1][b+1]+Arr[a+1][b+2]+Arr[a][b+2];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a+1][b]+Arr[a+1][b+1]+Arr[a+1][b+2]+Arr[a][b];
					maxnum = Math.max(maxnum, count);
					count = 0;
					count = count+Arr[a][b]+Arr[a][b+1]+Arr[a][b+2]+Arr[a+1][b+2];
					maxnum = Math.max(maxnum, count);
				}
				if(a+3<N) {
					count=0;
					count = count+Arr[a][b]+Arr[a+1][b]+Arr[a+2][b]+Arr[a+3][b];
					maxnum = Math.max(maxnum, count);
				}
			}
			
		}
		System.out.println(maxnum);
		

	}
	
	public static int[][] tech(int num) {
		int[][] technum;
		switch(num) {
		case 1: technum = new int[1][4]; Arrays.fill(technum[0], 1); break;
		case 2: technum = new int[2][2]; Arrays.fill(technum[0], 1); Arrays.fill(technum[1], 1); break;
		case 3: technum = new int[3][2]; technum[0][0] = 1; technum[1][0] = 1; technum[2][0] = 1; technum[2][1] = 1; break;
		case 4: technum = new int[3][2]; technum[0][0] = 1; technum[1][0] = 1; technum[1][1] = 1; technum[2][1] = 1; break;
		default: technum = new int[2][3]; Arrays.fill(technum[0], 1); technum[1][1] = 1; break;
		}
		return technum;
	}

}
