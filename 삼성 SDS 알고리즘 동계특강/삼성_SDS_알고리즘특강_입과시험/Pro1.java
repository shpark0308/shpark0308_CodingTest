package 삼성_SDS_알고리즘특강_입과시험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Pro1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			ArrayList<Integer> odd = new ArrayList<Integer>(); odd.add(-1);
			ArrayList<Integer> even = new ArrayList<Integer>(); even.add(-1);
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for (int a=0; a<N; a++) {
				int num = Integer.parseInt(str[a]);
				if (num%2==0) even.add(num);
				else odd.add(num);
			}
			Collections.sort(even, Collections.reverseOrder());
			Collections.sort(odd, Collections.reverseOrder());
			int count = 0;
			for (int b=0; b<(N/2);b++) {
				if (even.get(0)>=odd.get(0)) {
					int n1 = even.get(0);
					even.remove(0);
					if (even.size()>1) {
						even.remove(even.size()-2);
						count+=n1;
					}
					else { // 일단 이 경우의 수를 뽑아보기
						count+=odd.get(0);
						odd.remove(0);
					}
				}
				else {
					int n1 = odd.get(0);
					odd.remove(0);
					if (odd.size()>1){
						odd.remove(odd.size()-2);
						count+=n1;
					}
					else { // 일단 이 경우의 수를 뽑아보기
						count+=even.get(0);
						even.remove(0);
					}
				}
			}
			System.out.println("#"+i+" "+count);
		}

	}

}
