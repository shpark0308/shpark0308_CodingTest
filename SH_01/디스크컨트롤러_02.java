import java.util.*;

class Disk{
	int start, consume;
	public Disk(int start, int consume){
		this.start = start; this.consume = consume;
	}
	

}
class 디스크컨트롤러_02_Solution {
    public int solution(int[][] jobs) {
    	Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
    	ArrayList<Disk> joblist = new ArrayList<Disk>();
    	
    	int time = 0, sum = 0, index = 0;
    	while(true) {
    		if (joblist.isEmpty()) {
    			if (index == jobs.length) break;
    			time = (time<jobs[index][0])?jobs[index][0]:time;
    			for (; index<jobs.length && jobs[index][0]<=time; index++) {
    				joblist.add(new Disk(jobs[index][0], jobs[index][1]));
    			}
    			Collections.sort(joblist, new Comparator<Disk>() {

					@Override
					public int compare(Disk o1, Disk o2) {
						// TODO Auto-generated method stub
						return (o1.start+o1.consume)<(o2.start+o2.consume)?-1:1;
					}
				});
    			for (Disk disk:joblist) {
    				System.out.print("["+disk.start+", "+disk.consume+"] ");
    			}
    			System.out.println("--------------------");
    		}
    		Disk Disk = joblist.get(0);
    		sum = sum + (time-Disk.start) + Disk.consume;
    		time+=Disk.consume;
    		System.out.println("++++++++     ["+Disk.start+","+Disk.consume+"] "+(time-Disk.start)+" = "+time+" SUM "+sum);
    		joblist.remove(0);
        	
    		
    	}
    	System.out.println(sum/jobs.length);
    	
        int answer = 0;
        return answer;
    }
}

public class 디스크컨트롤러_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		디스크컨트롤러_02_Solution s = new 디스크컨트롤러_02_Solution();
		//s.solution(new int[][] {{0,3}, {1,9}, {2,6}});
		//s.solution(new int[][] {{0,3}, {11,3}, {10,5}});
		s.solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
		//s.solution(new int[][] {{0,5},{1,2}, {5,5}});

	}

}
