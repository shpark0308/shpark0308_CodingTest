import java.util.*;

class ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk implements Comparable<��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk>{
	int start, consume;
	public ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk(int start, int consume) {
		this.start = start; this.consume = consume;
	}
	
	@Override
	public int compareTo(��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk o) {
		return (this.start+this.consume)<o.start+o.consume?-1:1;
		
	}
}

class ��ũ��Ʈ�ѷ�_01_Solution {
    public int solution(int[][] jobs) {
    	/* �ϴ� �غ��� */
    	Queue<��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk> queue = new PriorityQueue<��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk>();
    	
    	for (int i=0; i<jobs.length; i++) {
    		queue.add(new ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk(jobs[i][0], jobs[i][1]));
    	}
    	int time = 0;
    	int sum = 0;
    	while(!queue.isEmpty()) {
    		��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk = queue.poll();
    		System.out.println(��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.start+" / "+��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.consume);
    		if (��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.start - time > 0) time = ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.start;
    		sum = sum + (time - ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.start) + ��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.consume; // ��ٸ� �ð� + �ɸ� �ð�
    		time+=��ũ��Ʈ�ѷ�_01_��ũ��Ʈ�ѷ�_01_Disk.consume;
    		//System.out.println(">>  SUM = "+sum+" / "+time);
    		
    	}
    	System.out.println("sum = "+sum+" time = "+time);
        int answer = sum / jobs.length;
        System.out.println("������ = "+answer);
        return answer;
    }
}

public class ��ũ��Ʈ�ѷ�_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		��ũ��Ʈ�ѷ�_01_Solution s = new ��ũ��Ʈ�ѷ�_01_Solution();
		//s.solution(new int[][] {{0,3}, {1,9}, {2,6}});
		//s.solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}});
		s.solution(new int[][] {{0,5},{1,2}, {5,5}});
	}

}
