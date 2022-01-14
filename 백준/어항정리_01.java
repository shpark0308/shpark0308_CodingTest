package 백준;

import java.util.*;

public class 어항정리_01 {
	public static int N, K;
	public static int[] fish;
	public static int[] go_X = { 1, 0};
	public static int[] go_Y = { 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt();
		fish = new int[N];
		for (int i=0; i<N; i++) fish[i] = sc.nextInt();
		int count=0;
		while(true) {
			count++;
			FirstStep();
			fish = FourthStep(ThirdStep(SecondStep()));
			if ((Arrays.stream(fish).max().getAsInt()-Arrays.stream(fish).min().getAsInt())<=K){
				break;
			}
		}
		System.out.println(count);
		
		
		
	}
	
	public static void FirstStep() { // 가장 적은 어항에 물고리 추가
		int min = Arrays.stream(fish).min().getAsInt();
		for (int i=0; i<N; i++) {
			if (fish[i]==min) fish[i]++;
		}
	}
	public static int[][] SecondStep() { // int[][] fish2 생산
		int[][] fish2 = new int[2][N-1];
		fish2[0][0] = fish[0];
		System.arraycopy(fish, 1, fish2[1], 0, N-1);
		
		int[][] fish3;
		/* 90도 회전하기 */
		while(true) {
			int totalrow = fish2.length-2, row=0, col = fish2.length;
			for (int i=0; i<fish2[0].length; i++) {
				if (fish2[totalrow][i]!=0) row++;
			}
			if (fish2[0].length-row<col) break;
			fish3 = new int[row+1][fish2[0].length-row]; // 마지막 바닥 + 1
			System.arraycopy(fish2[fish2.length-1], row, fish3[fish3.length-1], 0, fish3[0].length);
			for (int a=row-1; a>=0; a--) { // fish2 -> fish3로 옮기는 방법
				for (int b=0; b<col; b++) {
					fish3[a][col-1-b] = fish2[b][a];
				}
			}
			fish2 = new int[fish3.length][fish3[0].length];
			for (int k=0; k<fish3.length;k++) System.arraycopy(fish3[k], 0, fish2[k], 0, fish2[k].length);
			System.out.println("============================");
			for (int k=0; k<fish2.length;k++) {
				System.out.println(Arrays.toString(fish2[k]));
			}
			
		}
		return fish2;
	}
	public static int[][] ThirdStep(int[][] fish2) {
		System.out.println("{{ ThirdStep }}");
		int[][] calc = new int[fish2.length][fish2[0].length];
		for (int a=0; a<fish2.length;a++) {
			for (int b=0; b<fish2[0].length; b++) {
				if (fish2[a][b]==0) continue;
				for (int i=0; i<2; i++) {
					int nx = a+go_X[i];
					int ny = b+go_Y[i];
					if (nx<0||nx>=fish2.length||ny<0||ny>=fish2[0].length) continue;
					if (fish2[nx][ny]==0) continue; // -1로 둘지 고민해보기
					int maxnum, minnum, max_x, max_y, min_x, min_y;
					if (fish2[a][b]>=fish2[nx][ny]) {
						maxnum = fish2[a][b]; minnum = fish2[nx][ny];
						max_x = a; max_y = b; min_x = nx; min_y = ny;
					}
					else {
						maxnum = fish2[a][b]; minnum = fish2[nx][ny];
						max_x = a; max_y = b; min_x = nx; min_y = ny;
					}
					int sub = (maxnum-minnum)/5;
					calc[max_x][max_y] -=sub; calc[min_x][min_y] +=sub;
				}
			}
		}
		System.out.println("-----------------------------------");
		for (int a=0; a<fish2.length;a++) {
			for (int b=0; b<fish2[0].length; b++) {
				if (calc[a][b]==0) continue;
				fish2[a][b]+=calc[a][b];
			}
			System.out.println(Arrays.toString(fish2[a]));
		}
		return fish2;
	}
	public static int[] FourthStep(int[][] fish2) {
		int[] fish3 = new int[N];
		int index=0;
		for (int b=0; b<fish2[0].length; b++) {
			for (int a=fish2.length-1; a>=0; a--) {
				if (fish2[a][b]==0) continue;
				fish3[index++] = fish2[a][b];
			}
		}
		System.out.println("{ Fourth Step }");
		System.out.println(">> "+Arrays.toString(fish3));
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		int[][] fish4 = new int[2][N/2];
		for (int a=0; a<N/2; a++) fish4[0][N/2-1-a] = fish3[a];
		System.arraycopy(fish3, N/2, fish4[1], 0, N/2);
		
		int[][] fish5 = new int[4][N/4];
		for (int a=0; a<2; a++) {
			for (int b=0; b<N/4; b++) {
				fish5[1-a][N/4-1-b] = fish4[a][b];
			}
		}
		System.arraycopy(fish4[0], N/4, fish5[2], 0, N/4);
		System.arraycopy(fish4[1], N/4, fish5[3], 0, N/4);
		
		for (int a=0; a<4; a++) {
			System.out.println(Arrays.toString(fish5[a]));
		}
		
		int[][] fish6 = ThirdStep(fish5);
		
		index=0;
		for (int b=0; b<fish6[0].length; b++) {
			for (int a=fish6.length-1; a>=0; a--) {
				fish3[index++] = fish6[a][b];
			}
		}
		return fish3;
		
	}

}
