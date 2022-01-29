package 동적계획법01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열2_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N];
		for (int i=0; i<N; i++) number[i] = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(Integer.MIN_VALUE);
		for (int i=0; i<N; i++) {
			if (array.get(array.size()-1)<number[i]) array.add(number[i]); // 그냥 추가만 하면 됨
			else { /* 이분 탐색 검색 */
				int left = 0, right = array.size()-1;
				while(left<right) {
					int mid = (left+right)/2;
					if (array.get(mid)>=number[i]) right=mid;
					else left = mid+1;
					
				}
				System.out.println("left = "+left +" right = "+right);
				array.set(right, number[i]);
			}
			System.out.println(array);
		}
		System.out.println(array.size()-1);

	}

}
