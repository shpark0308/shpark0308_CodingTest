package 동적계획법01;

import java.util.ArrayList;
import java.util.Scanner;

public class 가장긴증가하는부분수열3_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(Integer.MIN_VALUE);
		for (int i=0; i<N; i++) {
			int value = sc.nextInt();
			if (array.get(array.size()-1)<value) array.add(value);
			else {
				int left = 0, right = array.size()-1;
				while(left<right) {
					int mid = (left+right)/2;
					if (array.get(mid)>=value) right=mid;
					else left = mid+1;
				}
				System.out.println("left : "+left+" right : "+right);
				array.set(right, value);
				System.out.println(array);
			}
		}
		System.out.println(array.size()-1);
		for (int i=1; i<array.size(); i++) System.out.print(array.get(i)+" ");
	}

}
