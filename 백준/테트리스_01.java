package 백준;

import java.util.*;

public class 테트리스_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); int P = sc.nextInt();
		
		int[] Arr = new int[C];
		for (int i=0; i<C; i++) Arr[i] = sc.nextInt();
		
		ArrayList<int[]> block = Block(P);
		int count=0;
		for (int i=0; i<block.size(); i++) {
			int blocksize = block.get(i).length;
			for (int t=0; t<=C-blocksize; t++) {
				int floor_min = Integer.MAX_VALUE;
				for (int k=t; k<t+blocksize; k++) floor_min = Math.min(floor_min, Arr[k]);
				int k=0;
				for (k=t; k<t+blocksize; k++) {
					if ((Arr[k]-floor_min)!=block.get(i)[k-t]) {
						break;
					}
				}
				if (k==(t+blocksize)) count++; // 전부 다 돌았다는 이야기
			}
		}
		System.out.println(count);
	}
	
	public static ArrayList<int[]> Block(int num) {
		ArrayList<int[]> arr = new ArrayList<int[]>();
		/* 필요한 높이를 저장 */
		switch(num) {
		case 1: arr.add(new int[] {0}); arr.add(new int[] {0,0,0,0}); break;
		case 2: arr.add(new int[] {0,0}); break;
		case 3: arr.add(new int[] {0,0,1}); arr.add(new int[] {1,0}); break;
		case 4: arr.add(new int[] {1,0,0}); arr.add(new int[] {0,1}); break;
		case 5: arr.add(new int[] {0,0,0}); arr.add(new int[] {0,1}); arr.add(new int[] {1,0,1}); arr.add(new int[] {1,0}); break;
		case 6: arr.add(new int[] {0,0,0}); arr.add(new int[] {0,0}); arr.add(new int[] {0,1,1}); arr.add(new int[] {2,0}); break;
		default: arr.add(new int[] {0,0,0}); arr.add(new int[] {0,2}); arr.add(new int[] {1,1,0}); arr.add(new int[] {0,0}); break;
		}
		return arr;
	}
	
	/* 높이를 전부 맞추어 줘야함 */
}
