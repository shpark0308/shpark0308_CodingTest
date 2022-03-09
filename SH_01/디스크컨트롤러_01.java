import java.util.*;

class 디스크컨트롤러_01_디스크컨트롤러_01_Disk implements Comparable<디스크컨트롤러_01_디스크컨트롤러_01_Disk>{
	int start, consume;
	public 디스크컨트롤러_01_디스크컨트롤러_01_Disk(int start, int consume) {
		this.start = start; this.consume = consume;
	}
	
	@Override
	public int compareTo(디스크컨트롤러_01_디스크컨트롤러_01_Disk o) {
		return (this.start+this.consume)<o.start+o.consume?-1:1;
		
	}
}

class 디스크컨트롤러_01_Solution {
    public int solution(int[][] jobs) {
    	/* 일단 해보기 */
    	Queue<디스크컨트롤러_01_디스크컨트롤러_01_Disk> queue = new PriorityQueue<디스크컨트롤러_01_디스크컨트롤러_01_Disk>();
    	
    	for (int i=0; i<jobs.length; i++) {
    		queue.add(new 디스크컨트롤러_01_디스크컨트롤러_01_Disk(jobs[i][0], jobs[i][1]));
    	}
    	int time = 0;
    	int sum = 0;
    	while(!queue.isEmpty()) {
    		디스크컨트롤러_01_디스크컨트롤러_01_Disk 디스크컨트롤러_01_디스크컨트롤러_01_Disk = queue.poll();
    		System.out.println(디스크컨트롤러_01_디스크컨트롤러_01_Disk.start+" / "+디스크컨트롤러_01_디스크컨트롤러_01_Disk.consume);
    		if (디스크컨트롤러_01_디스크컨트롤러_01_Disk.start - time > 0) time = 디스크컨트롤러_01_디스크컨트롤러_01_Disk.start;
    		sum = sum + (time - 디스크컨트롤러_01_디스크컨트롤러_01_Disk.start) + 디스크컨트롤러_01_디스크컨트롤러_01_Disk.consume; // 기다린 시간 + 걸린 시간
    		time+=디스크컨트롤러_01_디스크컨트롤러_01_Disk.consume;
    		//System.out.println(">>  SUM = "+sum+" / "+time);
    		
    	}
    	System.out.println("sum = "+sum+" time = "+time);
        int answer = sum / jobs.length;
        System.out.println("정답은 = "+answer);
        return answer;
    }
}

public class 디스크컨트롤러_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		디스크컨트롤러_01_Solution s = new 디스크컨트롤러_01_Solution();
		//s.solution(new int[][] {{0,3}, {1,9}, {2,6}});
		//s.solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
		s.solution(new int[][] {{0,5},{1,2}, {5,5}});
	}

}
