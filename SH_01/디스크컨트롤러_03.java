import java.util.*;

class 디스크컨트롤러_03_Solution {
    public int solution(int[][] jobs) {
    	Arrays.sort(jobs, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			return o1[0]<o2[0]?-1:1;
    		}
		});
    	
    	Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			return o1[1]-o2[1];
    		}
		});
    	int time = 0, sum = 0, index = 0, count = 0;
    	
    	while(count<jobs.length) {
    		for (;index<jobs.length&&jobs[index][0]<=time;index++) {
    			queue.add(jobs[index]);
    		}
    		
    		if (queue.isEmpty()) {
    			time = jobs[index][0];
    		}
    		else {
    			int[] temp = queue.poll();
    			sum = sum + (time - temp[0]) + temp[1];
    			time +=temp[1];
    			count++;
    		}
    	}
        return sum/jobs.length;
    }
}

public class 디스크컨트롤러_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		디스크컨트롤러_03_Solution s = new 디스크컨트롤러_03_Solution();
		//s.solution(new int[][] {{0,3}, {1,9}, {2,6}});
		//s.solution(new int[][] {{0,3}, {11,3}, {10,5}});
		s.solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
		//s.solution(new int[][] {{0,5},{1,2}, {5,5}});

	}

}
