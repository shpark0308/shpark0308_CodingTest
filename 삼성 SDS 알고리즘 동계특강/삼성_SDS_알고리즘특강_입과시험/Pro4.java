package 삼성_SDS_알고리즘특강_입과시험;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pro4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Integer> A = new LinkedList<Integer>();
		Queue<Integer> B = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] visited = new int[N+1]; // 아무도 거점을 안하면 0 A : 1, B : 2, 모두 : 3
			A.add(sc.nextInt());
			B.add(sc.nextInt()); // 연결 노선을 만들어 주기
			int A_count=0, B_count=0;
			System.out.println("N = "+N+" M = "+M+" A = "+A.peek()+" B"+B.peek());
			for (int a=0; a<=N; a++) arr.add(new ArrayList<Integer>());
			for (int b=0; b<M; b++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr.get(start).add(end);
				arr.get(end).add(start);
			}
			System.out.println(arr);
			while(!A.isEmpty()&&!B.isEmpty()) { // 더이상 못갈때까지 조건문 달아주기
				System.out.println("A: "+A);
				System.out.println("B: "+B);
				int A_size = A.size();
				for (int a=0; a<A_size; a++) {
					int node = A.poll(); // 만약에 A가 갈 수 있는 곳을 다 갔다면
					if (visited[node]==1||visited[node]==3) continue;
					else if (visited[node]==2) {
						/*visited[node]=3;
						B_count--;*/
						continue;
					}
					ar.add(node);
					visited[node]=1;
					A_count++;
					for (int p=0; p<arr.get(node).size();p++) {
						int temp = arr.get(node).get(p);
						if (visited[temp]==0) {
							A.add(temp);
						}
					}
				}
				System.out.println("라라 "+Arrays.toString(visited));
				System.out.println("A_count = "+A_count+" B_count = "+B_count);
				int B_size = B.size();
				for (int b=0; b<B_size; b++) {
					int node = B.poll();
					if (visited[node]==2||visited[node]==3) continue;
					else if (visited[node]==1) {
						if (ar.contains(node)) {
							visited[node]=3;
							A_count--;
						}
						continue;
					}
					visited[node]=2;
					B_count++;
					for (int q=0; q<arr.get(node).size();q++) {
						int temp = arr.get(node).get(q);
						if (visited[temp]==0) {
							B.add(temp);
						}
					}
				}
				ar.clear();
				System.out.println(Arrays.toString(visited));
				System.out.println("A_count = "+A_count+" B_count = "+B_count);
				System.out.println("---------------------");
			}
			int count1=0, count2=0, nn = N/2 + 1;
			for (int v=1; v<visited.length;v++) {
				if (visited[v]==0) count1++;
				else if(visited[v]==3) count2++;
			}
			System.out.println(Arrays.toString(visited)+"    "+N+"  "+count1+"  "+count2+"  "+A_count+"  "+B_count);
			if (A_count>B_count&&A_count>=nn) {
				System.out.println("#"+i+" "+count2+" "+0);
			}
			else {
				int ness = (B_count-A_count)+1 >= (nn- A_count) ?  (B_count-A_count)+1 : (nn- A_count);
				if (ness>=0) {
					if (ness>(count1+count2)) System.out.println("#"+i+" "+count2+" "+-1);
					else System.out.println("#"+i+" "+count2+" "+ness);
				}
				else {
					System.out.println("#"+i+" "+count2+" "+0);
				}
			}
			
			
			
			A.clear(); B.clear(); arr.clear();
		}

	}

}
