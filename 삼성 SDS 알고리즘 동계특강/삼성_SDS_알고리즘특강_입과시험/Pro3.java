package �Ｚ_SDS_�˰���Ư��_�԰�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pro3 {
	public static ArrayList<Integer> camploc = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=1; i<=T; i++) {
			int N = sc.nextInt();
			System.out.println("N = "+N);
			int[] arr = new int[N];
			int k=0;
			int time=0;
			boolean flag = true;
			for (int a=0; a<N; a++) {
				arr[a] = sc.nextInt();
				if (arr[a]==3) camploc.add(a);
				if (arr[a]==1) k++;
				else k=0;
				if (k==6) {
					flag=false;
					time=-1;
					break;
				}
				
			}
			System.out.println();
			Collections.sort(camploc, Collections.reverseOrder());
			System.out.println(camploc);
			int finalend = camploc.get(0);
			System.out.println("����"+finalend);
			for(int cur = 0; cur<=finalend&&flag; ) {
				int target = checkcamp(cur,cur+15);
				if (cur>target) break;
				System.out.println("�������� �°ǰ�?");
				while(true) {
					System.out.println(">> "+cur+" "+target);
					int a = (cur+6);
					if (a>target) {
						time+=(target-cur);
						cur = target;
						break;
					}
					int pass = cur;
					for (a=(cur+6); a>cur; a--) {
						if (arr[a]==2) {
							time=time+(a-cur)+1; // 1�ð� �� Ǯ��
							cur=a;
							break;
						}
						if (a==target) {
							System.out.println("�������� ���°Ŵ�?");
							time+=(a-cur);
							cur=a;
							break;
						}
					}
					if (a<=pass) {
						System.out.println("����� ����?");
						int temp = target;
						target = checkcamp(cur,temp);
						if (cur>target) {
							flag = false;
							break;
						}
						camploc.add(temp);
						Collections.sort(camploc, Collections.reverseOrder());
					}
				}
				System.out.println("TIME = "+time);
			}
			System.out.println(flag);
			if (flag) System.out.println("#"+i+" "+time);
			else System.out.println("#"+i+" "+-1);
			camploc.clear();
		}
	}
	public static int checkcamp(int cur, int end) {
		for (int i=0; i<camploc.size();i++) {
			if (camploc.get(i)<=end) {
				int index = camploc.get(i);
				camploc.remove(i);
				return index;
			}
		}
		return -1;
	}
}