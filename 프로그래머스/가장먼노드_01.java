package 프로그래머스;

import java.util.*;

class 가장먼노드_01_Solution {
    public int solution(int n, int[][] edge) {
    	ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
    	for (int i=0; i<=n; i++) array.add(new ArrayList<Integer>());
    	for (int a=0; a<edge.length;a++) {
    		array.get(edge[a][0]).add(edge[a][1]);
    		array.get(edge[a][1]).add(edge[a][0]);
    	}
    	int[] DP = new int[n+1], visited = new int[n+1];
    	Arrays.fill(DP, Integer.MAX_VALUE);
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(1); visited[1]=1; DP[1]=0;
    	
    	int time = 0;
    	while(!queue.isEmpty()) {
    		time++;
    		int size = queue.size();
    		for (int i=0; i<size; i++) {
    			int num = queue.poll();
    			for (int k=0; k<array.get(num).size(); k++) {
    				int temp = array.get(num).get(k);
    				if (visited[temp]==0) {
    					visited[temp] = 1;
    					DP[temp] = time;
    					queue.add(temp);
    				}
    			}
    		}
    		System.out.println(Arrays.toString(DP));
    	}
    	DP[0] = -1;
    	int answer = 0;
    	int maxnum = Arrays.stream(DP).max().getAsInt();
    	Arrays.sort(DP);
    	for (int i=n; i>=0; i--) {
    		if (DP[i]==maxnum) answer++;
    		if (DP[i]!=maxnum) break;
    	}
    	System.out.println("answer = "+answer);
        return answer;
    }
}
public class 가장먼노드_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		가장먼노드_01_Solution s = new 가장먼노드_01_Solution();
		s.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		

	}

}
