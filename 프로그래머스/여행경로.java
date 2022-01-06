package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class 여행경로_Solution {
	public static ArrayList<String> answer_array = new ArrayList<String>();
	
    public String[] solution(String[][] tickets) {
    	int[] visited = new int[tickets.length];
    	dfs(tickets.length, "ICN",tickets,visited,"ICN");
    	Collections.sort(answer_array);
        return answer_array.get(0).split(" ");
    }
    public static void dfs(int ticketnum, String start, String[][] tickets, int[] visited, String answer) {
    	if (ticketnum==0) {
    		System.out.println(answer);
    		answer_array.add(answer);
    		return;
    	}
    	for (int i=0;i<tickets.length; i++) {
    		if (tickets[i][0].equals(start)&&visited[i]==0) {
    			visited[i]=1;
    			dfs(ticketnum-1, tickets[i][1],tickets, visited, answer+" "+tickets[i][1]);
    			visited[i]=0;
    		}
    	}
    	
    	
    }
}
public class 여행경로 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		여행경로_Solution s = new 여행경로_Solution();
		s.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
		//s.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});

	}

}
